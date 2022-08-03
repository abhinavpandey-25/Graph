package com.Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {
	    static class Edge{
			int nbr;
			int w;
			Edge(int d,int w){
				this.nbr=d;
				this.w=w;
			}
		}
		static class Pair{
			int pos;
			int d;
			Pair(int p,int t){
				this.pos=p;
				this.d=t;
			}
		}
	    public int countPaths(int n, int[][] roads) {
	      List<Edge> adj[]=new LinkedList[n];
	    for(int i=0;i<n;i++) {
	    	adj[i]=new LinkedList<Edge>();
	    }
	    int count=0;
	    for(int i=0;i<roads.length;i++) {
	    	adj[roads[i][0]].add(new Edge(roads[i][1], roads[i][2]));
	    	adj[roads[i][1]].add(new Edge(roads[i][0],roads[i][2]));
	    }
	    PriorityQueue<Pair>p=new PriorityQueue<Pair>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o1.d-o2.d;
			}
		});
	   //this array will keep the track of distance uptp that node
	    int dist[]=new int[n];
	    Arrays.fill(dist,Integer.MAX_VALUE);
	    int ways[]=new int[n];
	    ways[0]=1;
	    dist[0]=0;
	    //priorty que me we will store  n node and src se us nth
	    //node ki distance d from the source
	    p.add(new Pair(0,0));//n d
	        while(p.size()>0) {
	    	Pair pr=p.remove();
	    	for(Edge e:adj[pr.pos]) {  
	    		//nbr node tk jane k liye jo dist h woh wha pr stored
	    		//previous distance upto that nbr se kam h toh
	    		//that needs to be updated to the new distance
	    		//but if currnt d is equal to previous then update the 
	    		//ways array with the number of ways to reach to previous node
	    		//+ whatever the ways to reach there previously 
	            if(dist[e.nbr]>pr.d+e.w) {
	    			dist[e.nbr]=pr.d+e.w;
	    			ways[e.nbr]=ways[pr.pos];
	    			//ways would be update to ways to reach the previous node
	                 p.add(new Pair(e.nbr,e.w+pr.d));
	    		}
	    		else if(dist[e.nbr]==pr.d+e.w) {
	    			ways[e.nbr]=((ways[e.nbr]+ways[pr.pos])%1000000007);
	    		}
	    	}
	    }
	    return ways[n-1];
	     
	    }

}
