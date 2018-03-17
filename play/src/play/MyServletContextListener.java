package play;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

//通过实现ServletContextListener接口对ServletContext实行监听(创建与销毁)
public class MyServletContextListener implements ServletContextListener {

	@Override
	//ServletContext创建时执行此方法
	public void contextInitialized(ServletContextEvent sce) {
		//通过事件源获得ServletContext对象
		ServletContext application = sce.getServletContext();
		//创建一个用于存储所有session对象的list集合，由于考虑到并发访问的情况，需要线程安全
		final List<HttpSession> list = Collections.synchronizedList(new ArrayList<HttpSession>());
		//将list集合放入application域中
		application.setAttribute("sessions", list);
		
		//创建一个计时器对象，用于定时删除session
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					HttpSession session = (HttpSession) iterator.next();
					long l = System.currentTimeMillis() - session.getLastAccessedTime();
					if(l>5000){
						session.invalidate();
						iterator.remove();
					}
				}
			}
		}, 2000, 5000);
		
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("销毁了一个ServletContext：" + sce.getServletContext().getServerInfo());
	}

}
