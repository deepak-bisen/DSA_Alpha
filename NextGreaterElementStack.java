package alpha;

public class NextGreaterElementStack {
	//brute force  
	public static void nextGE(int arr[]) {
	int 	arr1[]  = new int[arr.length];
		for(int i =0; i < arr.length ;i++) {
			for(int j = i+1; j < arr.length;) {
				if(arr[j]>=arr[i]) {
					arr1[i]= arr[j];
					break;
				}else {
					
					arr1[i]= -1;
					break;
				}
			}
//			for last element of result array
			if(i == arr.length-1) {
				arr1[i] = -1;
			}
		}
		for (int a  : arr1) {
			System.out.println(a);
		}
	}
public static void main(String[] args) {
	int arr[] = {6,8,0,1,3};
	nextGE(arr);
}
}
