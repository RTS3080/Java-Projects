//
//class Solution {
//    public int countBinarySubstrings(String s) {
//        int ones = 0;
//        int zeros = 0;
//
//        int count = 0;
//        char[] str = s.toCharArray();
//        for (int i = 0; i < str.length; i++) {
//            if(str[i] == '1') ones++;
//            if(str[i] == '0') zeros++;
//            if(ones == zeros){
//                count+=zeros;
//            }
//        }
//        return count;
//    }
//}
