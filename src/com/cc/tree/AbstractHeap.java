package com.cc.tree;

import java.util.LinkedList;
import java.util.Queue;

public abstract class AbstractHeap {
	protected int[] data;
	public AbstractHeap(int[] arr) {
		int size = (int) Math.pow(2, Math.ceil(Math.log10(arr.length) / Math.log10(2))) - 1;
		data = new int[size];
		int i;
		for(i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
		while(i < size) {
			data[i++] = defaultValue();
		}
		build();
	}
	
	protected abstract int defaultValue();
	protected abstract void heapify(int i);
	
	public int size() {
		return data.length;
	}
	
	public void build() {
		for(int i = size() / 2 - 1; i >= 0; i--) {
			heapify(i);
		}
	}
	
	public int getRoot() {
		return data[0];
	}
	
	protected static int parent(int i) {
		return (int) Math.floor(i / 2);
	}
	
	protected static int left(int i) {
		return 2 * i + 1;
	}
	
	protected static int right(int i) {
		return 2 * i + 2;
	}
	
	public String toString() {
		Queue<Integer> q1 = new LinkedList<Integer>(), 
				q2 = new LinkedList<Integer>();
		StringBuilder builder = new StringBuilder();
		q1.add(new Integer(0));
		int level = 0, treeSize = size() + 1;
		for(int i = 0; i < (treeSize - (int) Math.pow(2, level + 1)) / 2; i++) {
			builder.append(' ');
		}
		while(!q1.isEmpty()) {
			int next = q1.poll(),
					nextLeft = left(next),
					nextRight = right(next);
			if(next <= size() / 2 - 1) {
				q2.add(nextLeft);
				q2.add(nextRight);
			}
			builder.append(data[next]);
			builder.append(' ');
			if(q1.isEmpty()) {
				for(int i = 0; i < (treeSize - (int) Math.pow(2, level + 1)) / 2; i++) {
					builder.append(' ');
				}
				builder.append('\n');
				level++;
				if(!q2.isEmpty()) {
					for(int i = 0; i < (treeSize - (int) Math.pow(2, level + 1)) / 2; i++) {
						builder.append(' ');
					}
				}
				Queue<Integer> temp = q2;
				q2 = q1;
				q1 = temp;
			}
		}
		return builder.toString();
	}
}
