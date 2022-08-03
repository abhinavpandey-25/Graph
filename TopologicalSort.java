package com.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {
	int Vertex;
	static LinkedList<Integer> []AdjacencyList;
	static boolean visited[];
	TopologicalSort(int v){
		Vertex=v;
		AdjacencyList=new LinkedList[Vertex];
		visited=new boolean[v];
		for(int i=0;i<Vertex;i++) {
			AdjacencyList[i]=new LinkedList<Integer>();
		}
	}
	static void addEdge(int v,int e) {
		AdjacencyList[v].add(e);
		//topological sort is valid for only DAG ie directed acyclic graph
		//esa order jisme har kam jo phle krna jaruri h woh phle ana chiye
	}
	static void dfs(int n,Stack<Integer>st,boolean vis[]) {
		vis[n]=true;
		for(int node:AdjacencyList[n]) {
			if(!vis[node]) {
				dfs(node,st,vis);
			}
		}
		st.add(n);
	}
	static ArrayList<Integer> topoSort(int v,boolean vis[]){
		Stack<Integer>st=new Stack<Integer>();
		for(int i=0;i<v;i++) {
			if(!vis[i]) {
				dfs(i,st,vis);
			}
		}
		ArrayList<Integer>list=new ArrayList<Integer>();
		while(!st.isEmpty()) {
			list.add(st.pop());
		}
		return list;
		//time complexity o(E+V)
		//space complexity o(V);
	}
	static void bfsToposort(int v) {
		int indegree[]=new int[v];
		for(int i=0;i<v;i++) {
			for(int val:AdjacencyList[i]) {
				indegree[val]++;
			}
		}
		Queue<Integer>q=new LinkedList<Integer>();
		for(int d=0;d<indegree.length;d++) {
			if(indegree[d]==0)q.add(d);
		}
		int toposort[]=new int[v];
		int ind=0;
		while(!q.isEmpty()) {
			//jin nodes ki bhi indegree 0 h means usko krne ke liye koi aur nhi
			//karna pdega but if indegree non zero then it means usko krne ke lliye
			//uske phle vala krna pdega
			int node=q.remove();
			toposort[ind++]=node;
			for(int val:AdjacencyList[node]) {
				indegree[val]--;
				if(indegree[val]==0) {
					q.add(val);
				}
			}
		}
	}
}
