package com.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class PathWithMaximumProb {
	
	static double max=0;
	static class Pair{
        double sp;
        int n;
        public Pair(double p,int n){
            this.sp=p;
            this.n=n;
        }
    }
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        LinkedList<Pair> l[]=new LinkedList[n];
        for(int i=0;i<l.length;i++){
            l[i]=new LinkedList<Pair>();
        }
        for(int i=0;i<edges.length;i++){
            int e[]=edges[i];
            l[e[0]].add(new Pair(succProb[i],e[1]));
        }
        boolean v[]=new boolean[n];
        Queue<Pair>q=new LinkedList<Pair>();
        double prob[]=new double[n];
        q.add(new Pair((double)1,start));
        while(!q.isEmpty()){
            Pair p1=q.remove();
            for(Pair p:l[p1.n]){
                //with the help of queue ham jo bhi pair store kr rhe that
            	//is keeping the track ki us pair ke node tk aane k lie
                //max succes prob kya mili h abhi tk 
            	//if yadi us path tk phucne ki stored prob alredy
            	//jyda h as compared to if we come via other path
            	//then no need to add that path in the queue
                if(p1.sp*p.sp>prob[p.n]){
                prob[p.n]=p1.sp*p.sp;
                q.add(new Pair(p.sp*p1.sp,p.n));    
                }
            }
        }
        return prob[end];
	}

}
