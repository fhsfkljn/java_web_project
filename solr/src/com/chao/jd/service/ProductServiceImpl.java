package com.chao.jd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chao.jd.po.Products;
import com.chao.jd.po.ResultModel;

@Service
public class ProductServiceImpl implements ProductService {

	// ����ע��HttpSolrServer
	@Autowired
	private HttpSolrServer server;

	public ResultModel getProducts(String queryString, String catalogName, String price, String sort, Integer page)
			throws Exception {
		// ����SolrQuery����
		SolrQuery query = new SolrQuery();

		// ����ؼ���
		if (StringUtils.isNotEmpty(queryString)) {
			query.setQuery(queryString);
		} else {
			query.setQuery("*:*");
		}

		// ������Ʒ�����������
		if (StringUtils.isNotEmpty(catalogName)) {
			query.addFilterQuery("product_catalog_name:" + catalogName);
		}

		// ����۸������������
		// price��ֵ��0-9 10-19
		if (StringUtils.isNotEmpty(price)) {
			String[] ss = price.split("-");
			if (ss.length == 2) {
				query.addFilterQuery("product_price:[" + ss[0] + " TO " + ss[1] + "]");
			}
		}

		// ��������
		if ("1".equals(sort)) {
			query.setSort("product_price", ORDER.desc);
		} else {
			query.setSort("product_price", ORDER.asc);
		}

		// ���÷�ҳ��Ϣ
		if (page == null)
			page = 1;
		query.setStart((page - 1) * 20);
		query.setRows(20);

		// ����Ĭ����
		query.set("df", "product_keywords");

		// ���ø�����Ϣ
		query.setHighlight(true);
		query.addHighlightField("product_name");
		query.setHighlightSimplePre("<font style=\"color:red\" >");
		query.setHighlightSimplePost("</font>");

		// ��ѯ
		QueryResponse response = server.query(query);
		// ��ѯ���Ľ��
		SolrDocumentList results = response.getResults();
		// ��¼����
		long count = results.getNumFound();

		List<Products> products = new ArrayList<Products>();
		Products prod;

		// ��ȡ������Ϣ
		Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();

		for (SolrDocument doc : results) {
			prod = new Products();

			// ��ƷID
			prod.setPid(doc.get("id").toString());

			List<String> list = highlighting.get(doc.get("id")).get("product_name");
			// ��Ʒ����
			if (list != null)
				prod.setName(list.get(0));
			else {
				prod.setName(doc.get("product_name").toString());
			}

			// ��Ʒ�۸�
			prod.setPrice(Float.parseFloat(doc.get("product_price").toString()));
			// ��ƷͼƬ��ַ
			prod.setPicture(doc.get("product_picture").toString());

			products.add(prod);
		}

		// ��װResultModel����
		ResultModel rm = new ResultModel();
		rm.setProductList(products);
		rm.setCurPage(page);
		rm.setRecordCount(count);

		int pageCount = (int) (count / 20);

		if (count % 20 > 0)
			pageCount++;
		// ������ҳ��
		rm.setPageCount(pageCount);

		return rm;
	}

}
