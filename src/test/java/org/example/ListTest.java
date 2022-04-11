//package org.example;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * @author lvle
// * @date 2021-02-22 00:35
// */
//
//public class ListTest {
//
//    public static void main(String[] args) {
//        LinkedList<String> linkedList = new LinkedList();
//        linkedList.add("1");
//        linkedList.add("2");
//        linkedList.add("3");
//        linkedList.add("4");
//        linkedList.add("5");
//        while (linkedList.iterator().hasNext()){
//            System.out.println(linkedList.poll());
//        }
//        System.out.println(linkedList);
//
//        String[] str = new String[]{"1","2","3","4"};
//
//        List<String> strings = Arrays.asList(str);
//        System.out.println(strings);
//        ArrayList<String> stringArrayList = new ArrayList<String>(strings);
//        stringArrayList.add("5");
//
//        System.out.println(strings);
//    }
//}
