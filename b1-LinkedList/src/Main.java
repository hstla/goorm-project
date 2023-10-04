
public class Main {

  public static void main(String[] args) {
    MyLinkedList<Integer> list = new MyLinkedList<>();

    list.add(0);
    list.add(3);
    list.add(5);
    list.add(7);
    list.delete(3);
    System.out.println(list.get(2));
    System.out.println(list);
  }
}