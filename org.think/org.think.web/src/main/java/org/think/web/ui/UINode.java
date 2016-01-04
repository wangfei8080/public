package org.think.web.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author WangFei
 *
 * 2016年1月4日 下午6:15:37
 *
 */
public class UINode {

	private String id;
	
	private String name;
	
	private String image;
	
	private String url;
	
	private int order;
	
	private String parentId;

	private List<UINode> chileds = new ArrayList<UINode>();
	
	private Comparator<? super UINode> comparator = new Comparator<UINode>() {
		@Override
		public int compare(UINode n1, UINode n2) {
			if(n1.getOrder()>n2.getOrder()){
				return 1;
			}else if(n1.getOrder()==n2.getOrder()){
				return 0;
			}else{
				return -1;
			}
	}};
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<UINode> getChileds() {
		Collections.sort(chileds, comparator);
		return Collections.unmodifiableList(chileds);
	}

	public void addChileds(List<UINode> nodes){
		this.chileds.addAll(nodes);
	}
	
	public void addChileds(UINode node) {
		this.chileds.add(node);
	}

	@Override
	public String toString() {
		return "id:"+this.getId()+"name:"+this.getName()+"url:"+this.getUrl()+"order:"+this.getOrder()+"image:"+this.getImage();
	}
	
}

