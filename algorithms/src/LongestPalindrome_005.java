public class LongestPalindrome_005 {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String reverse = new StringBuffer(s).reverse().toString();
        char[] reverseChars = reverse.toCharArray();
        int len = chars.length;
        int[][] array = new int[len][len];
        int maxLen = 0;
        int maxLenIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < reverseChars.length; j++) {
                if(chars[i] == reverseChars[j]){
                    if(i == 0 || j == 0){
                        array[i][j] = 1;
                    }else {
                        array[i][j] = array[i-1][j-1] + 1;
                    }
                    if(array[i][j] > maxLen){
                        int startIndex = len-1-j;
                        if(startIndex+array[i][j]-1==i){
                            maxLen = array[i][j];
                            maxLenIndex = i;
                        }
                    }
                }
            }
        }
        return s.substring(maxLenIndex+1-maxLen, maxLenIndex+1);

    }
}
