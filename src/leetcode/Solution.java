public class Solution {
    public static void main(String[] args){
        String string = "deng li";
        System.out.println(new Solution().replaceBlank(string, 7));
    }
    /*
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(String string, int length) {
        if(length == 0) return 0;
        int cnt = 0;
        for(int i=0; i<length; i++) {
            if(string.charAt(i) == ' '){
                cnt++;
            }
        }
        char[] result = new char[length+2*cnt];
        StringBuilder strbuilder = new StringBuilder();
        int i=0, j=0;
        while(i < length){
            if(string.charAt(i) != ' '){
                result[j++] = string.charAt(i);
            }else {
                result[j++] = '%';
                result[j++] = '2';
                result[j++] = '0';
            }
            i++;
        }
        return length+2*cnt;
    }
}