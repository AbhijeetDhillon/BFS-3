//Time Complexity : O(2^n) where n is the length of the string;
//Space Complexity : O(2n) since set and queue both are used;
//Leetcode : Worked;


class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null) return result;
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while(!q.isEmpty()){
            String curr = q.poll();
            if(isValid(curr)){
                flag = true;
                result.add(curr);
            }
            if(!flag){
                for(int i = 0;i<curr.length();i++){
                    if(Character.isLetter(curr.charAt(i))) continue;
                    String child = curr.substring(0,i) + curr.substring(i+1);
                    if(!set.contains(child)){
                        q.add(child);
                        set.add(child);
                    }
                }
            }
        }
        
        return result;
    }
    
    
    public boolean isValid(String curr){
        int count = 0; int i = 0;
        while(i<curr.length()){
            if(count<0) return false;
            if(curr.charAt(i) == '(') count ++;
            else if(curr.charAt(i) == ')') count --;
            i++;
        }
        if(count != 0) return false;
        return true;
    }
}