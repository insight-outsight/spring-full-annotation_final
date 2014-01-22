package org.selffun.sfa.models;

import java.io.Serializable;

public class TreeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1228334531903534517L;
	
	private long id;
	private int nodeId;
	private int parentId;
	private int position;
	private String title;
	private int type;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNodeId() {
		return nodeId;
	}
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
