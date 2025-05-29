package alpha;

import java.util.ArrayList;

public class PairSumSortedRotated {

	// pair sum for sorted and rotated arraylist
	// using 2 pointer with pivot approach  TC= O(n)
	public static boolean pairSum(ArrayList<Integer> list, int target) {
		int n = list.size();
		// find pivot point
		int pivot = -1;
		for (int i = 0; i < n-1; i++) {
			if (list.get(i) > list.get(i + 1)) { //breaking point
				pivot = i;
				break;
			}
		}
		
		int leftPointer = pivot + 1; //smallest value
		int rightPointer = pivot;    //largest value
		
		while (leftPointer != rightPointer) {
			int currentSum = list.get(leftPointer) + list.get(rightPointer);
			// case 1:
			if (currentSum == target)
				return true; // pair found
			// case 2:
			if (currentSum < target)
				leftPointer = (leftPointer + 1) % n;
			// case 3:
			else
				rightPointer = (n + rightPointer - 1) % n; // decrease sum
		}
		return false;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(15);
		list.add(6);
		list.add(8);
		list.add(10);

		int target = 16;

		System.out.println(pairSum(list, target));

	}

}
