package com.Graph;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Sorting_basedOnComparable {
public static class rollComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.roll-o2.roll;
	}	
	}
public static class Student implements Comparable<Student> {
	int roll;
	int weight;
	int height;
	Student(int r,int w, int h){
		this.roll=r;
		this.weight=w;
		this.height=h;
	}
	@Override
	public int compareTo(Student o) {
		//yadi this chota hoga toh woh upar a jyga mtlb  this is sorting based on the weight of
		// children
		
		return this.weight-o.weight;
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "rollno is "+this.roll+" weight is"+this.weight+" height is "+this.height;
	}

}
public static void main(String[] args) {
	Scanner o=new Scanner(System.in);
	Student s1=new Student(1,55,170);
	Student s2=new Student(12,65,175);
	Student s3=new Student(110,75,173);
	Student s4=new Student(8,45,140);
	Student s5=new Student(9,35,160);
	Student s6=new Student(3,85,160);
	Student s7=new Student(4,65,174);
	PriorityQueue<Student>s=new PriorityQueue<>(new rollComparator());
	// agar prority q m object pass kiuya h of class that implements comparator then it would 
	// according to it else kuch pasws njhi kiya toh to it would work according to the Comparable
	//as wo student ki class m hi implement h
	s.add(s1);
	s.add(s2);
	s.add(s3);
	s.add(s4);
	s.add(s5);
	s.add(s6);
	s.add(s7);
	// choti value upar aa jati h
	// this chhota h then give -
	//this eq h then 0
	//this >then +ve
	
	// yha proprity q is soritng student obj tohusko btana pdega ki kesee sort kr
	//aur pr q ye baat swaym us clas se puchta h jiska object uske pass rakja hua h
	
	// kisi object ko print krwan hota h toh to string ko override kr do 
	//agar nhi kiya toh hashcode is printef
	while(!s.isEmpty()) {
		System.out.println(s.remove());
	}
	
}
}
