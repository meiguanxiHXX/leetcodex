package leetcode139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSplit {

    //  输入: s = "applepenapple", wordDict = ["apple", "pen"]
    //  s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]


    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> apple = List.of("aaaa", "aaa");
        WordSplit wordSplit = new WordSplit();
        System.out.println(wordSplit.wordBreak(s, apple));

    }

    //1.考虑双指针 2.已经存在的
}
