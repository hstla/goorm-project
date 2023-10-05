package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyLinkedListTest {
    private MyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyLinkedList<>();
    }

    @DisplayName("add와 get 메서드를 테스트한다.")
    @Test
    void addOrGetTest() {
        // given
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // when
        Integer result = list.get(3);

        // then
        assertThat(result).isEqualTo(4);
    }

    @DisplayName("-1값을 넣어 IndexOutOfBoundsException 를 발생시킨다.")
    @Test
    void exceptionTest() {
        // given

        // when then
        assertThatThrownBy(() -> list.get(-1))
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessage("인덱스가 작거나 큽니다.");
    }

    @DisplayName("delete 메서드를 테스트한다.")
    @Test
    void deleteTest() {
        // given
        list.add(1);
        list.add(2);
        list.add(3);

        // when
        list.delete(1);

        // then
        assertThat(list.size())
            .isEqualTo(2);
    }

    @DisplayName("delete 메서드에 인덱스보다 큰 값을 넣어 IndexOutOfBoundsException 를 발생시킨다.")
    @Test
    void deleteExceptionTest() {
        // given
        list.add(1);

        // when then
        assertThatThrownBy(() -> list.delete(2))
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessage("인덱스가 작거나 큽니다.");
    }

    @DisplayName("hasNext 메서드는 list에 값이 있을 때 True 를 반환한다.")
    @Test
    void iteratorHasNextTrueTest() {
        // given
        list.add(1);

        // when
        Iterator<Integer> iter = list.iterator();

        // then
        assertThat(iter.hasNext()).isTrue();
    }

    @DisplayName("hasNext 메서드는 목록이 비어있을 때 false 를 반환한다.")
    @Test
    void iteratorHasNextFalseTest() {
        // given
        // when
        Iterator<Integer> iter = list.iterator();

        // then
        assertThat(iter.hasNext()).isFalse();
    }

    @DisplayName("Next 메서드는 다음 값을 반환한다.")
    @Test
    void iteratorNextHappyTest() {
        // given
        list.add(1);
        list.add(2);
        list.add(3);
        // when
        Iterator<Integer> iter = list.iterator();

        // then
        assertThat(iter.next()).isEqualTo(1);
        assertThat(iter.next()).isEqualTo(2);
        assertThat(iter.next()).isEqualTo(3);
    }

    @DisplayName("Next 메서드는 다음 값이 없으면 NoSuchElementException 를 반환한다.")
    @Test
    void iteratorNextExceptionTest() {
        // given
        list.add(1);
        list.add(2);
        // when
        Iterator<Integer> iter = list.iterator();

        // then
        assertThat(iter.next()).isEqualTo(1);
        assertThat(iter.next()).isEqualTo(2);
        assertThatThrownBy(iter::next)
            .isInstanceOf(NoSuchElementException.class)
            .hasMessage("다음은 없어요.");
    }




}