package algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    private static final Map<Character, String> digitsMap = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        backtrack(combinations, digits, 0, new StringBuffer());

        return combinations;
    }

    private void backtrack(List<String> combinations, String digits, int index, StringBuffer combination) {
        if (combination.length() == digits.length()) {
            combinations.add(combination.toString());
            return;
        }
        char ch = digits.charAt(index);
        String letters = digitsMap.get(ch);
        for (int i = 0; i < letters.length(); i++) {
            combination.append(letters.charAt(i));
            backtrack(combinations, digits, index + 1, combination);
            combination.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> combinations = letterCombinations.letterCombinations("23");

        for (String combination : combinations) {
            System.out.println(combination);
        }
    }

}
