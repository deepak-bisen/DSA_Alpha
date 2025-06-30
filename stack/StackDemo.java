package collectionframework;

import java.util.*;

public class StackDemo {
	// Q1: push at the bottom of stack
	public static void pushAtBottom(Stack<Integer> s, int data) {
		if (s.isEmpty()) {
			s.push(data);
			return;
		}

		int top = s.pop();
		pushAtBottom(s, data);
		s.push(top);
	}

	// Q2: reverse a String using a stack
	public static String reverseString(String str) {
		Stack<Character> s = new Stack<>();
		int index = 0;
		while (index < str.length()) {
			s.push(str.charAt(index));
			index++;
		}
		StringBuilder result = new StringBuilder("");
		while (!s.empty()) {
			char currentChar = s.pop();
			result.append(currentChar);
		}
		str = result.toString();
        return str;
	}
	//Q3: reverse a stack
	public static void reverseStack(Stack<Integer> s) {
		if(s.empty())
			return;
		
		int top = s.pop();
		reverseStack(s);
		pushAtBottom(s,top);
	}
	public static void printStack(Stack<Integer> s) {
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
	

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(10);
		stack.push(12);
		stack.push(30);
		stack.push(40);

//		pushAtBottom(stack, 51);
//		printStack(stack);
		
//		String reversedString = reverseString("deepak");
//		System.out.println(reversedString);
		
		printStack(stack);
		reverseStack(stack);
		printStack(stack);
		
	}
}
