package com.Graph;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheapestFlightWithinkstops extends TimeToWaterATree{
	
//dijkstra's like probllem
	static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        ///there are n cities connected and we are been given the cost of travelling
		//from the city a to city b and we are given a src from where we wiill start
		//and a destination where we need to stop and a k value that denotes the max
		//no of stops where we can stop so we need to find the cheapest price to 
		//reach the destination within k steps
		HashMap<Integer,ArrayList<ArrayList<Integer>>>map=new HashMap<>();
		for(int []ar:flights) {
			if(!map.containsKey(ar[0])) {
				map.put(ar[0], new ArrayList<>());
			}
			ArrayList<Integer>info=new ArrayList<>();
			info.add(ar[1]);// ar[0] added the connected with
			info.add(ar[2]);//ar[0] se ar[1] tk jane ki cost added
			map.get(ar[0]).add(info);
		}
	//	System.out.println(map);
		Queue<ArrayList<Integer>>l=new PriorityQueue<>(new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.get(1), o2.get(1));
			}
			
		});
		ArrayList<Integer>item=new ArrayList<Integer>();
		item.add(src);
		item.add(0);
		item.add(K);
		l.add(item);
		while(!l.isEmpty()) {
			ArrayList<Integer>list=l.poll();
			//System.out.println(list);
			int source=list.get(0);
			int cost=list.get(1);
			int stop=list.get(2);
			if(source==dst) {
				return cost;
			}
			if(stop>0) {
				if(!map.containsKey(source)) {
					continue;
				}
				for(ArrayList<Integer>conn:map.get(source)) {
					//System.out.println(conn);
					ArrayList<Integer>item2=new ArrayList<Integer>();
					item2.add(conn.get(0));
					item2.add(cost+conn.get(1));
					item2.add(stop-1);
					l.add(item2);
				}
			}	
		}
		
		//consist of three elements src node and current cost and stopes left
		
		return -1;
		
    }
	private boolean ck(String s) {
		try {
			return s.length()>5;
		}
		catch(NullPointerException e) {
			System.out.println("sexce");
			return false;
		}
	}
	private void start() {
		System.out.println(ck("12345"));
		System.out.println(ck("123456"));
		System.out.println(ck(null));
	}
public static void main(String[] args) {

	int flights[][]= {{0,1,100},{1,2,100},{0,2,500}};
	System.out.println( findCheapestPrice(3, flights, 0,2, 1));
}
}
