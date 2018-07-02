package exercises;

import java.lang.reflect.Array;
import java.util.*;

public class Collections {

    public static void main(String[] args) {
        //setExamples();
        //listExamples();
        mapExmaples();
    }

    static void setExamples() {
        // Ref.: http://codejava.net/java-core/collections/java-set-collection-tutorial-and-examples
        List<Integer> listNumbers = Arrays.asList(3, 9, 1, 4, 7, 2, 5, 3, 8, 9, 1, 3, 8, 6);
        System.out.println(listNumbers);

        Set<Integer> uniqueNumbers = new HashSet<>(listNumbers);
        System.out.println(uniqueNumbers);

        uniqueNumbers.add(10000);
        if (uniqueNumbers.contains(10000))
            System.out.println("My Set contains the number " + 1000);
        else
            System.out.println("My Set doesn't contain the number " + 1000);

        System.out.println("Set size is: " + uniqueNumbers.size());

        uniqueNumbers.clear();

        if (uniqueNumbers.isEmpty())
            System.out.println("My Set is empty");
        else
            System.out.println("My Set is not empty");

        Set<String> names = new HashSet<>();
        names.add("Tom");
        names.add("Mary");
        names.add("Peter");
        names.add("Alice");

        for (String name : names) {
            System.out.println(name);
        }

        Set<Integer> s1 = new HashSet<>(Arrays.asList(20, 56, 89, 31, 8, 5));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(8, 89));

        if (s1.containsAll(s2)) {
            System.out.println("s2 is a subset of s1 because all numbers of s2 are in s1");
        }

        s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7, 9));
        s2 = new HashSet<>(Arrays.asList(2, 4, 6, 8));

        System.out.println("s1 before intersection: " + s1);

        s1.retainAll(s2);

        System.out.println("s1 after intersection: " + s1);
    }

    static void listExamples() {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(3, 9, 1, 4, 7, 2, 5, 3, 8, 9, 1, 3, 8, 6));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(3, 9));

        if (l1.containsAll(l2))
            System.out.println("l1 contains all the elements of l2");
        else
            System.out.println("l1 doesn't contains all the elements of l2");

        List<Integer> listToAdd = new ArrayList<>(Arrays.asList(100, 200, 300));
        System.out.println("l2 before: " + l2);
        l2.addAll(listToAdd);
        System.out.println("l2 after: " + l2);


        System.out.println("l2 before: " + l2);
        l2.removeAll(listToAdd);
        System.out.println("l2 after: " + l2);

        System.out.println("l1 before: " + l1);
        l1.retainAll(l2);
        System.out.println("l1 after: " + l1);

        int n = 9;
        if (l1.contains(n))
            System.out.println("l1 contains the element " + l1.get(l1.indexOf(n)) + " in index " + l1.indexOf(n));
        else
            System.out.println("l1 doesn't contains the element '3'");


        List<String> days = new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday", "Sunday"));

        for (String day : days) {
            System.out.println("Day is: " + day);
        }

        l1.clear();
        System.out.println("List l1 size is: " + l1.size());

    }

    static void mapExmaples() {
        Map<String, String> m1 = new HashMap<>();
        m1.put("Key", "Value");
        m1.put("1234", "David Corral");
        m1.put("12345", "Pedro Soto");
        System.out.println(m1);


        m1.forEach((k, v) -> {
            System.out.println("Key is: " + k);
            System.out.println("Value is: " + v);
        });

        System.out.println("The size of my map is: " + m1.size());

        if (m1.containsKey("1234"))
            System.out.println("The value of the key '1234' is " + m1.get("1234"));

        if (m1.containsValue("David Value"))
            System.out.println("The value 'David Value' exists");

        Map<Integer, String> nameForId = new HashMap<>();
        nameForId.put(1, "Java");
        nameForId.put(2, "Type");
        System.out.println("Original map: " + nameForId);

        nameForId.compute(1, (key, oldVal) -> oldVal.concat("Script"));
        nameForId.compute(2, (key, oldVal) -> oldVal.concat("Script"));
        System.out.println("Recomputed map: " + nameForId);
        Map<String, String> m2 = new HashMap<String, String>() {
            {
                put("1", "one");
                put("2", "two");
            }
        };

        System.out.println("m1 before: " + m1);
        m1.putAll(m2);
        System.out.println("m1 after: " + m1);

    }
}
