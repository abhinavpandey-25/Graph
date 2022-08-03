	package com.Graph;

import java.util.LinkedList;
//flower planting with no adjacent leetcode
//step simple h ki har node k pass jake usse har connected node p jake min calculate krlo jb tk us node se 
//connected sare visited nahi ho jate and do it for every node to and
//calculate the sum of value of the min node to get the required ans
public class Graph {
int Vertex;
static LinkedList<Integer> []AdjacencyList;
static boolean visited[];
Graph(int v){
	Vertex=v;
	AdjacencyList=new LinkedList[Vertex];
	visited=new boolean[v];
	for(int i=0;i<Vertex;i++) {
		AdjacencyList[i]=new LinkedList<Integer>();
	}
}
static void addEdge(int v,int e) {
	AdjacencyList[v].add(e);
	AdjacencyList[e].add(v);
}
static void dfs(int ar[],int index,int min) {
	visited[index]=true;
	min=Math.min(ar[index],min);
	for(int i:AdjacencyList[index]) {
		if(!visited[i]) {
			dfs(ar,i,min);
		}
	}
}
static void travel(int ar[]) {
int min=0;
int sum=0;
for(int i=0;i<ar.length;i++) {
	if(!visited[i])	{
		min=ar[i];
		dfs(ar,i,min);
		sum=sum+min;
	}
	}
System.out.println(sum);
}
public static void main(String[] args) {
	Graph g=new Graph(5);
	int ar[]= {2, 5, 3, 4, 8};
	g.addEdge(0,3);
	g.addEdge(3, 4);
	travel(ar);
}



}
