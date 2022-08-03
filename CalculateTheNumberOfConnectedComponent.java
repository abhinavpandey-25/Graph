package com.Graph;

public class CalculateTheNumberOfConnectedComponent {
	static void dfs(int val,boolean v[],int c[][]){
        v[val]=true; 
        for(int i=0;i<v.length;i++){
             if(i!=val&&c[val][i]==1){
                 if(!v[i]){
                     dfs(i,v,c);
                 }
            }
         }
    }
    public int findCircleNum(int[][] isConnected) {
        int s=isConnected.length;
        boolean visited[]=new boolean[s];      
        int ans=0;
        for(int i=0;i<s;i++){
            if(!visited[i]){
                ans++;
                //just we need to find the number of connectted componenets
                //the condition is that it should not contain cycle
                dfs(i,visited,isConnected);    
            }
        }
        return ans;
    }
    //[[1,1,0],[1,1,0],[0,0,1]] n*n  matreix hogi iska matlab h
    //[1,1,0]at 0 means 0 node 0 se toh hoga hi node 1 se connected h
}
