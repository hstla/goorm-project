package org.example;

public class MyQueue<T> {

    private MyLinkedList<T> list = new MyLinkedList<>();

    // enqueue
    public void enqueue(T item) {
        list.add(item);
    }


    // dequeue
    public T dequeue() {
        if (list.isEmpty()) {
            throw new IllegalStateException("queue가 비었다.");
        }
         T frontItem = list.get(0);
        list.delete(0);
        return frontItem;
    }

    // peek
    public T peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException("queue가 비었다.");
        }
        return list.get(0);
    }
}

// 전제, 조집 Off 됐을 때 0,1 전체
// 조회
// status가 0번일때 그대로, 1번일때 0,1 같이 주기

// 커리큘럼 아이디, 모집완료 보기, 버튼 안에 넣기,
// jar - application level에서 spring check
//  서버가 죽었을 때 - 엘라스틱 서치같은  클라우드 와치, 로그 찍는 거, 클라우드 와치, 사용자를
// 3등까지  4명 /  리팩토링, 테스트, 리팩토링 / 모집중 모집완료 / 프론트 모바일 보기

//1. 커리큘럼 선택 뭐했는지
//2.
// 3. 햄버거바
