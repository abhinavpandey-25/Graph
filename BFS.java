package com.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	static class cell{
		int x;
		int y;
		int d=0;
		cell(int x,int y,int d){
			this.x=x;
			this.y=y;
			this.d=d;
		}
	}
	static boolean  inside(int x,int y,int n) {
		//checking whether the  place  where the knight can move is lying inside the board 
		//or not
		if(x>=1&&x<=n&&y>=1&&y<=n) {
			return true;
		}
		else {
			return false;
		}
	}
	static int minstep(int curr[],int target[],int n){
		int xmoves[]= {-2,-1,1,2,-2,-2,1,2};
		int ymoves[]= {-1,-2,-2,-1,1,2,2,1};
		//posiotns where the knight can move form a partciuala corrdinate
		Queue<cell>q=new LinkedList<>();
		q.add(new cell(curr[0],curr[1],0));
		boolean [][]visited=new boolean[n+1][n+1];
		visited[curr[0]][curr[1]]=true;
		cell obj;
		while(!q.isEmpty()) {
			obj=q.remove();
			System.out.println(obj.x+" "+obj.y);
			if(obj.x==target[0]&&obj.y==target[1]) {
				return obj.d;
			}
			else {
				//add all the position where knight can moeve it  hte qureu.
			int x=0;
			int y=0;
				for(int i=0;i<8;i++) {
			x=obj.x+xmoves[i];
			y=obj.y+ymoves[i];
			}
				if(inside(x,y,n)&& !visited[x][y]) {
				visited[x][y]=true;
				q.add(new cell(x,y,obj.d+1));
			}
			}
		}
		return 0;
		
	}
//bfs means that we wil travel along the breadth that is  travrl level wise.
	//uses queue to implement it.
//problem is that knight horse moves in chess;
public static void main(String[] args) {
	Scanner o=new Scanner (System.in);
	int n=o.nextInt();
	//size of chess board
	int current[]= {o.nextInt(),o.nextInt()};
	int target[]= {o.nextInt(),o.nextInt()};
	int ans=minstep(current,target,n);
System.out.println(ans);
}
}
// it is working but slight problem 