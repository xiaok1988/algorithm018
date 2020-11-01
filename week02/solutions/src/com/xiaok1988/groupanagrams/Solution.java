package com.xiaok1988.groupanagrams;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = getSignature(s);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }

        }

        List<List<String>> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }

    private String getSignature(String s) {
        int num = s.length();
        List<Character> temp = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            temp.add(s.charAt(i));
        }
        Collections.sort(temp);
        StringBuilder sb = new StringBuilder();
        for(Character c :temp){
            sb.append(c);
        }
        return sb.toString();
    }
}
