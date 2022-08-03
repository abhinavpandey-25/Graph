package com.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class CountCoronaAffected {
	public static void main(String[] args) {
	Scanner o=new Scanner(System.in);
	int vertex=o.nextInt();
	//the idea is easy visit every neighbour and count them and then for next
	//unit of time just go on wiht the negihbours of those whom you have added in
	//the array in previous step
	ArrayList<Integer>graph[]=new ArrayList[vertex];
	int edge=o.nextInt();
	for(int i=0;i<graph.length;i++) {
		graph[i]=new ArrayList<Integer>();
	}
	for(int i=0;i<edge;i++) {
		int src=o.nextInt();
		int dest=o.nextInt();
		graph[src].add(dest);
		graph[dest].add(src);
	}
	for(int i=0;i<vertex;i++) {
		System.out.println(graph[i]);		
	}
	boolean visited[]=new boolean[vertex];
	int time=o.nextInt();
	int start=o.nextInt();
	//we need to find out that how many people are affected after time t
	Queue<Integer>q=new ArrayDeque<Integer>();
	int ans=1;
	q.add(start);
	int count=0;
	while(!q.isEmpty()) {
		int size=q.size();
		System.out.println(size+ " size");
		while(size>0) {
			int val=q.remove();
			System.out.println("value "+val);
				if(!visited[val]) {
					visited[val]=true;
					count++;
				}
				for(int x:graph[val]) {
					if(!visited[x]) {
						System.out.println(x);
						visited[x]=true;
						count++;
						q.add(x);
					}
				}
				
				size--;
		}
		
		ans++;
		if(time<=ans) {
			break;
		}
	}
	System.out.println(count);
}
}
