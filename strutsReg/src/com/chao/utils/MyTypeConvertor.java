package com.chao.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
/**
 * ����
 * 	  �ѱ��е�MM/dd/yyyy��ʽ������ת����������
 *   �����ݿ��еı������ڸ�ʽ��ת��MM/dd/yyyy��ʽ���
 * 
 * �Զ�������ת������
 * 	��һ������дһ���࣬�̳���StrutsTypeConverter��ʵ��convertFromString��convertToString���󷽷�
 * @author zhy
 *
 */
public class MyTypeConvertor extends StrutsTypeConverter {
	
	//����һ������ת����
	private DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	/**
	 * ���ַ��������е�����ת����������
	 * 
	 * ����������⣺
	 * 	Map context����OGNL�������Ķ���������ʱ��֪����������ʱҲ����
	 *  String[] values��Ҫת��������
	 *  Class toClass��Ŀ������
	 */
	public Object convertFromString(Map context, String[] values, Class toClass) {
		//1.�ȿ�����û������
		if(values == null || values.length == 0){
			return null;
		}
		//2.ȡ�������еĵ�һ��Ԫ��
		String date = values[0];
		//3.�ж�Ŀ�����͵��ֽ����ǲ�����������
		if(toClass == java.util.Date.class){
			try {
				//4.ʹ��DateFormat����ת�������ҷ���ת����Ľ��
				return format.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	/**
	 * ���������͵�����ת�����ַ���
	 * 
	 * ����������⣺
	 * 	Map context����OGNL�������Ķ���������ʱ��֪����������ʱҲ����
	 *  Object o��Ҫת��������
	 */
	public String convertToString(Map context, Object o) {
		//1.�ж�object�ǲ�����������
		if(o instanceof Date){
			Date date = (Date)o;
			//2.���������ͣ�ʹ��ת����ת��ָ����ʽ���ַ�����������
			return format.format(date);
		}
		return null;
	}

}
