package DSA_Alpha.GreedyAlgo;
import java.util.Arrays;
public class MinAbsoluteDifferencePairsGreedy {
public static void main(String[] args) {
	int A[] = {4,1,8,7};
	int B[] = {2,3,6,5};
	
	//sort them first for greedy approach
	Arrays.sort(A);
	Arrays.sort(B);
	
	int minAbsDiff = 0;
	for(int i = 0; i<A.length; i++) {
		minAbsDiff += Math.abs(A[i]-B[i]);
	}
	System.out.println("minimum absolute difference of pairs = "+minAbsDiff);
}
}
