class Solution {
    Map<Integer,List<Integer>> courseMap = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    Set<Integer> cycle = new HashSet<>();
    Set<Integer> visited = new HashSet<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i = 0; i< numCourses;i++){
            courseMap.put(i,new ArrayList<>());
        }

        for(int [] pre : prerequisites){
            courseMap.get(pre[0]).add(pre[1]);
        }

        for(int i = 0; i< numCourses;i++){
            if(!dfs(i)){
                return new int[0];
            }
        }
        return res.stream().mapToInt(Integer :: intValue).toArray();
    }

    private boolean dfs(int course){
        if(visited.contains(course)) return true;
        if(cycle.contains(course)) return false;

        cycle.add(course);
        for(int c : courseMap.get(course)){
            if(!dfs(c)){
                return false;
            }
        }
        cycle.remove(course);
        visited.add(course);
        res.add(course);
        return true;
    }
}
