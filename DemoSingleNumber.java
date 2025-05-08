/**Question number 136
  *Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
  */
You must implement a solution with a linear runtime complexity and use only constant extra space
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num : nums){
            result ^= num;
        }
        return result;
    }
}

class DemoSingleNumber {
public static void main(String[] args) { 
    int [] nums = {2,2,1,33,33};  
    System.out.println(singleNumber(nums));
    }
}
