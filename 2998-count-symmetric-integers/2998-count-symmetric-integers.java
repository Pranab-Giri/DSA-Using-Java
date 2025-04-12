class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int num=low; num<=high; num++){
            String str = String.valueOf(num);
            int len = str.length();

            //check for even length only
            if(len % 2 == 0){
                int half = len/2;
                int sum1=0, sum2=0;
                //Sum of the first half digits
                for(int i=0; i<half; i++){
                    sum1 +=str.charAt(i) - '0';
                }

                //Sum of the second half digits
                for(int i=half; i<len; i++){
                    sum2 +=str.charAt(i) - '0';
                }

                if(sum1 == sum2){
                    count++;
                }
            }
        }
        return count;
    }
}