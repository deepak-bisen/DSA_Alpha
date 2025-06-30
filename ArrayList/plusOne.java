class plusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        //traverse from last digit
        for(int i = n - 1; i >= 0; i--){
           // check if the digit is less then 9 , add 1 to it and return
           if(digits[i] < 9){
            digits[i]++;
            return digits;
        }
            //if digit is 9, set it to 0 and continue to next digit
            digits[i] = 0; 
           
        }

        int num[] = new int[n+1];
        num[0] = 1; //first digit becomes 1 
        return num; 
    }
}
