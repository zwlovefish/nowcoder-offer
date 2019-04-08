package com.zhou;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 
 * 
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * 
 * */
class MyCompator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o2-o1;
	}
	
}
public class MediaNumInDataStream {
	PriorityQueue<Integer> mindeap = new PriorityQueue<>();
	PriorityQueue<Integer> maxdeap = new PriorityQueue<>(new MyCompator());
	public static void main(String[] args) {
		MediaNumInDataStream mediaNumInDataStream = new MediaNumInDataStream();
		mediaNumInDataStream.Insert(5);
		System.out.println(mediaNumInDataStream.GetMedian());
		mediaNumInDataStream.Insert(2);
		System.out.println(mediaNumInDataStream.GetMedian());
		mediaNumInDataStream.Insert(3);
		System.out.println(mediaNumInDataStream.GetMedian());
		mediaNumInDataStream.Insert(4);
		System.out.println(mediaNumInDataStream.GetMedian());
		mediaNumInDataStream.Insert(1);
		System.out.println(mediaNumInDataStream.GetMedian());
		mediaNumInDataStream.Insert(6);
		System.out.println(mediaNumInDataStream.GetMedian());
		mediaNumInDataStream.Insert(7);
		System.out.println(mediaNumInDataStream.GetMedian());
		mediaNumInDataStream.Insert(0);
		System.out.println(mediaNumInDataStream.GetMedian());
		mediaNumInDataStream.Insert(8);
		System.out.println(mediaNumInDataStream.GetMedian());
		//5,2,3,4,1,6,7,0,8
	}
    public void Insert(Integer num) {
        
        if((maxdeap.size() + mindeap.size()) %2 == 0) {
        	maxdeap.add(num);
        	Integer temp = maxdeap.poll();
        	mindeap.add(temp);
        }else {
        	mindeap.add(num);
        	Integer temp = mindeap.poll();
        	maxdeap.add(temp);
        }
    }

    public Double GetMedian() {
        int size = mindeap.size() + maxdeap.size();
        System.out.print("size is "+ size+" ");
        if(size == 0) {
        	return new Double(0);
        }
        Double result = new Double(0.0);
        if(size % 2 == 0) {
        	result = new Double((mindeap.peek() + maxdeap.peek())/2.0);
        }
        else {
        	result = new Double(mindeap.peek());
        }
        return result;
    }
}
