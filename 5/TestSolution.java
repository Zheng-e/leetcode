public class TestSolution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String input = "aaaa";
        String result = solution.longestPalindrome(input);
        System.out.println(result); // 预期输出 "xaabacxcabaax"
    }
}
class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String str = "";
        for(int i = 0; i < s.length(); i++){
            int l = 0;
            int k = i;
            for(int j1 = s.length() - 1; j1 >= i; j1--){
                l = 0;
                for(int j2 = j1; j2 >= k; j2--){
                    
                    if (s.charAt(k) == s.charAt(j2)){
                        if(k == j2){
                            l = l + 1;
                        }else{
                            l = l + 2;
                        }
                        k = k + 1;
                    }else if(s.charAt(k) != s.charAt(j2)){
                        l = 0;
                        k = i;
                        break;
                    }
                }
                if(l > max){
                    max = l;
                    str = "";
                    for(int m = i; m < i + max; m++){
                        str = str + s.charAt(m);
                    }
                }
            }
        }
        return str;
    }
}