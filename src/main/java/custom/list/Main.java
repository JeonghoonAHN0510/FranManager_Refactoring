package custom.list;

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
        System.out.println("integerList = " + integerList);
        integerList.add(1, 100);
        System.out.println("integerList = " + integerList);

    } // main end
} // class end