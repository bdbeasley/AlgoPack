package com.cc.tree;

public class MaxHeap extends AbstractHeap {
	public MaxHeap(int[] arr) {
		super(arr);
		// TODO Auto-generated constructor stub
	}
	
	public void heapify(int i) {
		if(i < size() / 2) {
			int max = i;
			if(data[max] < data[left(i)])
				max = left(i);
			if(data[max] < data[right(i)]) 
				max = right(i);
			if(max != i) {
				int temp = data[i];
				data[i] = data[max];
				data[max] = temp;
				heapify(max);
			}
		}
	}
	
	protected int defaultValue() {
		return Integer.MIN_VALUE;
	}
}
