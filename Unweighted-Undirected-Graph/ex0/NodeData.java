package ex0;

import java.util.Collection;
import java.util.HashMap;

/**
 * This class represent a node of an undirected and unweighted graph.
 * <p>The class implements the node_data interface.</p>
 * The class outlines a set of operations that can be operated on a graph's node.
 * A NodeData holds the fields:
 *      <p>1) A HashMap contains of all its neighbors.</p>
 *      <p>2) A string of information.</p>
 *      <p>3) An integer tag for some algorithms.</p>
 *      <p>4) An integer unique key to associate the node to.</p>
 *
 * @see ex0.node_data
 * @author Eyal Levi
 * https://github.com/LeviEyal
 */
public class NodeData implements node_data {

    private static int numOfVertices = 0;
    private HashMap<Integer,node_data> ni = new HashMap<>();
    private String info = "";
    private int tag = 0;
    private final int key ;

    /**
     * Constructs an empty node and associates it with unique serial key.
     */
    public NodeData() {
        key = numOfVertices++;
    }

    /**
     * Construct a new node deeply copied from a given node.
     * Note: the constructor only copy the info, tag and key values,
     * without its neighbors.
     * @param other - another Node to copy from
     */
    public NodeData(node_data other) {
        ni = new HashMap<>();
        info = other.getInfo();
        tag = other.getTag();
        key = other.getKey();
    }

    /**
     * @return The key that this node associated with
     */
    @Override
    public int getKey() {
        return key;
    }

    /**
     * @return A collection of all neighbors of this node
     */
    @Override
    public Collection<node_data> getNi() {
        return ni.values();
    }

    /**
     * Returns true iff this node and other node associated with key are adjacent.
     * @param key the other node's key
     * @return true if adjacent
     */
    @Override
    public boolean hasNi(int key) {
        return ni.containsKey(key);
    }

    /**
     * Mark node t as neighbor of this node.
     * @param t other node to be neighbor of this node
     */
    @Override
    public void addNi(node_data t) {
        ni.putIfAbsent(t.getKey(),t);
    }

    /**
     * Removes a given node from this node's neighbors.
     * @param node The other node
     */
    @Override
    public void removeNode(node_data node) {
        ni.remove(node.getKey());
    }

    /**
     * @return The information associated with this node
     */
    @Override
    public String getInfo() {
        return info;
    }

    /**
     * Sets this node's information by a given string.
     * @param s The new information string
     */
    @Override
    public void setInfo(String s) {
        info = "" + s;
    }

    /**
     * Returns this node's temporal data (used for algorithms etc.)
     * @return this node's tag
     */
    @Override
    public int getTag() {
        return tag;
    }

    /**
     * Sets this node's tag value
     * @param t - the new value of the tag
     */
    @Override
    public void setTag(int t) {
        tag = t;
    }

    /**
     * Returns a string representation of this node.
     * @return a string representation of this node
     */
    @Override
    public String toString() {
        return "#" + key + " ";
    }
}
