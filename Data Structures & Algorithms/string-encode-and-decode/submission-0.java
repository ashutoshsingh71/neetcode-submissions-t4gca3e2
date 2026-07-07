class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        return String.valueOf(sb);
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j += 1;
            }
            int length = Integer.valueOf(str.substring(i,j));
            res.add(str.substring(j+1,j+1+length));
            i = j+1+length;
        }
        return res;
    }
}
