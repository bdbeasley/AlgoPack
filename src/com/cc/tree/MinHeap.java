package com.cc.tree;

public class MinHeap extends AbstractHeap{

	public MinHeap(int[] arr) {
		super(arr);
	}
	
	public void heapify(int i) {
		int max = i;
		if(max < data[left(i)])
			max = left(i);
		if(max < data[right(i)]) 
			max = right(i);
		if(max == i)
			return;
		else {
			int temp = data[i];
			data[i] = max;
			data[max] = temp;
			heapify(max);
		}
	}
	

	protected int defaultValue() {
		return Integer.MAX_VALUE;
	}
}
