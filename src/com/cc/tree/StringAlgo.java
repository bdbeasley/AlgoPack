package com.cc.tree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class StringAlgo {

	
	//O(n)
	public static boolean isometric(String s1, String s2) {
		if(s1.length() == s2.length()) {
			char[] m = new char[256];
			boolean[] b = new boolean[256];
			int i;
			for(i = 0; i < 256; i++) {
				m[i] = 0;
				b[i] = false;
			}
			for(i = 0; 
					i < s1.length() && 
					(!b[s1.charAt(i)] || m[s1.charAt(i)] == s2.charAt(i)); 
					i++) {
				m[s1.charAt(i)] = s2.charAt(i);
				b[s1.charAt(i)] = true;
			}
			return i == s1.length();
		} else return false;
	}
	
	//O(n)
	public static boolean rearrangment(String s1, String s2) {
		if(s1.length() == s2.length()) {
			int[] m = new int[256];
			int i;
			for(i = 0; i < s1.length(); i++) {
				m[s1.charAt(i)]++;
				m[s2.charAt(i)]--;
			}
			for(i = 0; m[i] == 0; i++);
			return i == s1.length();
		} else return false;
	}
	
	/* determines whether two strins have the same characters */
	//O(n)
	public static boolean sameChars(String s1, String s2) {
		boolean[] b = new boolean[256];
		for(int i = 0; i < s1.length(); i++) {
			b[s1.charAt(i)] = true;
		}
		for(int i = 0; i < s2.length(); i++) {
			if(!b[s2.charAt(i)]) return false;
		}
		return true;
	}
	
	//determines if the string is a palindrome
	public static boolean palindrome(String input) {
		Stack<Character> s = new Stack<Character>();
		int i;
		for(i = 0; i < input.length() / 2; i++) {
			s.push(input.charAt(i));
		}
		if(i % 2 == 0)
			i++;
		while(s.pop().charValue() == input.charAt(i++));
		return i == input.length();
	}
	
	//iterative solution
	//O(n!) time and memory because the output has to be o(n!) where the input size is n.
	//gets slow around where n = 8, so n! = 40k computations and memory.
	public static List<String> permute1(String input) {
		LinkedList<StringBuilder> permutations = new LinkedList<StringBuilder>();
		permutations.add(new StringBuilder(""+input.charAt(0)));
		
		for(int i = 1; i < input.length(); i++) {
			char c = input.charAt(i);
			int size = permutations.size();
			for(int k = 0; k < size ; k++) {
				StringBuilder permutation = permutations.removeFirst(),
						next;
				for(int j = 0; j < permutation.length(); j++) {
						next = new StringBuilder();
						for(int b = 0; b < permutation.length(); next.append(permutation.charAt(b++)));
						next.insert(j, c);
						permutations.addLast(next);
				}
				permutation.append(c);
				permutations.addLast(permutation);
			}
		}
		List<String> formattedPermutations = new LinkedList<String>();
		for(int i = 0; i < permutations.size(); formattedPermutations.add(permutations.get(i++).toString()));
		return formattedPermutations;
	}
	
	//iterative solution
		//O(n!) time and memory because the output has to be o(n!) where the input size is n.
		//gets slow around where n = 8, so n! = 40k computations and memory.
		public static List<String> permute3(String input) {
			LinkedList<String> permutations = new LinkedList<String>();
			permutations.add(""+input.charAt(0));
			for(int i = 1; i < input.length(); i++) {
				char c = input.charAt(i);
				int size = permutations.size();
				for(int k = 0; k < size ; k++) {
					String permutation = permutations.removeFirst(),
							next;
					for(int j = 0; j < permutation.length(); j++) {
							next = permutation.substring(0, j + 1) + c + permutation.substring(j + 1, permutation.length());
							permutations.addLast(next);
					}
					permutations.addLast(permutation + c);
				}
			}
			return permutations;
		}
	
	
	public static List<String> permute2(String str) { 
	    return permute2("", str); 
	}

	private static List<String> permute2(String prefix, String str) {
	    int n = str.length();
	    List<String> permutations = new LinkedList<String>();
	    if (n == 0) permutations.add(prefix);
	    else 
	    	for (int i = 0; i < n; i++) 
	    		permutations.addAll(permute2(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n)));
	    return permutations;
	}
}
