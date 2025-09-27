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

        System.out.println("stringList = " + stringList);
        System.out.println("integerList = " + integerList);
        integerList.set( 1, 10 );
        System.out.println("integerList = " + integerList);
        stringList.clear();
        System.out.println("stringList = " + stringList);
        System.out.println("integerList.isEmpty() = " + integerList.isEmpty());
        System.out.println(integerList.contains(10));
        System.out.println(integerList.indexOf(10));

    } // main end
} // class end