class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i< position.length;i++){
            map.put(position[i],speed[i]);
        }

        int [] sortedPos = Arrays.stream(position).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        Stack<Double> s = new Stack<>();

        for(int pos : sortedPos){
            System.out.println(pos);
            double time = (double)(target - pos) / map.get(pos);
            s.push(time);
            if(s.size()>=2 && s.peek() <= s.get(s.size()-2)){
                s.pop();
            }
        }
        return s.size();
    }
}
