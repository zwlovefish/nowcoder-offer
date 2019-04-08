package com.zhou;
/*
 * 
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 
 * */
public class NumberPow {
    public double Power(double base, int exponent) {
        int temp = exponent;
        temp = Math.abs(temp);
        if(exponent < 0) {
        	double result = process(base, temp);
        	return 1/result;
        }
        return process(base, exponent);
  }
    public double process(double base,int exponent) {
    	double result = 1.0;
    	for(int i =0 ;i< exponent;i++) {
    		result = result * base;
    	}
    	return result;
    }
}
