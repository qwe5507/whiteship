package com.java.study.whiteship.binarytree;

import java.util.*;

public class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    /*
            Inorder 방식 : 중위 순회 (왼쪽, 루트, 오른쪽 순으로 순회)
         */
    public void dfs(Node node, List<Integer> list) {
        if(node == null) {
            return;
        }

        dfs(node.getLeft(), list);
        list.add(node.getData());
        dfs(node.getRight(), list);
    }

    public List<Integer> bfs(Node node) {
        if(node == null) {
            throw new NullPointerException("Empty Node");
        }

        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node curNode = queue.remove();
            result.add(curNode.getData());

            Node left = curNode.getLeft();
            Node right = curNode.getRight();
            if(left != null) queue.add(left);
            if(right != null) queue.add(right);
        }

        return result;
    }

}
