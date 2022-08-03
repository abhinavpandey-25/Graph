package com.Graph;

import java.util.*;

public class SmallestStringWithSwaps {
	static void dfs(int index,ArrayList<Integer>l1,boolean v[],LinkedList<Integer>l[]){
        v[index]=true;
        for(int node:l[index]){
            if(!v[node]){
                l1.add(node);
                dfs(node,l1,v,l);
            }
        }
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
       char ar[]=s.toCharArray();
       LinkedList<Integer>l[]=new LinkedList[s.length()];
       for(int i=0;i<l.length;i++){
        l[i]=new LinkedList<Integer>();
       }
       for(List<Integer>list:pairs){
           l[list.get(0)].add(list.get(1));
           l[list.get(1)].add(list.get(0));
       }
        boolean v[]=new boolean[s.length()];
        List<ArrayList<Integer>>pl=new ArrayList<>();
       for(int i=0;i<s.length();i++){
           if(!v[i]){
               ArrayList<Integer>l1=new ArrayList<Integer>();
               l1.add(i); 
               dfs(i,l1,v,l);
               pl.add(l1);
           }
       }
        char ans[]=new char[s.length()];
        for(List<Integer>list:pl){
           // System.out.println(list);
        PriorityQueue<Character>pq=new PriorityQueue<>();
            for(int ind:list){
                pq.add(ar[ind]);
            }
//means element in same group means connected components aapas me sort ho sakte h
//but woh apni hi postition me aayege sort krke toh point              
            
            Collections.sort(list);
            for(int ind:list){
                ans[ind]=pq.remove();
            }
        }
        return new String(ans);
    }
}
