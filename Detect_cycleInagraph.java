package com.Graph;

import java.util.LinkedList;
import java.util.Scanner;

public class Detect_cycleInagraph {
	static LinkedList<Integer>AdjList[];
	static boolean visited[];
public Detect_cycleInagraph(int n) {
AdjList=new LinkedList[n];
visited=new boolean[n];
for(int i=0;i<n;i++) {
AdjList[i]=new LinkedList<Integer>();
}
}
static void addEdge(int v1,int v2) {
	AdjList[v1-1].add(v2-1);
	AdjList[v2-1].add(v1-1);
	//undirected graph
}
static boolean isCycleThere(int node,int parent){
	//for checking the cycle we need to visit node and its negihbour in a recursice manner
	// or dfs way  and visit the unvisited node if the node is already visited and it 
	//is not the parent node then it means we have  a cycle in the graph
	visited[node]=true;
	for(int newnode:AdjList[node]) {
		if(!visited[newnode]) {
		if(isCycleThere(newnode,node)) 
			return true;
		}
		else if(visited[newnode]&&newnode!=parent)
			return true;
	
	}
	return false;
}
// to check that given graph is a tree or not 
//if it is a tree then it should not have cycle 
//if it is a tree it should have connected componnent
//so for connected component after checking that is not having the cycle
//we will check whther their is any node that is unvisisted if such a node exists than'
//we can say that given graph is not a tree
public static void main(String[] args) {
	Scanner o=new Scanner(System.in);
	int n =o.nextInt();
	Detect_cycleInagraph obj=new Detect_cycleInagraph(n);
	for(int i=0;i<n;i++) {
		int v1=o.nextInt();
		int v2=o.nextInt();
		addEdge(v1, v2);
	}
	//do the connections of edge here 
	boolean fcycle=false;
	for(int i=0;i<n;i++) {
		if(!visited[i])
		  if(isCycleThere(i,-1))
		  {
			  System.out.println("true there is a cycle");
			  fcycle=true;
			  break;
		  }
	}
	if(!fcycle) {
		System.out.println("No cycle found");
	}
}
}
