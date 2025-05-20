//Que 484: find & print permutations of a given string. 

public class FindPermutations {
	public static void findPermutation(String str, String ans) {
		// base case
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}

		// recursion -TC ~ O(n*n!)
		for(int i =0 ;i < str.length(); i++) {
		 char current = str.charAt(i);
		 //"abcde" => "ab"+"de" = "abde"  --remove current char
		 String newStr = str.subSequence(0, i)+str.substring(i+1);
		 findPermutation(newStr, ans+current);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		findPermutation(str, "");

	}
}
