class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] res = new int [2];
        int l = 0;
        int r = numbers.length-1;
        while(l < r){
            if(numbers[l] + numbers[r] == target){
                res[0] = l+1;
                res[1] = r+1;
                break;
            }else if(numbers[l] + numbers[r] > target){
                r--;
            }else{
                l++;
            }
        }
        /*for(int i = 0;i<numbers.length;i++){
            int rem = target - numbers[i];
            /*for(int j = i+1; j< numbers.length;j++){
                if(numbers[j] == rem){
                    res[0] = i+1;
                    res[1] = j+1;
                }
            }
            int l = i+1;
            int r = numbers.length-1;
            while(l <= r){
                int mid = l + (r-l)/2;
                if(numbers[mid] == rem){
                    res[0] = i+1;
                    res[1] = mid+1;
                    break;
                }else if(numbers[mid] > rem) {
                    r = mid-1;
                }else{
                    l= mid+1;
                } 
            }
        }*/
        return res;
    }
}
