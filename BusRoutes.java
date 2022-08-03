package com.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BusRoutes {
//here u are given the routes 2d array where routes[i] means 
//the ith bus and routes[i][j] means that ith bus can travel to r[i][j] stop
//and we need to find out the min num of bus that should be taken to reach
//to a particular destination bus stop while starting from a particular
//source bus stop if not possible return -1
	 static int numBusesToDestination(int[][] routes, int source, int target) {
		 //we need to create a maping corespoinding to busstop with busno
		 //ki is bustop pr kin kin baso se aa skta
		 HashMap<Integer,ArrayList<Integer>>m=new HashMap<>();
		 for(int i=0;i<routes.length;i++) {
			 for(int j=0;j<routes[i].length;j++) {
				 int bstop=routes[i][j];
				 ArrayList<Integer>buslist=m.getOrDefault(bstop, new ArrayList<Integer>());
				 buslist.add(i);
				 m.put(bstop, buslist);
			 }
		 }
		 HashSet<Integer>vblist=new HashSet<Integer>();
		 HashSet<Integer>vbus=new HashSet<Integer>();
		 Queue<Integer>q=new LinkedList<Integer>();
		q.add(source);
		vblist.add(source);
		int noofbus=0;
		while(!q.isEmpty()) {
			int s=q.size();
			while(s-->0) {
			int stop=q.remove();
			if(stop==target)
				return noofbus;
			ArrayList<Integer>blist;
			blist=m.get(stop);
			//here we get the list of bus that can react to
			//the poped stop from que
			for(int bus:blist) {
				if(vbus.contains(bus)) {
					continue;
				}
				int blength=routes[bus].length;
				for(int i=0;i<blength;i++) {
					if(vblist.contains(routes[bus][i])) {
						continue;
					}
					else {
						//we are also mainting a que for keep 
						//track of visited bus along with the visited stop 
						//so that corresponding to another stop we wont visit the same
						//bus and same stop
						//we will add all the negihboring stop corresponding to a given stop						
						q.add(routes[bus][i]);
						vblist.add(routes[bus][i]);
					}
				}
				vbus.add(bus);
			}
			}
			noofbus++;
		}
		 return -1; 
	 }
}
