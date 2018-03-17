package play;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//通过实现HttpSessionListener接口对MySessionListener实行监听(创建与销毁)
public class MySessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		//通过事件源获得HttpSession对象
		HttpSession session = se.getSession();
		//通过session获得ServletContext对象
		ServletContext application = session.getServletContext();
		//将session放入集合中
		List<HttpSession> list = (List<HttpSession>) application.getAttribute("sessions");
		list.add(session);
		
		System.out.println("创建了一个新的session：" + session.getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("销毁了一个session：" + se.getSession().getId());
	}

}
