package org.think.web.ui.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.think.web.ui.UINode;



/**
 * 
 * @author WangFei
 *
 * 2016年1月4日 下午6:15:11
 *
 */
public class InterfaceUiXmlDomHandel {

	private Document document;
	
	/**
	 * 页面左侧tree
	 */
	private List<UINode> trees = new ArrayList<UINode>();
	
	public InterfaceUiXmlDomHandel(InputStream inputStream) throws DocumentException{
		SAXReader read = new SAXReader();
		document = read.read(inputStream);
		Element element = document.getRootElement();
		@SuppressWarnings("unchecked")
		Iterator<Element> es = element.elementIterator();
		while(es.hasNext()){
			Element e = es.next();
			if("Root".equals(e.getName())){
				UINode node = createUINode(e);
				recursion(e,node);
				trees.add(node);
			}
		}
	}
	
	
	public List<UINode> getTree(){
		return Collections.unmodifiableList(trees);
	}

	/**
	 * 递归解析xml的node节点(支持tree的无线级数)
	 * @param element
	 * @param node
	 */
	private void recursion(Element element,UINode node){
		@SuppressWarnings("unchecked")
		Iterator<Element> childs = element.elementIterator();
		if(childs!=null&&childs.hasNext()){
			while(childs.hasNext()){
				Element e = childs.next();
				if("node".equals(e.getName())){
					UINode child = createUINode(e);
					node.addChileds(child);
					recursion(e,child);
				}
			}
		}
	}
	
	
	private UINode createUINode(Element element){
		UINode node = new UINode();
		node.setId(element.attributeValue("id"));
		node.setImage(element.attributeValue("image"));
		node.setName(element.attributeValue("name"));
		node.setUrl(element.attributeValue("url"));
		try {
			node.setOrder(Integer.valueOf(element.attributeValue("order")));
		} catch (NumberFormatException e) {
			node.setOrder(1000);
		}
		return node;
	}
	
}
