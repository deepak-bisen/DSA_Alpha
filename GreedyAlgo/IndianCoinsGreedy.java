package DSA_Alpha.GreedyAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoinsGreedy {
	public static void main(String[] args) {

		// coins refers to indian currency notes/coins
		Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };

		// sort the currency in descending order
		Arrays.sort(coins, Comparator.reverseOrder());

		int count = 0;
		int amount = 590;
		ArrayList<Integer> ans = new ArrayList<Integer>();

		for (int i = 0; i < coins.length; i++) {
			if (coins[i] < amount) {
				while (coins[i] <= amount) {
					count++;
					ans.add(coins[i]);
					amount -= coins[i];
				}
			}
		}

		System.out.println("Total (min) coins/notes used: " + count);
	
		System.out.println("Coins/Notes Used: ");
		for(Integer a : ans) {
			System.out.print(a+" ");
		}
	}
}
