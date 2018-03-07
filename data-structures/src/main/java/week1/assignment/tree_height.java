package week1.assignment;

import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    static class Node {
        List<Integer> children = new ArrayList<>();
        int height = 0;

        boolean isLeaf() {
            return children.size() == 0;
        }
    }

    public class TreeHeight {
        int n;
        Node[] nodes;
        int root;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node();
            }
            for (int i = 0; i < n; i++) {
                int parent = in.nextInt();
                if (parent == -1) {
                    root = i;
                } else {
                    nodes[parent].children.add(i);
                }
            }
        }

        int computeHeight() {
            if (nodes.length == 0) {
                return 0;
            }
            int maxHeight = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(root);
            nodes[root].height = 1;
            while (!stack.isEmpty()) {
                Node currentNode = nodes[stack.pop()];
                if (currentNode.isLeaf()) {
                    maxHeight = Math.max(currentNode.height, maxHeight);
                } else {
                    currentNode.children.forEach(i -> {
                        nodes[i].height = currentNode.height + 1;
                        stack.push(i);
                    });
                }
            }
            return maxHeight;
        }
    }

    TreeHeight createTreeHeight() {
        return new TreeHeight();
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new tree_height().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public void run() throws IOException {
        TreeHeight tree = new TreeHeight();
        tree.read();
        System.out.println(tree.computeHeight());
    }
}