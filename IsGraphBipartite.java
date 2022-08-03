package com.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IsGraphBipartite {
static LinkedList<Integer>adj[];
static boolean visited[];
public IsGraphBipartite(int v) {
adj=new LinkedList[v];
for(int i=0;i<v;i++) {
	adj[i]=new LinkedList<Integer>();
}
visited=new boolean[v];
}
static void addEdge(int s,int d) {
	adj[s].add(d);
	adj[d].add(s);
}
static Queue<Integer>q=new LinkedList<Integer>();
static boolean bfs(int src,int vertex,int level[]) {
	q.add(src);
	visited[src]=true;
	level[src]=0;
	while(!q.isEmpty()) {
		int parent=q.remove();
		for(int child:adj[parent]) {
			if(!visited[child]) {
				visited[child]=true;
				level[child]=level[parent]+1;
				q.add(child);
			}
			else {
				if(level[child]==level[parent]) {
					return false;
				}
			}
		}
	}
	return true;
}
public static void main(String[] args) {
	Scanner o=new Scanner(System.in);
	int vertex=o.nextInt();
	IsGraphBipartite g=new IsGraphBipartite(vertex);
	
	int edges=o.nextInt();
	for(int i=0;i<edges;i++) {
		int s=o.nextInt();
		int d=o.nextInt();
		addEdge(s, d);
	}
	int level[]=new int [vertex];
	//for being bipartite if the node is visited then its level should be ddifferent than
	//that of its parent;
	//biparatite means that its vertex can be divided into two sets such that
	//and every edge has one endpoint in first set and the other endpoint in the other set
	if(bfs(0,vertex,level)) {
		System.out.println("graph is bipartite");
	}
	else {
		System.out.println("graph is not bipartite");
	}
	for(int i=0;i<vertex;i++) {
		System.out.println(level[i]);
	}
}

}
