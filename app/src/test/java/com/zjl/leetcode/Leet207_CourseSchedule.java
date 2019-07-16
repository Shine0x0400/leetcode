package com.zjl.leetcode;

import java.util.HashSet;

/**
 * @author zjl
 * @date 2019-07-18
 */
public class Leet207_CourseSchedule {

//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        // 邻接矩阵
//        int[][] matrix = new int[numCourses][numCourses];
//
//        // 入度
//        int[] indegree = new int[numCourses];
//
//        for (int i = 0; i < prerequisites.length; i++) {
//            matrix[prerequisites[i][1]][prerequisites[i][0]] = 1;
//            indegree[prerequisites[i][0]]++;
//        }
//
//        // BFS
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < numCourses; i++) {
//            if (indegree[i] == 0) {
//                queue.add(i);
//            }
//        }
//
//        int count = 0;
//        while (!queue.isEmpty()) {
//            int course = queue.remove();
//            count++;
//
//            for (int i = 0; i < numCourses; i++) {
//                if (matrix[course][i] == 1) {
//                    if (--indegree[i] == 0) {
//                        queue.add(i);
//                    }
//                }
//            }
//
//        }
//
//        return count == numCourses;
//    }

    // DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 邻接表表示
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        /**
         * 0--not visited, 1--visited, 2--visiting
         */
        int[] visit = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(graph, i, visit)) {
                return false;
            }
        }

        return true;
    }

    /**
     * @return true if exists cyclic, false otherwise.
     */
    private boolean dfs(HashSet<Integer>[] graph, int i, int[] visit) {
        if (visit[i] == 2) {
            return true;
        }

        if (visit[i] == 1) {
            return false;
        }

        visit[i] = 2;
        for (int successor : graph[i]) {
            if (dfs(graph, successor, visit)) {
                return true;
            }
        }

        visit[i] = 1;
        return false;
    }
}
