class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxBanana = piles[0];

        for(int n : piles){
            maxBanana = Math.max(maxBanana,n);
        }

        int l = 1;
        int r = maxBanana;
        int res = r;

        while(l <= r){
            int mid = l + (r-l)/2;
            long totalHours = totalHours(piles,mid);
            if(totalHours <= h){
                res = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return res;
    }

    private long totalHours(int [] piles,int speed){
        long hours = 0;

        for(int n : piles){
            hours += Math.ceil((double)n/speed);
        }
        return hours;
    }
}
