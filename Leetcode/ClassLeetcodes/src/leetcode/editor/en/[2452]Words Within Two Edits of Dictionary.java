package leetcode.editor.en;

import java.util.ArrayList;
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        outer:
        for(String s : queries){
            for(String str : dictionary){
                if(s.length() != str.length()) continue;
                if(canChange(s, str, 0, 0)){
                    res.add(s);
                    continue outer;
                }
            }
        }
        return res;
    }
    boolean canChange(String word, String target, int moves, int index){
        if(word.equals(target)) return true;
        if(moves >= 2) return false;
        if(index ==word.length()) return false;
        if(word.charAt(index) == target.charAt(index)) return canChange(word, target, moves, index+1);
        return canChange(word.substring(0, index)+target.charAt(index)+word.substring(index+1), target, moves+1, index+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
