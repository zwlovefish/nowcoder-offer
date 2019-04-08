package com.test;

public class Main {
	
	static  class test{
		 protected static void name() {
			
		} 
	}
	
	public static void main(String[] args) {
		int n = 2;
		System.out.printf("%d\n",n);
		printMySelf("1","2","3");
	}
	
	public static void printMySelf(String... args) {

		for(int i = 0;i < args.length;i++) {
			System.out.println(args[i]);
		}
	}
}
