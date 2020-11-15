package xiaok1988.wordladder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet(wordList);
        if (wordSet == null || !wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        wordSet.remove(beginWord);
        visited.add(beginWord);
        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int step=1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] charArray = word.toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    char original = charArray[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == original) {
                            continue;
                        } else {
                            charArray[j] = k;
                        }
                        String next = String.valueOf(charArray);

                        if (wordSet.contains(next)) {
                            if (next.equals(endWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(next)) {
                                queue.add(next);
                                visited.add(next);
                            }
                        }
                    }
                    charArray[j] = original;
                }
            }
            step++;
        }
        return 0;
    }

}