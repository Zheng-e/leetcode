class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        String str = "";
        for(int i = 0; i < numRows; i++){
            for(int j = i; j < s.length(); j = j + (numRows - 1) * 2){
                if(i == 0 || i == numRows - 1){
                    str = str + s.charAt(j);
                }else{
                    if((j + (numRows - i - 1) * 2) < s.length()){
                        str = str + s.charAt(j) + s.charAt(j + (numRows - i - 1) * 2);
                    }else{
                        str = str + s.charAt(j);
                    }
                }
            }            
        }
        return str;
    }
}