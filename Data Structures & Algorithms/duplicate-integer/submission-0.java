class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numberSet = new HashSet<Integer> ();

        for(int i : nums){
            if(numberSet.contains(i)){
                return true;
            }
            numberSet.add(i);
        }
        return false;
    }
}