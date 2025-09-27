package custom;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        list.add("a");


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


    } // main end
} // class end