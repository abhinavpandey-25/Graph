package com.Graph;
import java.util.*;
public class CourseSchedule2 {
	 static boolean isCycle;
	 //if i know ki  is path p aage jake cycle nhi that we get as i have done dfs
	 //so we put that inside the dp array
	  static void isCycle(int i,boolean v[],List<Integer> l[],boolean dp[],Stack<Integer>st){
			  if(!dp[i])return ;  
		         v[i]=true;
		         for(int val:l[i]){
		             if(!v[val]){
		                isCycle(val,v,l,dp,st);
		             }
		             else{
		                isCycle=true; 
	                    return;
	                 }
		         }
	             st.push(i);
		         v[i]=false;
	             dp[i]=false;
	         //let say 2->0 and we started dfs from oth node
	         //we visited 0 then when the chance of 2nd node comes than zero 
	         //is already visted that means as per oure code cycle is there
	         //but actually it is not
	         //so afer the dfs done we mark the node again unvisited so to avoid the
	         //wrong answer
	     }
	    public int[] findOrder(int numCourses, int[][] prerequisites) {
	       List l[]=new LinkedList[numCourses];
	        isCycle=false;
		        for(int i=0;i<l.length;i++){
		            l[i]=new LinkedList<Integer>();
		        }
		        for(int a[]:prerequisites){
		            l[a[1]].add(a[0]);
		        }
		        boolean v[]=new boolean[numCourses];
		        boolean[] dp = new boolean[numCourses];
		    Arrays.fill(dp,true); 
	        Stack<Integer>st=new Stack<Integer>();
		    for(int i=0;i<numCourses;i++){
	            //System.out.println(i);   
	            if(!v[i]){         
	                isCycle(i,v,l,dp,st);
	            }
	        }
	        int ind=0;
	        int ans[]=new int[st.size()];
	        if(isCycle)return new int[0] ;
	        while(!st.isEmpty()){
	            ans[ind]=st.pop();
	            ind++;
	            
	        }
	        return ans;
	    }
}
