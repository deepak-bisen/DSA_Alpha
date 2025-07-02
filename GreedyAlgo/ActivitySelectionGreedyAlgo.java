package DSA_Alpha.GreedyAlgo;

import java.util.ArrayList;

public class ActivitySelectionGreedyAlgo {
	public static void main(String[] args) {
		int start[] = { 1, 3, 0, 5, 8, 5 };
		int end[] = { 2, 4, 6, 7, 9, 9 };

		// end time basis sorted
		int maxAct = 0;
		ArrayList<Integer> ans = new ArrayList<>();

		// 1st Activity
		maxAct = 1;
		ans.add(0);
		int lastEndTime = end[0];
		for (int i = 1; i < end.length; i++) {
			if (start[i] >= lastEndTime) {
				// activity select
				maxAct++;
				ans.add(i);
				lastEndTime = end[i];
			}
		}
		System.out.println("max activity = " + maxAct);
		for (int i = 0; i < ans.size(); i++) {
			System.out.println("A" + ans.get(i));
		}
	}
}
