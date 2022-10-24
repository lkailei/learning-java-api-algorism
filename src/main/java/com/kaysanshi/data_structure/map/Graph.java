package com.kaysanshi.data_structure.map;

import com.kaysanshi.data_structure.testArray.Stack;

/**
 * 图:
 * 图是一种和树想象的数据结构，通常有固定的形状
 * 
 * 图是由顶点的有穷非空集合和顶点之间边的集合组成，通过表示为G(V,E)，其中，G标示一个图，V是图G中顶点的集合，E是图G中边的集合。
 *      无边图：若顶点Vi到Vj之间的边没有方向，则称这条边为无项边（Edge），用序偶对(Vi,Vj)标示。
 *      对于下图无向图G1来说，G1=(V1, {E1})，其中顶点集合V1={A,B,C,D}；
 *      边集合E1={(A,B),(B,C),(C,D),(D,A),(A,C)}:
 *有向图：若从顶点Vi到Vj的边是有方向的，则成这条边为有向边，也称为弧（Arc）。
 *用有序对（Vi，Vj）标示，Vi称为弧尾，Vj称为弧头。如果任意两条边之间都是有向的，则称该图为有向图。   
 *图的存储结构：
 *	邻接矩阵：
 *  邻接表：   
 * 图的遍历：
 * 定义：从图中某个顶点出发访遍图中其余顶点，且使每个顶点仅被访问依次，这一过程叫做图的遍历.
         遍历方法： 深度优先遍历和广度优先遍历
         深度优先遍历
          图中某个顶点出发v出发，访问此顶点，然后从v的未被访问的邻接点出发深度优先便利图，知道图中所有和v有相同路径的顶点都被访问
  广度优先遍历
             广度优先遍历（Breadth_First_Search）又称为广度优先搜索，简称BFS。 
  **/
public class Graph {
	//顶点数组
	private Vertex[] vertexList;
	//邻接矩阵
	private int[][] adjMat;
	//顶点的最大数目
	private int maxSize = 20;
	//当前顶点
	private int nVertex;
	//栈
	private Stack stack;
	
	public Graph() {
		vertexList = new Vertex[maxSize];
		adjMat = new int[maxSize][maxSize];
		for(int i = 0; i < maxSize; i++) {
			for(int j = 0; j < maxSize; j++) {
				adjMat[i][j] = 0;
			}
		}
		nVertex = 0;
		stack = new Stack();
	}
	
	/**
	 * 添加顶点
	 */
	public void addVertex(char label) {
		vertexList[nVertex++] = new Vertex(label);
	}
	
	/**
	 * 添加边
	 */
	public void addEdge(int start,int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	/**
	 * 获得邻接的并且没有访问过的节点
	 * @param v ：要找的节点
	 * @return
	 */
	public int getadjUnvisitedVertex(int v) {
		for(int i = 0; i < nVertex; i++) {
			if(adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * 深度优先搜索：
	 * 由顶点一直向下搜索：
	 * 1.如果可能，访问一个邻接的未访问过的顶点，标记他并把它放入到栈中，
	 * 2.如果不能执行1时，如果栈不为null，就充栈中弹出一个顶点
	 * 3.当不能执行1和2，时就完成了整个搜索过程
	 */
	public void dfs() {
		//首先访问0号顶点
		vertexList[0].wasVisited = true;
		//显示该顶点
		displayVertex(0);
		//压入栈中
		stack.push(0);
		while(!stack.isEmpty()) {
			//获得一个未访问过的邻接点
			int v = getadjUnvisitedVertex((int)stack.peek());
			if(v == -1) {
				//弹出一个顶点
				stack.pop();
			} else {
				vertexList[v].wasVisited = true;
				displayVertex(v);
				stack.push(v);
			}
		}
		
		//搜索完以后，要将访问信息修改
		for(int i = 0; i < nVertex; i++) {
			vertexList[i].wasVisited = false;
		}
		
	}
	
	/**
	 * 显示出来
	 * @param v
	 */
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}
	/**
	 * 广度优先搜索：
	 * 一层一层的搜索
	 * 1.访问下一个邻接的未访问过的顶点，这个顶点必须是当前节点的邻接点标记他，并且，把它插入到队列中
	 * 2，如果无法执行规则1，那么久从队列头取出一个顶点，并使其作为当前顶点，
	 * 3，当队列不能执行规则2时，就完成了整个搜索过程
	 * 
	 * 
	 * 最小生成树
	 */
	public void mst() {
		//首先访问0号顶点
		vertexList[0].wasVisited = true;
		//压入栈中
		stack.push(0);
		while(!stack.isEmpty()) {
			//当前顶点
			int currentVertex = (int)stack.peek();
			//获得一个未访问过的邻接点
			int v = getadjUnvisitedVertex(currentVertex);
			if(v == -1) {
				//弹出一个顶点
				stack.pop();
			} else {
				vertexList[v].wasVisited = true;
				
				stack.push(v);
				displayVertex(currentVertex);
				System.out.print("-");
				displayVertex(v);
				System.out.print(" ");
			}
		}
		
		//搜索完以后，要将访问信息修改
		for(int i = 0; i < nVertex; i++) {
			vertexList[i].wasVisited = false;
		}
	}
	
}
