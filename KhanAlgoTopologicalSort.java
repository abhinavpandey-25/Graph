package com.Graph;
import java.util.*;
public class KhanAlgoTopologicalSort {
static public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
   
	HashMap<String,ArrayList<String>>g=new HashMap<String,ArrayList<String>>();
    //this graph will store the dependecy har recipe k corresponding jo itme
    //available nhi h then woh recipe will be dependent on that item 

	HashMap<String,Integer>indegree=new HashMap<String,Integer>();
    HashSet<String>sup=new HashSet<String>();
    for(String s:supplies)sup.add(s);
    //lets construct graph by iterating on every recipe and checking for its
    //ingredients to get the dependecy
    //ie we make a directed edge from the ingredient to recipe and hence
    //increasing the indegree of the ith recipe
    //mulitple recipes can be dependent on same ingredient
    for(int i=0;i<recipes.length;i++) {
    	for(int j=0;j<ingredients.get(i).size();j++) {
    		if(!sup.contains(ingredients.get(i).get(j))) {
    			if(!g.containsKey(ingredients.get(i).get(j))){
    				ArrayList<String>make=new ArrayList<String>();
    				make.add(recipes[i]);
    			}
    			else {
    				ArrayList<String>make=g.get(ingredients.get(i).get(j));
    	    		make.add(recipes[i]);		
    				g.put(ingredients.get(i).get(j),make);
    			}
    			indegree.put(recipes[i], indegree.getOrDefault(recipes[i], 0)+1);
    			}
    	}
    }
    Queue<String>q=new LinkedList<String>();
    for(String r:indegree.keySet()) {
    	if(indegree.get(r)==0) {
    		q.add(r);
    	}
    }
    ArrayList<String>ans=new ArrayList<String>();
    //now ab 0 indegrre vali recipe ko store kro and yadi woh ingredient
    //mil juga toh uspe dependent sari recipe ki indegree kam ho jaygi by 1
    //and if kisi recipe ki indegrre again 0 then store it in q means us ingredient
    //ko banane ke liye kisi aur pe dependency nahi h ie koi requireed nhi h isko bnane k liye
    while(!q.isEmpty()) {
    	int size=q.size();
    	while(size>0) {
    		String r=q.remove();
    		ans.add(r);
    		for(String rcp:g.get(r)) {
    			indegree.put(rcp,indegree.get(rcp)-1);
    			if(indegree.get(rcp)==0) {
    				q.add(rcp);
    			}
    		}
    		size--;	
    	}
    }
    return ans; 
//    ["ju","fzjnm","x","e","zpmcz","h","q"]
//    		[["d"],["hveml","f","cpivl"],["cpivl","zpmcz","h","e","fzjnm","ju"],["cpivl","hveml","zpmcz","ju","h"],["h","fzjnm","e","q","x"],["d","hveml","cpivl","q","zpmcz","ju","e","x"],["f","hveml","cpivl"]]
//    		["f","hveml","cpivl","d"]
    //["ju","fzjnm","q"] expected
}
}
