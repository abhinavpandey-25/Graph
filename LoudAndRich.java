package com.Graph;

import java.util.Arrays;
import java.util.LinkedList;

public class LoudAndRich {
	//lintcode
	static int dfs(int n,int a[],LinkedList<Integer> l[],int q[]) {
		if(a[n]==-1) {
			 	a[n]=n; 
			for(int val:l[n]) {
				int v=dfs(val,a,l,q);
				//jo node return hua uski kam h ki jo phle kisi 
				//dfs se stored tha uski kam h
				if(q[v]<q[n]) {//here q[n] se nhi balki q[a[n]] se coompare
					//hoga as a[n] consist of that node
					//whose quietness is min may be possible that
					//other dfs can bring lesser quitness than that					
					a[n]=v;
				}
			}
		}
		return a[n];
	}
	public int[] loudAndRich(int[][] richer, int[] quiet) {
    LinkedList<Integer> l[]=new LinkedList[quiet.length];
    for(int i=0;i<l.length;i++) {
    	l[i]=new LinkedList<Integer>();
    }
    
    for(int a[]:richer) {
    	l[a[1]].add(a[0]);
    	// [x,y] x is more richer than y
    }
    int ans[]=new int[quiet.length];
    Arrays.fill(ans, -1);
    for(int i=0;i<quiet.length;i++) {
    	dfs(i,ans,l,quiet);
    }
    	return ans;
	}

}
