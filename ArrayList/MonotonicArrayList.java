/**Monotonic ArrayList(EASY)
  *An Arraylist is monotonic if it is either monotone increasing or monotone decreasing.
  *AnArraylist nums ismonotone increasing if for all i <= j, nums.get(i) <=nums.get(j). An
  *Arraylist nums is monotone decreasing if for all i <= j, nums.get(i) >= nums.get(j).
  *Given an integer Arraylist nums, return true if the given list is monotonic, or false otherwise.
  *Sample Input 1 : nums = [1,2,2,3]
  *Sample Output 1: true
  */
package DSA_Alpha.ArrayList;
import java.util.ArrayList;
public class MonotonicArrayList {

public static boolean isMonotonic(ArrayList<Integer> A) {
boolean inc = true;
boolean dec = true;
for (int i=0; i<A.size()-1; i++) {
if (A.get(i) > A.get(i+1))
inc = false;
if (A.get(i) < A.get(i+1))
dec = false;
}
return inc || dec;
}
public static void main(String[] args) {

	ArrayList<Integer> list = new ArrayList<>();

	list.add(10);
	list.add(20);
	list.add(20);
	list.add(30);
	list.add(40);
	list.add(40);
	list.add(50);
	System.out.println(isMonotonic(list));
}
}
