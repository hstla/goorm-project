package org.example;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyQueueTest {
    private MyQueue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new MyQueue<>();
    }

    @DisplayName("enquque 메서드는 요소를 큐에 추가한다.")
    @Test
    void enqueue() {
        queue.enqueue(1);

        assertThat(queue.peek()).isEqualTo(1);
    }

    @DisplayName("dequeue 메서드는 큐의 앞에서 요소를 제거하고 반환한다.")
    @Test
    void dequeue() {
        queue.enqueue(1);
        queue.enqueue(2);

        assertThat(queue.dequeue()).isEqualTo(1);
        assertThat(queue.peek()).isEqualTo(2);
    }

    @DisplayName("dequeue 메서드는 큐가 비어 있으면 예외를 발생시킨다.")
    @Test
    void dequeueException() {
        assertThatThrownBy(queue::dequeue)
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("queue가 비었다.");
    }

    @DisplayName("peek 메서드는 큐가 비어 있으면 예외를 발생시킨다.")
    @Test
    void peekException() {
        assertThatThrownBy(queue::peek)
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("queue가 비었다.");
    }
}