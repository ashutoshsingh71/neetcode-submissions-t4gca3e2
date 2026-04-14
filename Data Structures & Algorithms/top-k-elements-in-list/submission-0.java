class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            List<Integer> list = new ArrayList<>();
            list.add(entry.getKey());
            list.add(entry.getValue());
            res.add(list);
        }
        Collections.sort(res,(a,b) -> b.get(1) - a.get(1));

        for(int i = 0; i< k ; i++){
            ans.add(res.get(i).get(0));
        }
        return ans.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
