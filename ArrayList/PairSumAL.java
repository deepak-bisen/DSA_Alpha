package alpha;
import java.util.ArrayList;
//find if any pair in a sorted ArrayList has a target sum. return true if any.
public class PairSumAL {
	//Brute Force
	public static boolean pairSumBF(ArrayList<Integer> list, int target) {
		for(int i = 0; i < list.size()-1; i++) {
			for(int j = i+1; j < list.size()-1; j++) {
				if(target == (list.get(i)+list.get(j)))
					return true;
			}
		}
		return false;
	}
	
	// 2-Pointer
	public static boolean pairSum2P(ArrayList<Integer> list, int target) {
		int leftPointer = 0;
		int rightPointer = list.size() - 1;
		while (leftPointer < rightPointer) {
		int currentSum =list.get(leftPointer) + list.get(rightPointer);
			// case 1:
			if ( currentSum == target )
				return true;   //pair found
			// case 2:
			else if (currentSum < target)
				leftPointer++;  //increase sum
			// case 3:
			else
				rightPointer--;  //decrease sum
		}
		return false;
	}
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		 int target = 5;
//		System.out.println(pairSumBF(list,target));
		System.out.println(pairSum2P(list,target));
	}

}
