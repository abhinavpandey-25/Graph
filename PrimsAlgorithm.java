package com.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
//It is used to find the min spanning tree
//spanning tree=> converting the graph into a tree in such a way so that
//from every point we can reach to every other point ie if total nodes are n then
//then no of edges is n-1
//since the graph is converted to a tree so obviously tree does not consist of
//of any cycles 	
//prims algorithm phle bande ke neghbour m se min cost find kro and then us par jao and then
//abhi tak k sare negbour including previous me se min find kro and do this until all nodes are done
static class Node implements Comparator<Node>
{	
	private int v;
	private int wt;
	Node(int v,int w){
		this.v=v;
		this.wt=w;
	}
	public Node() {
		// TODO Auto-generated constructor stub
	}
	public int getval(){
		return this.v;
	}
	public int getw() {
		return this.wt;
	}
	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		return o1.getw()-o2.getw();
	}
}
static void primsAlgo(ArrayList<ArrayList<Node>>adj,int N) {
	int key[]=new int[N];
	boolean mst[]=new boolean[N];
	int parent[]=new int[N];
	Arrays.fill(key, Integer.MAX_VALUE);
	Arrays.fill(mst, false);
	Arrays.fill(parent,-1);
	key[0]=0;
	PriorityQueue<Node>pq=new PriorityQueue<Node>(N,new Node());
	pq.add(new Node(0,key[0]));
	
	for(int i=0;i<N-1;i++) {
		//int min=Integer.MAX_VALUE;
		int ind=0;
		ind=pq.poll().getval();
//		for(int j=0;j<N;j++) {
//			if(!mst[j]&&key[j]<min) {
//				min=key[j];
//				ind=j;
//			}
//		}
		//o(n^2) beeter is two use priority q to maake it nlog(n)
		mst[ind]=true;
		
		for(Node n:adj.get(ind)) {
			if(!mst[n.getval()]&&key[n.getval()]>n.getw()) {
				key[n.getval()]=n.getw();
				parent[n.getval()]=ind;
				pq.add(new Node(n.v,n.getw()));
			}
		}
	}
	for(int i=1;i<parent.length;i++) {
		System.out.println(parent[i]+"=>"+i);
	}
}
public static void main(String[] args) {
	int n=5;
	ArrayList<ArrayList<Node>>adj=new ArrayList<ArrayList<Node>>();
	for(int i=0;i<n;i++) {
		adj.add(new ArrayList<Node>());
	}
	adj.get(0).add(new Node(1,2));
	adj.get(1).add(new Node(0,2));
	adj.get(0).add(new Node(3,6));
	adj.get(3).add(new Node(0,6));
	adj.get(1).add(new Node(3,8));
	adj.get(3).add(new Node(1,8));
	adj.get(1).add(new Node(4,5));
	adj.get(4).add(new Node(1,5));
	adj.get(4).add(new Node(2,7));
	adj.get(2).add(new Node(4,7));
	adj.get(1).add(new Node(2,3));
	adj.get(2).add(new Node(1,3));
	primsAlgo(adj, n);
}
}
