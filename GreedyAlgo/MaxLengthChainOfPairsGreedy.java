package DSA_Alpha.GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChainOfPairsGreedy {
	public static void main(String[] args) {
		int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };

		//sorting based on 2nd number of pair
		Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1])); 
		
		int chainLength = 1;
		int chainEnd = pairs[0][1]; // last selected pair end/chain end
		
		for (int i = 1; i < pairs.length; i++) {
			if (pairs[i][0] > chainEnd) { // pair->start > lastSelectedPair->end
				chainLength++;
				chainEnd = pairs[i][1]; // update last selected chain
			}
		}
		System.out.println("Max Length Of Chain = " + chainLength);
	}
}
