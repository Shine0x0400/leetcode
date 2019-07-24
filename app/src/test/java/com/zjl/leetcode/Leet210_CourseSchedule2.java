package com.zjl.leetcode;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author zjl
 * @date 2019-07-24
 */
public class Leet210_CourseSchedule2 {

    private LinkedList<Integer> ans;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }

        ans = new LinkedList<>();

        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }

        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
        }

        // 0-not visited, 1-visited, 2-visiting
        int visited[] = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (dfs(graph, i, visited)) {
                    return new int[0];
                }
            }
        }

        int[] res = new int[numCourses];
        int i = 0;
        for (int v : ans) {
            res[i++] = v;
        }
        return res;

    }

    /**
     * @return true if exists cyclic, false otherwise.
     */
    private boolean dfs(HashSet<Integer>[] graph, int i, int[] visited) {
        if (visited[i] == 2) {
            return true;
        }

        if (visited[i] == 1) {
            return false;
        }

        visited[i] = 2;
        for (int v : graph[i]) {
            if (dfs(graph, v, visited)) {
                return true;
            }
        }

        visited[i] = 1;
        ans.addFirst(i);
        return false;
    }

//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        int[] empty = new int[0];
//        if (numCourses <= 0) {
//            return empty;
//        }
//
//        int[] ans = new int[numCourses];
//
//        // 入度
//        int[] inDegree = new int[numCourses];
//        // 邻接矩阵
//        int[][] graph = new int[numCourses][numCourses];
//
//        for (int[] edge : prerequisites) {
//            inDegree[edge[0]]++;
//            graph[edge[1]][edge[0]] = 1;
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        int index = 0;
//        for (int i = 0; i < numCourses; i++) {
//            if (inDegree[i] == 0) {
//                queue.add(i);
//            }
//        }
//
//        // BFS
//        while (!queue.isEmpty()) {
//            int v = queue.remove();
//            ans[index++] = v;
//
//            for (int i = 0; i < numCourses; i++) {
//                if (graph[v][i] == 1) {
//                    if (--inDegree[i] == 0) {
//                        queue.add(i);
//                    }
//                }
//            }
//        }
//
//        return index == numCourses ? ans : empty;
//    }
}
