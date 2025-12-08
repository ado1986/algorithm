package algorithm.leetcode.hash;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String sortStr = sortStr(strs[i]);

            // method1-使用getOrDefault方法
            List<String> list = map.getOrDefault(sortStr, new ArrayList<>());
            list.add(strs[i]);
            map.put(sortStr, list); // 初始状态没有值，需要添加put一下

            // method2
//            if (map.containsKey(sortStr)) {
//                map.get(sortStr).add(strs[i]);
//            } else {
//                List<String> list = new ArrayList<>();
//                list.add(strs[i]);
//                map.put(sortStr, list);
//            }
        }

        return new ArrayList<>(map.values());
    }


    private String sortStr(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }


    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams.groupAnagrams(strs);
        System.out.println(lists);
    }
}
