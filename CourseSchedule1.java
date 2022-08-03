package com.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule1 {
	//dfs over the undirected graph
	 static boolean isCycle(int i,boolean v[],List<Integer> l[],boolean dp[]){
		  if(!dp[i])return dp[i];  
	         v[i]=true;
	           
	       //   System.out.println(i);
	         for(int val:l[i]){
	             if(!v[val]){
	                   if(isCycle(val,v,l,dp)){
	                       return true;
	                   } 
	             }
	             else
	             return true;
	         }
	         v[i]=false;
         //let say 2->0 and we started dfs from oth node
         //we visited 0 then when the chance of 2nd node comes than zero 
         //is already visted that means as per oure code cycle is there
         //but actually it is not
         //so afer the dfs done we mark the node again unvisited so to avoid the
         //wrong answer
         return false;
     }
//here u need to find that whether u can complete all the courses or not
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		 List l[]=new LinkedList[numCourses];
	        for(int i=0;i<l.length;i++){
	            l[i]=new LinkedList<Integer>();
	        }
	        
	        for(int a[]:prerequisites){
	            l[a[1]].add(a[0]);
	        }
	        boolean v[]=new boolean[numCourses];
	        boolean[] dp = new boolean[numCourses];
	    Arrays.fill(dp,true); 
	      //as after dfs we kept that course again unvisited 
        //so to avoid going for dfs again we can memoize the answer for 
        //that course .
        //7<-8->5->4<-9->1->x
        //		|		 |	
        //		v        v
        //		3        y
        //as apply dfs from 1 then visited with no cycle it means course 
        //1 and its dependent course can be completed  .
        //and if i again visit 1 from 9 the we do not wanted to iterate
        //again so we memoize the answer from 1
	    for(int i=0;i<numCourses;i++){
            //System.out.println(i);   
            if(!v[i]){         
                if(isCycle(i,v,l,dp)){
                    return false;
                }
            }
        }
        return true;
        }	
	//10
	//[[5,8],[3,5],[4,5],[7,8],[4,9],[1,9],[0,2]]
}
