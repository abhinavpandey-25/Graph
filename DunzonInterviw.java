package com.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class DunzonInterviw {
	static LinkedList<Integer>[] Adj;
	static int red=0;
	static int blue=0;
	static int ans=0;
	static char colors[];
	DunzonInterviw(int nodes) {
	Adj=new LinkedList[nodes];
	for(int i=0;i<nodes;i++) {
		Adj[i]=new LinkedList<>();
	}
	colors=new char[nodes];
	 }
	static void addVertex(int v1,int v2) {
		Adj[v1-1].add(v2-1);
		Adj[v1-1].add(v1-1);
	}
	static HashMap<String, Integer> dfs(int src,int parent) {
		int r=0,b=0;
		if(colors[src]=='A') {
			r++;
		}
		else if(colors[src]=='B') {
			b++;
		}
		for(int neighbour:Adj[src]) {
			if(neighbour!=src) {
				HashMap<String, Integer>result=dfs(neighbour,src);
				if(result.get("red")==red&&result.get("blue")==0) {
					ans+=1;
				}
				else if(result.get("blue")==blue&&result.get("red")==0) {
					ans+=1;
				}
				r+=result.get("red");
				b+=result.get("blue");
			}
		}
		HashMap<String,Integer>m=new HashMap<>();
		m.put("red",r);
		m.put("blue",b);
		return m;
	}
	public static void main(String[] args) {
		//here we are been given a tree of n nodes having color A ,B and C It is sure that tree is having at least
		//1 node colourd B ,A Now we nned to find out the number of edges that can be removed from the tree 
		// so that the tree is divide into two components contaning one consiting of only one Colour from A and B
		//and the other also consisting of single color out of a and b it does not matter whatever the c is present
		//in both the components \
		//so the logic is like we will go to the subtree of every node and then we make sure that the count of A 
		//is if equal to the total count of A and count of B in that subtree is equal to 0 and vice versa than 
		//it can be divided into two compponents
		Scanner o=new Scanner(System.in);
		int n=o.nextInt();
		DunzonInterviw ob=new DunzonInterviw(n);
		
		for(int i=0;i<n;i++) {
			char color;
			color=o.next().charAt(0);
			colors[i]=color;
			if(color=='R') {
				red++;
			}
			else if(color=='B') {
				blue++;
			}
		}
		for(int i=1;i<n;i++) {
			int v1=o.nextInt();
			int v2=o.nextInt();
			ob.addVertex(v1, v2);
		}
	//connection in nodes is like first us connected to second position wise and u need index wise so -1
		

		
	}
	}