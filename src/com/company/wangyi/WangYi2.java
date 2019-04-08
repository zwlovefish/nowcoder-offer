package com.company.wangyi;
/*
 * 
 * 小易觉得高数课太无聊了，决定睡觉。不过他对课上的一些内容挺感兴趣，所以希望你在老师讲到有趣的部分的时候叫醒他一下。
 * 你知道了小易对一堂课每分钟知识点的感兴趣程度，并以分数量化，以及他在这堂课上每分钟是否会睡着，你可以叫醒他一次，
 * 这会使得他在接下来的k分钟内保持清醒。你需要选择一种方案最大化小易这堂课听到的知识点分值。
 * 输入描述：
 * 第一行 n, k (1 <= n, k <= 105) ，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
 * 第二行 n 个数，a1, a2, ... , an(1 <= ai <= 104) 表示小易对每分钟知识点的感兴趣评分。
 * 第三行 n 个数，t1, t2, ... , tn 表示每分钟小易是否清醒, 1表示清醒。
 * 输出描述：
 * 小易这堂课听到的知识点的最大兴趣值。
 * 输入例子1：
 * 6 3
 * 1 3 5 2 5 4
 * 1 1 0 1 0 0
 * 输出例子1：
 * 16
 * */

import java.util.Scanner;

public class WangYi2 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] a = new int[n];
		int[] t = new int[n];
		for(int i = 0 ;i < n;i++) {
			a[i]= scanner.nextInt();
		}
		for(int i = 0;i<n;i++) {
			t[i] = scanner.nextInt();
		}
		int result = 0;
		int sum = 0;
		//感觉是算法复杂度高了。应该用窗口的
		for(int i = 0; i< a.length;i++) {
			if(t[i] == 1) {
				sum = sum + a[i];
			}
		}
		for(int i = 0;i<a.length;i++) {
			if(t[i] == 0) {
				int temp = 0;
				for(int j = 0; j<k && i+j < a.length;j++) {
					if(t[i+j] == 0) {
						temp += a[i+j];
					}
				}
				result = result < temp ? temp : result;
			}
		}
		System.out.println(sum + result);
	} 
}
