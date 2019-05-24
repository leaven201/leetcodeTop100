package top100.model;

import java.util.ArrayList;

/**
 * @author LinZebin
 * @date 2019-04-13 16:37
 */
public class DirectedGraphNode {
    public int label;
    public ArrayList<DirectedGraphNode> neighbors;

    public DirectedGraphNode(int label) {
        this.label = label;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}
