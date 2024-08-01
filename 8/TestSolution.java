public class TestSolution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("   -042")); 
    }
}
class Solution {
    public int myAtoi(String s) {
        int n = 0;
        int flag = 1;
        int flag1 = 0;
        int flag2 = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if((c > '9' && c != ' ' && c != '-' && c != '+')||(c < '0' && c != ' ' && c != '-' && c != '+')||(c == '-' && flag1 == 1)||( c == '+' && flag1 == 1)||(c == ' ' && flag2 == 1)){
                break;
            }else if(c == '-' && flag1 == 0){
                flag = -1;
                flag1 = 1;
                flag2 = 1;
            }else if(c == '+' && flag1 == 0){
                flag1 = 1;
                flag2 = 1;
            }else if(c >= '0' && c <= '9'){
                flag1 = 1;
                flag2 = 1;
                int dig = c - '0';
                if(n > (Integer.MAX_VALUE - dig) / 10){
                    n = Integer.MAX_VALUE;
                }else if(n < (Integer.MIN_VALUE + dig) / 10){
                    n = Integer.MIN_VALUE;
                }else{
                    n = n * 10 + flag * dig;
                }
            }
        }
        return n;
    }
}