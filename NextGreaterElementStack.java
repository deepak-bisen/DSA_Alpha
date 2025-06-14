package alpha;

import java.util.Stack;

public class NextGreaterElementStack {
	//brute force  0(n^2)
	public static void nextGE(int arr[]) {
	int 	arr1[]  = new int[arr.length];
		for(int i =0; i < arr.length ;i++) {
			for(int j = i+1; j < arr.length;) {
				if(arr[j]>=arr[i]) {
					arr1[i]= arr[j];
					break;
				}else {
					
					arr1[i]= -1;
					break;
				}
			}
//			for last element of result array
			if(i == arr.length-1) {
				arr1[i] = -1;
			}
		}
		for (int a  : arr1) {
			System.out.println(a);
		}
	}
	//optimised using stack O(n)
	public static void nextGreaterElementStack(int arr[]) {
		Stack<Integer> s = new Stack<>();
		int nge[] = new int[arr.length];
	for(int i = arr.length-1; i>= 0; i--) {
		//1 while
		while(!s.isEmpty() && arr[s.peek()]<=arr[i]) {
			s.pop();
		}
		//2 if-else
		if(s.isEmpty())
			nge[i] = -1;
		else
			nge[i] = arr[s.peek()];
		//3 push
		s.push(i);
			
	}
	for (int a  : nge) {
		System.out.println(a);
	}
	}
public static void main(String[] args) {
	int arr[] = {6,8,0,1,3};
	nextGreaterElementStack(arr); 
	//nextGE(arr);
}
}
