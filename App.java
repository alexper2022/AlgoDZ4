package DZ4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Задайте размер списка (n): ");
        int n = scan.nextInt();
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodeList.add(treeBuild(i));
        }
        for (Node i : nodeList) {
            printNode(i, "");
        }
    }

    static void printNode(Node node, String sp) {
        if (node != null) {
            System.out.println(sp + node.value);
            printNode(node.right, sp + "  ");
            printNode(node.left, sp + "  ");
        }
    }

    static Node treeBuild(int n) {
        Node node = null;
        if (n == 0)
            return node;
        else {
            node = new Node(new Random().nextInt(100));
            node.left = treeBuild(n / 2);
            node.right = treeBuild(n - n / 2 - 1);
        }
        return node;
    }
}

