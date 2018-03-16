package com.sangmu.Collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        demo1();
    }

    public static void demo1() {
        TreeSet<Integer> ts = new TreeSet<>(

                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return -(o1-o2); //倒序
                    }
                }
        );
        ts.add(1);
        ts.add(2);
        ts.add(3);
        ts.add(4);
        ts.add(5);

        Iterator ito = ts.iterator();
        while (ito.hasNext()){
            System.out.println(ito.next());
        }
    }
    public static void demo() {
        TreeSet<Person> ts = new TreeSet<>();
        ts.add(new Person("张三", 23));
        ts.add(new Person("李四", 13));
        ts.add(new Person("周七", 13));
        ts.add(new Person("王五", 43));
        ts.add(new Person("赵六", 33));

        Iterator ito = ts.iterator();
        while (ito.hasNext()){
            System.out.println(ito.next());
        }
    }

    public static class Person implements Comparable<Person> {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }


        public int compareTo(Person o) {
            return -1;                //当compareTo方法返回0的时候集合中只有一个元素
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


}
