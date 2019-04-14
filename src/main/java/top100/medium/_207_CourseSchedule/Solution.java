package top100.medium._207_CourseSchedule;

import org.junit.Test;
import top100.utils.DirectedGraphNode;

import java.util.*;

/**
 * @author LinZebin
 * @date 2019-04-13 15:02
 */
public class Solution {

    // 判断有向图是否有环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<DirectedGraphNode> graph = buildGraph(numCourses, prerequisites);
        Map<DirectedGraphNode, Integer> indegrees = countIndegree(graph);
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            if (indegrees.get(node) == 0) {
                queue.add(node);
            }
        }
        ArrayList<DirectedGraphNode> preCourse = new ArrayList<>();
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            preCourse.add(node);
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                if (indegrees.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return preCourse.size() == numCourses;
    }

    // 生成有向图
    private ArrayList<DirectedGraphNode> buildGraph(int numCourses, int[][] prerequisites) {
        ArrayList<DirectedGraphNode> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new DirectedGraphNode(i));
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            graph.get(from).neighbors.add(graph.get(to));
        }
        return graph;
    }

    // 计算图中哥点的入度
    private Map<DirectedGraphNode, Integer> countIndegree(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            map.put(node, 0);
        }
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                map.put(neighbor, map.get(neighbor) + 1);
            }
        }
        return map;
    }


    @Test
    public void test() {
        int num = 5;
        int[][] pre = {{0, 1}, {1, 2}, {3, 4}};
        boolean canFinish = canFinish(num, pre);
        System.out.println(canFinish);
    }


}


