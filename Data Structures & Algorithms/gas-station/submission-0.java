class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas = 0;
        int totalCost = 0;

        for(int i : gas){
            totalgas += i;
        }
        for(int i : cost){
            totalCost += i;
        }
        if(totalgas < totalCost) return -1;

        int total = 0;
        int start = 0;

        for(int i = 0; i< gas.length;i++){
            total += gas[i] - cost[i];
            if(total < 0){
                total = 0;
                start = i+1;
            }
        }
        return start;
    }
}
