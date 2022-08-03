package com.Graph;

public class DSU {
	  static int findParent(int x,int parent[]){
		//path compression
		  //what if we can set the representative of all the nodes in the path while finding the representative for ‘u’;
	        while(x!=parent[x]){
	            parent[x]=parent[parent[x]];
	            x=parent[x];
	        }
	        return x;
	    }
	  //in this question we are given request and restricted array and 
	  //we need to return a boolean array containing t or f for the request that is poosible 
	  //without any restriction 
	    static void union(int person1,int person2,int parent[],int rank[]){
	           int parentp1= findParent(person1,parent);
	           int parentp2=findParent(person2,parent);       
	           if(rank[parentp1]>rank[parentp2]){
	               parent[parentp2]=parentp1;
	           }
	            else if(rank[parentp1]<rank[parentp2]){
	                    parent[parentp1]=parentp2;
	            }
	            else{
	                parent[parentp1]=parentp2;
	                rank[parentp1]+=1;
	            }
	     //union krne ke liye rank is necessary as rank help in optimising
	           //as chote tree ko bade m jodna is optimized as find krne p asani hogi
	           //because depth of tree would not increase but in vice versa the depth
	           //is going to increase that will increase the time to ifind the parent
	           
	    }
	static   public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        int parent[]=new int[n];
        int rank[]=new int[n];
        for(int i=0;i<n;i++){
            rank[i]=1;
            parent[i]=i;
        }
        //logic is that har node ka ultimate parent pta ho which helps 
        //in categorising that node toh dono person jo connnect krna chahte ho
        //unka ultimate parent check krlo ki restricted to nih h
        //if nhi hota restricted that join them else do not join
        boolean ans[]=new boolean[requests.length];
        int index=0;
        for(int req[]:requests){
            int person1=req[0];
            int person2=req[1];
            boolean join=true;
            int parentOfPerson1=findParent(person1,parent);
            int parentOfPerson2=findParent(person2,parent);
            //System.out.println(parentOfPerson1+" "+parentOfPerson2);
            if(parentOfPerson1!=parentOfPerson2){
               // System.out.println("as");
                for(int restrict[]:restrictions){
                    int restrictedParent1=findParent(restrict[0],parent);
                    int restrictedParent2=findParent(restrict[1],parent);
                     // System.out.println(restrictedParent1+" "+restrictedParent2);
          
                    if((parentOfPerson1==restrictedParent1 && parentOfPerson2==restrictedParent2)||(parentOfPerson1==restrictedParent2&&parentOfPerson2==restrictedParent1)){
                        join=false;
                        break;
                    }
                }
                
            }
                    if(join){
                           union(person1,person2,parent,rank);
                       }
                           ans[index]=join;
                       index++; 
        }
        return  ans;
                   
    }
}
