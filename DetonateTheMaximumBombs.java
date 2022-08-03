package com.Graph;

import java.util.*;

public class DetonateTheMaximumBombs {
	static void dfs (boolean v[],int b[][],int i,List<Integer>[]l,int c[]) {
		v[i]=true;
		for(int val:l[i]) {
			if(!v[val]) {
				c[0]=c[0]+1;
				dfs(v,b,val,l,c);
			}
		}
	}
static public int maximumDetonation(int[][] bombs) {
	int ans=0;
	List<List<String>>lis=new ArrayList<List<String>>();
	List<Integer>[]l=new LinkedList[bombs.length];
	for(int i=0;i<=100;i++)l[i]=new LinkedList<Integer>();
	for(int i=0;i<bombs.length;i++) {
		int x1=bombs[i][0];
		int y1=bombs[i][1];
		int r1=bombs[i][2];
		//actually so ek bomb can burst the other bomb only if the distance between the centres
		//(ie the position of bomb)is less than the radius of the first bomb
		//so based on that lets start making the connection like graph that bomb[i] can burst bomb[j]
		for(int j=0;j<bombs.length;j++) {
			if(j==i)continue;
			else {
				int x2=bombs[i][0];
				int y2=bombs[i][1];
				int r2=bombs[i][2];
				int d=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
				if(d*d<=r1*r1) {
						l[i].add(j);
				}
			}
		}
		
	}
	//now u have the connection ready so now starting bursting each bomb 
	//the connection is actually the connection between the nodes of the
	//directerd graph and see that upto how many bombs can it burst and 
	//in this way find the bomb that will burst max and print the max ie the bombs that can explode
	//so for that apply dfs ie starting blowing each bomb and find max bonds that burst due to that
	boolean visited[]=new boolean[bombs.length];
	
	for(int i=0;i<bombs.length;i++) {
		int count[]= {1};
		dfs(visited,bombs,i,l,count);
		Arrays.fill(visited,false);
		ans=Math.max(ans, count[0]);
	}
	return ans;
	
}
}
