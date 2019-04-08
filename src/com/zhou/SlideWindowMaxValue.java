package com.zhou;

import java.util.ArrayList;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/*
 * 
 * 
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *   {[2,3,4],2,6,2,5,1}， 
 *   {2,[3,4,2],6,2,5,1}， 
 *   {2,3,[4,2,6],2,5,1}， 
 *   {2,3,4,[2,6,2],5,1}， 
 *   {2,3,4,2,[6,2,5],1}， 
 *   {2,3,4,2,6,[2,5,1]}。
 * 
 * */
class MaxValue{
	int value;
	int index;
	public MaxValue(int max,int index) {
		this.value = max;
		this.index = index;
	}
}
public class SlideWindowMaxValue {
	public static void main(String[] args) {
		int[] num = {2,3,4,2,6,2,5,1};
		ArrayList<Integer> arrayList = maxInWindows(num, 3);
		for (Integer integer : arrayList) {
			System.out.print(integer+" ");
		}
	}
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
    	ArrayList<Integer> arrayList = new ArrayList<>();
    	if(num.length < size || num.length == 0 || num == null||size==0) return arrayList;
    	Deque<MaxValue> qDeque = new LinkedBlockingDeque<>();
    	qDeque.addLast(new MaxValue(num[0], 0));
    	int winStart = 0;;
    	for(int i = 0;i < num.length;i++) {
    		while(!qDeque.isEmpty()&&qDeque.getLast().value <= num[i]) {
    			qDeque.removeLast();
    		}
    		qDeque.addLast(new MaxValue(num[i], i));
    		
    		if(i-winStart >=size-1) {
    			MaxValue value = qDeque.getFirst();
    			arrayList.add(value.value);
    			if(value.index <= winStart) {
    				qDeque.removeFirst();
    			}
    			winStart++;
    		}
    	}
        return arrayList;
    }
}
