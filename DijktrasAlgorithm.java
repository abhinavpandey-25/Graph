package com.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class DijktrasAlgorithm {
	//shortest path algorithm
	static List<Edge>[] AdjList;
	public static class Edge {
		int src;///source
		int nbr;//neighbour
		int w;//weight
		Edge(int a,int b,int c){
			this.src=a;
			this.nbr=b;
			this.w=c;
		}
	}

	public static class Pair implements Comparable<Pair>{
		int pos;
		String path;
		int wsf;
		public Pair(int src,String path,int wsf) {
			this.pos=src;
			this.path=path;
			this.wsf=wsf;
			
		}
		@Override
		public int compareTo(Pair o) {
			return this.wsf-o.wsf;
		}
	}
	// so the point here is that the priority q m we would have pair that would store that
	//ki ham kis pos pr h and konsa path travel kr rhe and what is the dist we have travelled till
	//now (shortest) so hm 0 postion ko pq m dlange ie sorce and then 0 k corresponding nebr 
	// nikalenge from the edge ie stored in the adjaceny list and find out that its neighbour
	// are visited or not agr visited hoga toh woh path optimal hi hoga then continue
	//agr non visited h then add that pair aur agli bar jb ham agli bar priority q se pair nikalenge
	// toh woh hamesha kam cost vala pair nikalega taki ham adj list se us position k neghbhour travel kre
	//7
//	8
//	0 1 10
//	0 3 40
//	1 2 10
//	2 3 10
//	3 4 2
//	4 5 3
//	4 6 8
//	5 6 3
//	0
	public static void main(String args[]) {
		Scanner o=new Scanner(System.in);
		int vertex=o.nextInt();
		AdjList=new ArrayList[vertex];
		for(int i=0;i<vertex;i++) {
			AdjList[i]=new ArrayList<>();
		}
		int edges;
		edges=o.nextInt();
		for(int i=0;i<edges;i++) {
			int u=o.nextInt();
			int v=o.nextInt();
			int wt=o.nextInt();
			AdjList[u].add(new Edge(u, v, wt));
			AdjList[v].add(new Edge(v, u, wt));
		}
		int src=o.nextInt();
		PriorityQueue<Pair>pq=new PriorityQueue<>();
		boolean visited[]=new boolean[vertex];
		pq.add(new Pair(src,src+"",0));
		while(pq.size()>0) {
			Pair rm=pq.remove();
			if(visited[rm.pos]) {
				continue;
			}
			visited[rm.pos]=true;
			System.out.println(rm.pos+" "+"via"+" "+rm.path+" "+rm.wsf);
			for(Edge e:AdjList[rm.pos]) {
				if(!visited[e.nbr]) {
					pq.add(new Pair(e.nbr, rm.path+""+e.nbr,rm.wsf+e.w));
				}
			}
		}
		
	}

}
