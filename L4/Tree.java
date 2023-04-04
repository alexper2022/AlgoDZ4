package DZ4.L4;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Tree {
    Node root;
//      обход в глубину, сначала один ребенок и все его дети,
//      потом другой ребенок и все его дети и т.д.
//      private Node find(Node node, int value) {
//        if (node.value == value) {
//            return node;
//        } else {
//            for (Node child : node.children) {
//                Node result = find(child, value);
//                if (result != null) {
//                    return null;
//                }
//            }
//        }
//        return null;
//
//    }


    // обход в ширину(сначала все дети, потом дети детей и т.д.)
    private Node find(int value) {
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0) {
            List<Node> nextLine = new ArrayList<>();
            for (Node node : line) {
                if (node.value == value) {
                    return node;
                }
                nextLine.addAll(node.children);

            }
            line = nextLine;
        }
        return null;
    }

    public boolean exist(int value) {
        if (root != null) {
            Node node = find(value);
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    public class Node {
        int value;
        List<Node> children;

    }
}
