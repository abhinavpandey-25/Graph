package com.Graph;

import java.util.LinkedList;
import java.util.Scanner;

public class CanTheGivenGraphcanbecoloredwithmcolors {
	//complexity for every node there are colors.length possibility 
	//so complexity is no of node^colors.length
	static Graph o;
	static Scanner sc=new Scanner(System.in);
	public CanTheGivenGraphcanbecoloredwithmcolors(int v,int ed) {
		o=new Graph(v);		
		add(o,ed);
	}
	static void add(Graph o,int ed) {
		for(int i=0;i<ed;i++) {
			int v=sc.nextInt();
			int e=sc.nextInt();
			o.addEdge(v, e);
		}
	}
	
	static boolean possible(int node,LinkedList<Integer>l[],int colors[],int color) {
		for(int neighbours:l[node]) {
			//here i am checking the color of neighbouring nodess is equal to
			//the color of with which we are trying to color the current node 
			if(colors[neighbours]==color)
				return false;
		}
		return true;
	}
	static boolean solve(int node,LinkedList<Integer> l[],int color[],int colors) {
		if(node==l.length)
			return true;
		for(int i=1;i<=colors;i++) {
			if(possible(node,l,color,i)) {
				color[node]=i;
				//after coloring a node then i asked solve function
				//to color the node+1 bby taking possiblity of all colors
				
				if(solve(node+1,l,color,colors)) {
					return true;
				}
				color[node]=0;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int vertex=sc.nextInt();
		int edges=sc.nextInt();
		CanTheGivenGraphcanbecoloredwithmcolors obj=new CanTheGivenGraphcanbecoloredwithmcolors(vertex, edges);
		int colors=sc.nextInt();
		int color[]=new int[vertex];
		//lets start coloring the graph from 0th node
		if(obj.solve(0,o.AdjacencyList,color,colors)) {
			System.out.println("that the graph can be coloured with m colors in such a way that no two adjacent are having same coolor ");			
		}
		else {
			System.out.println("u cannot color nodes with m colors");
		}
	}
}
