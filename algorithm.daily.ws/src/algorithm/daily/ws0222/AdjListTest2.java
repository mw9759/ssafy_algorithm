package algorithm.daily.ws0222;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdjListTest2 {
	
	
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		adjList = new ArrayList[V]; //head모두 null상태
		
		for(int i = 0; i<V; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		int from, to;
		for(int i = 0; i<E; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			//무향그래프라서 
			adjList[from].add(to);
			adjList[to].add(from);
			//유향그래프
		}
		
		print();
	}
	static void print() {
		for(ArrayList<Integer> list : adjList) { // list: 각 정점의 인접리스트의 arrayList
			System.out.println(list);
		}
	}
}
