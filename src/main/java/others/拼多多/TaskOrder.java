package others.拼多多;

import top100.model.DirectedGraphNode;

import java.util.*;

/**
 * @author LinZebin
 * @date 2019-07-28 15:57
 */
public class TaskOrder {

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here

        ArrayList<DirectedGraphNode> order = new ArrayList<>();

        if(graph == null){
            return order;
        }

        //1.count indegree
        Map<DirectedGraphNode, Integer> indegree = getIndegree(graph);

        //bfs
        Queue<DirectedGraphNode> queue = new LinkedList<>();

        for(DirectedGraphNode node : graph){
            if(indegree.get(node) == 0){
                queue.offer(node);
                order.add(node);
            }
        }

        while(! queue.isEmpty()){
            DirectedGraphNode node = queue.poll();
            for(DirectedGraphNode neighbor : node.neighbors){
                indegree.put(neighbor, indegree.get(neighbor) -1 );
                if(indegree.get(neighbor) == 0){
                    queue.offer(neighbor);
                    order.add(neighbor);
                }
            }
        }
        return order;

    }

    private  Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph){
        //1.count indegree
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for(DirectedGraphNode node : graph){
            indegree.put(node,0);
        }
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode neighbor : node.neighbors){
                //node -> neighbor
                indegree.put(neighbor,indegree.get(neighbor)+1);
            }
        }
        return indegree;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] tasks = new int[N];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = in.nextInt();
        }

        int[][] realtions = new int[M][2];
        for (int row = 0; row < M; row++){
            for (int col=0; col<2; col++){
                realtions[row][col] = in.nextInt();
            }
        }
        ArrayList<DirectedGraphNode> graph = new ArrayList<>();
        for (int i=0; i<N; i++){
            DirectedGraphNode node = new DirectedGraphNode(i+1);
            graph.add(node);
        }
        for (int[] realtion : realtions) {
            int nodei = realtion[0];
            int nei = realtion[1];
            DirectedGraphNode node = graph.get(nodei - 1);
            node.neighbors.add(graph.get(nei - 1));
        }

        TaskOrder taskOrder = new TaskOrder();
        ArrayList<DirectedGraphNode> directedGraphNodes = taskOrder.topSort(graph);
        for (DirectedGraphNode directedGraphNode : directedGraphNodes) {
            System.out.println(directedGraphNode.label);
        }

    }

}
