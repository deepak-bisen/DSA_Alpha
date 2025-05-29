package alpha;
import java.util.ArrayList;
//find if any pair in a sorted ArrayList has a target sum. return true if any.
public class PairSumAL {
	//Brute Force
	public static boolean pairSum(ArrayList<Integer> list, int target) {
		for(int i = 0; i < list.size()-1; i++) {
			for(int j = i+1; j < list.size()-1; j++) {
				if(target == (list.get(i)+list.get(j)))
					return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		 
		System.out.println(pairSum(list,5));
	}

}
