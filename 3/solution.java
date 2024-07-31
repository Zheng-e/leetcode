class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int n = 0;
        int head = 0;
        for(int i = 0; i < s.length(); ++i){
            n = n + 1;
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int duplicateIndex = map.get(c);
                for (int j = head; j < duplicateIndex; j++) {
                    map.remove(s.charAt(j));
                }
                if(n - 1 > max){
                    max = n - 1;
                }
                n = i - duplicateIndex;
                head = duplicateIndex + 1;
            }
            if(n > max){
                max = n;
            }
            map.put(c, i);
        }
        return max;
    }
}