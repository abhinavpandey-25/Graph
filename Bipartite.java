package com.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class Bipartite {
	//bipartite means that whether the given graph can be colored with
	//two different colors or not if can be colored then its bipartite
	
	static boolean check(int i, List<Integer> l[],int colour[], Queue<Integer>q){
	       colour[i]=1;
	       q.add(i);
	        while(!q.isEmpty()){
	            int node=q.remove();
	            for(int nbr:l[node]){
	                if(colour[nbr]==colour[node]){
	                    return false;
	                }
	                else if(colour[nbr]==0){
	                    if(colour[node]==1)
	                    colour[nbr]=2;
	                    else if(colour[node]==2)
	                    colour[nbr]=1;
	                    q.add(nbr);
	                }
	                
	            }
	        }
	        return true;
	}
	    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
	    {
	        int colour[]=new int[V];
	        List<Integer> l[]=new LinkedList[V];
	        for(int i=0;i<l.length;i++){
	            l[i]=new LinkedList<Integer>();
	        }
	        for(int i=0;i<adj.size();i++){
	            for(int v:adj.get(i)){
	             l[i].add(v);
	            
	                
	            }
	        }
	        Queue<Integer>q=new LinkedList<Integer>();
	       
	      boolean val=false;
	        for(int i=0;i<V;i++){
	            if(colour[i]==0)
	            val=check(i,l,colour,q);
	            if(!val)return false;
	        }
	        return true;
	        // for(int i=0;i<l.length;i++){
	        //  System.out.println(i+" "+l[i]);
	            
	        // }
	       
	    }
	static boolean bfs(int g[][],int src,boolean visited[],int level[]){
        Queue<Integer>q=new LinkedList<>();
        visited[src]=true;
        level[src]=0;
        q.add(src);
        while(!q.isEmpty()){
            int parent=q.remove();
            for(int i:g[parent]){
                        
                    if(!visited[i]){
                        visited[i]=true;
                        level[i]=level[parent]+1;
                        q.add(i);
                    }
                    else{
                        if(level[i]==level[parent])
                            return false;
                    }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
       
        boolean visited[]=new boolean[graph.length];
        int level[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]&&graph[i].length!=0){
             if(bfs(graph,i,visited,level)==false){
                 return false;
             }
            }
        }
        return true;
        
        
    }
    public static void main(String[] args) {
    	int a[]=new int[10000000];
    	System.out.println(a[10000000-1]);
	}
}
