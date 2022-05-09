package com.java.study.whiteship.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class BinaryTreeTest {
    private static BinaryTree binaryTree;

    @BeforeEach
    void init() {
        Node node10 = new Node(10);
        Node node9 = new Node(9);
        Node node8 = new Node(8);
        Node node7 = new Node(7);
        Node node6 = new Node(6);
        Node node5 = new Node(5);
        Node node4 = new Node(4, node9, node10);
        Node node3 = new Node(3, node7, node8);
        Node node2 = new Node(2, node5, node6);
        Node node1 = new Node(1, node3, node4);
        Node node0 = new Node(0, node1, node2);
        binaryTree = new BinaryTree(node0);
    }

    @Test
    @DisplayName("dfs 순회 성공")
    void dfsTest() {
        //given
        Node root = binaryTree.getRoot();
        List<Integer> list = new ArrayList<>();

        //when
        binaryTree.dfs(root, list);

        //then
        assertThat(list).isEqualTo(Arrays.asList(7, 3, 8, 1, 9, 4, 10, 0, 5, 2, 6));
    }

    @Test
    @DisplayName("bfs 순회 성공")
    void bfsTest() {
        //given
        Node root = binaryTree.getRoot();

        //when
        List<Integer> result = binaryTree.bfs(root);

        //then
        assertThat(result).isEqualTo(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    @DisplayName("bfs 노드 비어있을때")
    void bfsTestFail() {
        //given
        Node root = null;

        //when
        //then
        assertThrows(NullPointerException.class, () -> binaryTree.bfs(root));
    }


}