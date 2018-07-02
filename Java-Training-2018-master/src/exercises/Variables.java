package exercises;

public class Variables {

    public static void main(String[] args) {

        // NUMERIC VARIABLES
        int a = 0;
        int b;
        long c = System.currentTimeMillis();
        double d = 2.0;

        // ALPHANUMERIC VARIABLES
        String e = "Hello World!";
        char f = 'd';

        // TRUE/FALSE
        boolean g = true;
        g = false;

        // Arrays
        int[] h = new int[10]; // Array of 10 integer
        int[] i = {1, 2, 3};
        String[] j = {"Hello", "Guys", "From", "Erasmus!"};

        // CONSTANTS
        final double k = 10.5;
        // k = 9.5; // ERROR!!

        // SOME OPERATIONS
        int sum = a + 2;
        System.out.println("a (" + a + ") + 2 = " + sum);
        a++; // Equal to a = a + 1;
        System.out.println("a now is: " + a);

        String concat = e.concat(" Are you okay?");
        System.out.println(concat);

        System.out.println("The first number in my array is: " + i[0]);
        System.out.println("My array has " + h.length + " elements");

        // Transformations
        String[] numbersAsString = {"0", "1", "2"};
        int newNumber = Integer.parseInt(numbersAsString[0]);
        System.out.println("Mi number now is of type Int: " + newNumber);

    }

}
