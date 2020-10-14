package com.zjl.leetcode;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zjl
 * @date 2019-07-03
 */
public class Leet127_WordLadder {
//    private int wordLength;
//    private Map<String, List<String>> adjacentMap;
//
//    // using Bidirectional BFS, 从前从后同时遍历，直到接上头
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//
//        if (!wordList.contains(endWord)) {
//            return 0;
//        }
//
//        wordLength = beginWord.length();
//        adjacentMap = new HashMap<>();
//
//        // 构造图邻接关系
//        wordList.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                for (int i = 0; i < wordLength; i++) {
//                    String general = s.substring(0, i) + "*" + s.substring(i + 1);
//
//                    List<String> adjacentList = adjacentMap.getOrDefault(general, new ArrayList<String>());
//
//                    adjacentList.add(s);
//
//                    adjacentMap.put(general, adjacentList);
//                }
//            }
//        });
//
//        HashMap<String, Integer> visited1 = new HashMap<>();
//        HashMap<String, Integer> visited2 = new HashMap<>();
//        Queue<Pair> queue1 = new LinkedList();
//        Queue<Pair> queue2 = new LinkedList();
//
//        queue1.add(new Pair(beginWord, 1));
//        visited1.put(beginWord, 1);
//
//        queue2.add(new Pair(endWord, 1));
//        visited2.put(endWord, 1);
//
//        while (!queue1.isEmpty() && !queue2.isEmpty()) {
//            int ans = visitOneNode(queue1, visited1, visited2);
//            if (ans != -1) {
//                return ans;
//            }
//
//            ans = visitOneNode(queue2, visited2, visited1);
//            if (ans != -1) {
//                return ans;
//            }
//        }
//
//        return 0;
//    }
//
//    // 从queue中remove一个出来，visit其邻接节点并入队
//    private int visitOneNode(Queue<Pair> queue, Map<String, Integer> visitedSelf, Map<String, Integer> visitedOther) {
//        Pair next = queue.remove();
//
//        for (int i = 0; i < wordLength; i++) {
//            String general = next.word.substring(0, i) + "*" + next.word.substring(i + 1);
//            for (String adjacent : adjacentMap.getOrDefault(general, new ArrayList<String>())) {
//
//                if (visitedOther.containsKey(adjacent)) {
//                    return next.level + visitedOther.get(adjacent);
//                }
//
//                // only enqueue if not visited before.
//                if (!visitedSelf.containsKey(adjacent)) {
//                    queue.add(new Pair(adjacent, next.level + 1));
//                    visitedSelf.put(adjacent, next.level + 1);
//                }
//
//            }
//        }
//
//        return -1;
//    }
//
//    private class Pair {
//        private String word;
//        private int level;
//
//        public Pair(String word, int level) {
//            this.word = word;
//            this.level = level;
//        }
//    }

    // BFS breadth-first search with only one queue，好理解
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        String div = "|";
        wordList.remove(beginWord);

        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);
        queue.add(div);

        int len = 1;
        while (!queue.isEmpty()) {
            String w = queue.remove();
            if (w.equals(div)) {
                if (queue.isEmpty()) {
                    return 0;
                }

                len++;
                queue.add(div);
            } else if (endWord.equals(w)) {
                return len;
            } else {
                Iterator<String> iterator = wordList.iterator();
                while (iterator.hasNext()) {
                    String next = iterator.next();
                    if (differBySingleLetter(w, next)) {
                        queue.add(next);
                        iterator.remove();
                    }
                }
            }
        }

        return 0;
    }

    private boolean differBySingleLetter(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

//    // TODO:ZJL 2019-07-04 what's wrong with my recursion solution?
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//
//        if (!wordList.contains(endWord)) {
//            return 0;
//        }
//
//        Map<String, Integer> map = new HashMap<>();
//        map.put(endWord, 1);
//
//        return ladderInternal(beginWord, wordList, map);
//    }
//
//    private int ladderInternal(String beginWord, List<String> wordList, Map<String, Integer> map) {
//        int length = 0;
//
//        for (int i = 0; i < wordList.size(); i++) {
//            String check = wordList.get(i);
//
//            if (diffOnlyOneCharacter(beginWord, check)) {
//
//                if (map.get(check) == null) {
//                    wordList.remove(i);
//                    map.put(check, ladderInternal(check, wordList, map));
//                    wordList.add(i, check);
//                }
//
//                if (map.get(check) != 0) {
//                    length = length == 0 ? map.get(check) + 1 : Math.min(length, map.get(check) + 1);
//                }
//            }
//        }
//
//        return length;
//    }
//
//    private boolean diffOnlyOneCharacter(String s1, String s2) {
//        int diff = 0;
//        for (int i = 0; i < s1.length(); i++) {
//            if (s1.charAt(i) != s2.charAt(i)) {
//                diff++;
//
//                if (diff > 1) {
//                    return false;
//                }
//            }
//        }
//
//        return diff == 1;
//    }


}
