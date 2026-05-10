class Solution {
    private Map<Integer,List<Integer>> courseMap = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i< numCourses; i++){
            courseMap.put(i,new ArrayList<>());
        } 
        for(int [] pre : prerequisites){
            courseMap.get(pre[0]).add(pre[1]);
        }
        for(int c = 0 ;c<numCourses;c++){
            if(!dfs(c)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course){
        if(visiting.contains(course)) return false;
        if(courseMap.get(course).isEmpty()) return true;

        visiting.add(course);
        for(int c : courseMap.get(course)){
            if(!dfs(c)){
                return false;
            }
        }
        visiting.remove(course);
        courseMap.put(course,new ArrayList<>());
        return true;
    }
}
