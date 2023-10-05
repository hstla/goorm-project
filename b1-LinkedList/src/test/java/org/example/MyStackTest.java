package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyStackTest {
    private MyStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new MyStack<>();
    }
    @DisplayName("push 메서드는 요소를 스택에 추가한다.")
    @Test
    void pushTest() {
        stack.push(1);
        assertThat(stack.peek()).isEqualTo(1);
    }

    @DisplayName("pop 메서드는 스택의 상단에서 요소를 제거하고 반환한다.")
    @Test
    void popTest() {
        stack.push(1);
        stack.push(2);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.peek()).isEqualTo(1);
    }

    @DisplayName("pop 메서드는 스택이 비어 있으면 예외를 발생시킨다.")
    @Test
    void popOnEmptyStackTest() {
        assertThatThrownBy(stack::pop)
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("stack이 비었다.");
    }

    @DisplayName("peek 메서드는 스택이 비어 있으면 예외를 발생시킨다.")
    @Test
    void peekOnEmptyStackTest() {
        assertThatThrownBy(stack::peek)
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("stack이 비었다.");
    }
}