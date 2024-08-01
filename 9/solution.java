class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        boolean flag = true;
        for(int i = 0; i < str.length() / 2 + 1; i++){
            if(str.charAt(i) != str.charAt(str.length() - i -1)){
                flag = false;
                break;
            }
        }
        return flag;
    }
}