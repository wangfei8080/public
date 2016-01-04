package org.think.web.ui.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentException;
import org.think.web.ui.UINode;
import org.think.web.ui.UserInterface;



/**
 * 
 * @author WangFei
 *
 * 2016年1月4日 下午6:14:48
 *
 */
public class WebAppService implements UserInterface{
	
	private static final Log logger = LogFactory.getLog(WebAppService.class);

	/**
	 * 默认读取web bundle的该目录的xml文件，解析该web bundle发布到主页面上的页面
	 */
	private static final String UI_CONFIG_URI="/META-INF/uiconfig/uiconfig.xml";
	
	/**
	 * 缓冲已经处于活动状态下的servletcontext
	 */
	private Map<String,ServletContext> servletContext = new java.util.concurrent.ConcurrentHashMap<String,ServletContext>();
	
	private List<UINode> trees = new ArrayList<UINode>();
	
	public void putServletContext(ServletContext context){
		if(context.getContextPath().startsWith("/think")){
			if(!hasServletContext(context)){
				logger.info("add servletContext:"+context.getContextPath());
				servletContext.put(context.getContextPath(), context);
			}
		}
		flash();
	}
	
	public void removeServletContext(ServletContext context){
		logger.info("remove servletContext:"+context.getContextPath());
		servletContext.remove(context.getContextPath());
		flash();
	}
	
	private boolean hasServletContext(ServletContext context){
		return context.equals(servletContext.get(context.getContextPath()));
	}
	
	private void create(){
		logger.info("servletContext:"+servletContext);
		Set<String> keys = servletContext.keySet();
		for(String key : keys){
			ServletContext context = servletContext.get(key);
			try {
				URL url = context.getResource(UI_CONFIG_URI);
				if(url!=null){
					InterfaceUiXmlDomHandel xmlHandel = new InterfaceUiXmlDomHandel(url.openStream());
					trees.addAll(xmlHandel.getTree());
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<UINode> getTree() {
		return trees;
	}
	
	/**
	 * 刷新UI
	 */
	private void flash(){
		trees.clear();
		create();
	}
}
