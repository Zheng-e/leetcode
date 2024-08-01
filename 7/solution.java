class Solution {
    public int reverse(int x) {
        String str = String.valueOf(x);
        String restr = "";
        if(str.charAt(0) == '-'){
            restr = restr + "-";
            for(int i = str.length() - 1; i >= 1; i--){
                restr = restr + str.charAt(i);
            }
        }else{
            for(int i = str.length() - 1; i >= 0; i--){
                restr = restr + str.charAt(i);
            }
        }
        try {
            int reint = Integer.valueOf(restr);
            return reint;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}