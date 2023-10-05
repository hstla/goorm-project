package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NodeTest {

    @DisplayName("노드를 생성하고 연결한다.")
    @Test
    void createNode() {
        Node<Integer> previousNode = new Node<>(null, 1, null);
        Node<Integer> nextNode = new Node<>(null, 3, null);
        Node<Integer> currentNode = new Node<>(previousNode, 2, nextNode);

        assertThat(currentNode.getItem()).isEqualTo(2);
        assertThat(currentNode.getPrev()).isEqualTo(previousNode);
        assertThat(currentNode.getNext()).isEqualTo(nextNode);
    }
}