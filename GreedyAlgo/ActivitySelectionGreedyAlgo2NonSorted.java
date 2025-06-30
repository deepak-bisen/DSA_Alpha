package alpha;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;

public class ActivitySelectionGreedyAlgo2NonSorted {


	public static void main(String[] args) {
		int start[] = { 1, 3, 0, 5, 8, 5 };
		int end[] = { 2, 4, 6, 7, 9, 9 };
		
		//sorting
		int activities[][] = new int[start.length][3];
		for(int i = 0;i<start.length;i++) {
			activities[i][0] = i;
			activities[i][1] = start[i];
			activities[i][2] = end[i];
			
		}

		//lambda expression -> shortform
		Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));
		
		// end time basis sorted
		int maxAct = 0;
		ArrayList<Integer> ans = new ArrayList<>();

		// 1st Activity
		maxAct = 1;
		ans.add(activities[0][0]);
		int lastEndTime = activities[0][2];
		for (int i = 1; i < end.length; i++) {
			if (activities[i][1] >= lastEndTime) {
				// activity select
				maxAct++;
				ans.add(activities[i][0]);
				lastEndTime = activities[i][2];
			}
		}
		System.out.println("max activity = " + maxAct);
		for (int i = 0; i < ans.size(); i++) {
			System.out.println("A" + ans.get(i));
		}
	}
}
