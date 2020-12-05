package com.kaysanshi.map;
/**
 * 顶点类
 * @author Administrator
 *
 */
public class Vertex {
	public char label;
	//是否被访问过
	public boolean wasVisited=false;
	
	public Vertex(char label) {
		this.label = label;
	}
	
}
