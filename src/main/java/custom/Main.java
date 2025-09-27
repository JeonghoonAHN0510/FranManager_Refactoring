package custom;

public class Main {
    public static void main(String[] args) {

        CustomList<String> stringList = new CustomList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");

        CustomList<Integer> integerList = new CustomList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        System.out.println("[삭제 전] stringList = " + stringList);
        System.out.println("[삭제 전] integerList = " + integerList);

        stringList.remove(1);
        integerList.remove(1);

        System.out.println("[삭제 후] stringList = " + stringList);
        System.out.println("[삭제 후] integerList = " + integerList);

    } // main end
} // class end