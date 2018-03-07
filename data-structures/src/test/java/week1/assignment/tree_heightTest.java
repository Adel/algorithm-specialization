package week1.assignment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import utils.TestFiles;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static week1.assignment.tree_height.Node;

class tree_heightTest {


    @Test
    void shouldReturnZeroForEmptyTree() {
        tree_height.TreeHeight treeHeight = new tree_height().createTreeHeight();
        treeHeight.nodes = new Node[0];
        assertEquals(0, treeHeight.computeHeight());
    }

    @Test
    void shouldReturnOneForOneRootElement() {
        tree_height.TreeHeight treeHeight = new tree_height().createTreeHeight();
        Node[] nodes = new Node[1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
        }
        treeHeight.nodes = nodes;
        treeHeight.root = 0;
        assertEquals(1, treeHeight.computeHeight());
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
        treeHeight.nodes = nodes;
        treeHeight.root = 2;
        assertEquals(2, treeHeight.computeHeight());
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
        treeHeight.nodes = nodes;
        treeHeight.root = 2;
        assertEquals(3, treeHeight.computeHeight());
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
        treeHeight.nodes = nodes;
        treeHeight.root = 0;
        assertEquals(6, treeHeight.computeHeight());
    }

    @Test
    void testScanner() throws IOException {
        String input = "5\n" + "4 -1 4 1 1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        tree_height.TreeHeight treeHeight = new tree_height().createTreeHeight();
        treeHeight.read();
        assertEquals(5, treeHeight.nodes.length);
    }

    @TestFactory
    Collection<DynamicTest> shouldGetCorrectResultForTestFiles() throws IOException {
        return TestFiles.loadFiles("tree_height")
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(e -> DynamicTest.dynamicTest(e.getKey(), () -> {
                    List<String> inputs = e.getValue().getInputs();
                    String input = inputs.get(0) + "\n" + inputs.get(1);
                    InputStream in = new ByteArrayInputStream(input.getBytes());
                    System.setIn(in);
                    tree_height.TreeHeight treeHeight = new tree_height().createTreeHeight();
                    treeHeight.read();
                    assertEquals(e.getValue().getOutput(), treeHeight.computeHeight() + "");
                }))
                .collect(Collectors.toList());
    }
}