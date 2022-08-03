package com.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathByTakingKey {
static class Pair {
	int x;
	int y;
	Pair(int x,int y){
		this.x=x;
		this.y=y;
	}
}
static boolean checkValid(int x,int y,boolean v[][],int m[][]) {
	if(x<0||y<0||x>=v.length||y>=v[0].length||v[x][y]||m[x][y]==0) {
		return false;
	}
	return true;
}
static int bfs(int m[][],int x,int y) {
	Queue<Pair>q=new LinkedList<Pair>();
	if(m[x][y]==2) {
		return 0;
	}
	q.add(new Pair(x,y));
	int dir[][]= {{0,-1},{-1,0},{0,1},{1,0}};//l t r d
	boolean v[][]=new boolean[m.length][m[0].length];
	//searching key first;
	int step=1;
	while(!q.isEmpty()) {
		int sz=q.size();
		while(sz>0) {
			Pair p1=q.remove();
			v[p1.x][p1.y]=true;
			System.out.println(x+" "+y);
			for(int d[]:dir) {
				int x1=p1.x+d[0];
				int y1=p1.y+d[1];	
				if(checkValid(x1,y1,v,m)) {
					System.out.println(x1+" "+y1);
					if(m[x1][y1]==2) {
						return step;
					}
					q.add(new Pair(x1,y1));		
				}	
			}
			sz--;
		}	
		step++;
	}
	return step;
}
public static void main(String[] args) {
	
	int m[][]= {{1,0,2},{1,1,1},{0,1,0}};
	int m2[][]= {{1,2,0},{1,1,1},{0,1,0}};
	int m3[][]= {{2,1,0},{1,1,1},{0,1,0}};
	int m4[][]= {{1,0,1},{1,1,1},{0,1,2}};
	int m5[][]= {{1,1,0},{1,1,1},{0,1,2}};
	int m6[][]= {{1,1,1},{1,1,2},{1,1,0}};
	// key position is given but we cannot find the distance directly
	// as manhatten distance can't check the path validity so we have to go with 
	//bfs
	//what if the key is not there 
	//then we can create a boolean var as we get the key make it as true
	//and when bfs done then check if u got key if false then return -1
	//as no need to go to door
	int steps=bfs(m6,0,0);
	//reach from a source to destination by collecting key placed
	//at a point
	//path from start to key
	
	//path from key to end
//	int kx=0;
//	int ky=1;
//	m2[kx][ky]=1;
//	m2[m4.length-1][m4.length-1]=2;
//	int ans=bfs(m2,kx,ky);
//	System.out.println(steps+" "+ans);
	System.out.println(steps);
}
}
