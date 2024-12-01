class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int result[] = new int[n];//Initialize the empty array

        //when k==0 then set 0 to all the element of the array 
        if(k == 0){
            return result;
        }
        
        //if k>0 then add the sum of the next k element then adda it to the result[i] place
        if(k > 0){
            for(int i=0; i<code.length; i++){
                int sum = 0;
                for(int j=1; j<=k; j++){
                    sum += code[(i+j)%n];
                }
                result[i] = sum;
            }
        }else{//if k<0 the add sum of the previous k elements to the result[i] place
            for(int i=0; i<code.length; i++){
                int sum = 0;
                for(int j=1; j<= -k; j++){
                    sum += code[(i-j+n)%n];
                }
                result[i] = sum;
            }
        }
        return result;
    }
}