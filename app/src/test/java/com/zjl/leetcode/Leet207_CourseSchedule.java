package com.zjl.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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

    // 面向过程方法：从依赖项为0的课程逐个学习，看最终能不能学完全部课程
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) {
            return true;
        }

        int[] preReqCnt = new int[numCourses];
        HashMap<Integer, List<Integer>> successors = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            successors.put(i, new ArrayList<Integer>());
        }

        for (int[] prerequisite : prerequisites) {
            preReqCnt[prerequisite[0]]++;
            successors.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            int j;
            for (j = 0; j < numCourses; j++) {
                if (preReqCnt[j] == 0) {
                    preReqCnt[j] = -1;
                    break;
                }
            }

            if (j == numCourses) {
                return false;
            }

            for (Integer js : successors.get(j)) {
                preReqCnt[js]--;
            }
        }

        return true;
    }
}
