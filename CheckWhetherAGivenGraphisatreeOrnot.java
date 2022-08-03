package com.Graph;

import java.util.LinkedList;

public class CheckWhetherAGivenGraphisatreeOrnot {
	//just we need to check for cycle
	static boolean checkcycle(int n,int p,boolean v[],LinkedList<Integer> l[]){
        v[n]=true;
        for(int i:l[n]){
         //   System.out.print("neigh"+ i);
            if(!v[i]){
            //System.out.println("recur"+ i);
                
               if(checkcycle(i, n, v, l))
                   return true;
            }
            else if(v[i]&& i!=p){
              //  System.out.print("sa");
                return true;
            }
        }
        return false;
    }
   public boolean validTree(int n, int[][] edges) {
       // write your code here
       if(n==1&&edges.length==0)
       return true;
       LinkedList<Integer> l[]=new LinkedList[n];
       for(int i=0;i<n;i++){
           l[i]=new LinkedList<Integer>();
       }
       boolean visited[]=new boolean[n];
       for(int i=0;i<edges.length;i++){
           l[edges[i][0]].add(edges[i][1]);
           l[edges[i][1]].add(edges[i][0]);
       }
       int c=0;
       for(int i=0;i<n;i++){
    	   //this is necessary as it is a graph and has various component 
    	   //but jb bhi count >1 hoga toh ie not a tree it is imp for 
    	   //check whther three is a cycle in graph or not
           if(!visited[i]){
             //  System.out.print("call "+ i);
               c++;
               if(checkcycle(i,-1,visited,l))
                   return false;
           }
       }
       
       //graph yadi tree h toh multiple disconnected nhi honge ek hi hoga 
       return c==1;
   }
}
