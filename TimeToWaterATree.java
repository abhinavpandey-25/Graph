package com.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class TimeToWaterATree {
	
//nodes in a tree are between 0 to n-1 
//given a father array where corresponding to ith node given its father
//0th node is the root node 
//Now to water the tree, sprinkle water on the root node, 
//the water will flow down every edge,
//from the imediate father of node i to node i costs time[i]
//we need to find the min time so that water will flow to all the nodes	
//logic keep a track of all the child of every father using map
//and then do a bfs and when we reach to leaf node then check 
//the max of all the times to reach to leaf and that
// time is sufficient to water all the plants	
	 public int timeToFlowerTree(int[] father, int[] time) {
	         LinkedList<Integer> l[]=new LinkedList[father.length];
	         ArrayList<Integer>o=new ArrayList<Integer>();
	        Collections.sort(o, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
	        
	         for(int i=0;i<l.length;i++)l[i]=new LinkedList<Integer>();
	         for(int i=1;i<father.length;i++){
	             l[father[i]].add(i);
	         }
	         Queue<int []>q=new LinkedList<int[]>();
	         //add relation node,time
	         int water=0;
	         q.add(new int[]{0,0});
	         while(!q.isEmpty()){
	             int ar[]=q.remove();
	             if(l[ar[0]].size()==0){
	                   water=Math.max(water,ar[1]); 
	             }
	             else{
	                 for(int child:l[ar[0]]){
	                     q.add(new int[]{child,ar[1]+time[child]});
	                 }
	             }
	         }
	         return water;
	    
	    }	
	
}
