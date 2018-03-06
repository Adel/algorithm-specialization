package week1.assignment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static week1.assignment.tree_height.Node;

class tree_heightTest {


    @Test
    void shouldReturnZeroForEmptyTree() {
        tree_height.TreeHeight treeHeight = new tree_height().createTreeHeight();
        Node[] nodes = new Node[0];
        assertEquals(0, treeHeight.computeHeight(nodes, 0));
    }

    @Test
    void shouldReturnOneForOneRootElement() {
        tree_height.TreeHeight treeHeight = new tree_height().createTreeHeight();
        Node[] nodes = new Node[1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
        }
        assertEquals(1, treeHeight.computeHeight(nodes, 0));
    }

    @Test
    @DisplayName("should return 2 for one root and multiple children")
    void shouldReturnOneForCorrectHeight1() {
        tree_height.TreeHeight treeHeight = new tree_height().createTreeHeight();
        Node[] nodes = new Node[4];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
        }
        nodes[2].children.add(1);
        nodes[2].children.add(0);
        nodes[2].children.add(3);
        assertEquals(2, treeHeight.computeHeight(nodes, 2));
    }


    @Test
    @DisplayName("should return 3 for root with grand children")
    void shouldReturnOneForCorrectHeight2() {
        tree_height.TreeHeight treeHeight = new tree_height().createTreeHeight();
        Node[] nodes = new Node[6];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
        }
        nodes[2].children.add(1);
        nodes[2].children.add(0);
        nodes[2].children.add(3);
        nodes[3].children.add(4);
        nodes[3].children.add(5);
        assertEquals(3, treeHeight.computeHeight(nodes, 2));
    }
    @Test
    @DisplayName("should return correct level if each node has one child")
    void shouldReturnOneForCorrectHeight3() {
        tree_height.TreeHeight treeHeight = new tree_height().createTreeHeight();
        Node[] nodes = new Node[6];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
        }
        nodes[0].children.add(1);
        nodes[1].children.add(3);
        nodes[3].children.add(2);
        nodes[2].children.add(4);
        nodes[4].children.add(5);
        assertEquals(6, treeHeight.computeHeight(nodes, 0));
    }
}