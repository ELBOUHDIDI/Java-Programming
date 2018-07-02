package exercises;

interface Operations {
    double pi = 3.14159;

    int sum(int a, int b);

    int prod(int a, int b);

    String concat(String s1, String s2);

    String substring(String s, int a, int b);
}

class Worker implements Operations {

    public double getPI() {
        return pi;
    }

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int prod(int a, int b) {
        return a * b;
    }

    @Override
    public String concat(String s1, String s2) {
        return s1.concat(s2);
    }

    @Override
    public String substring(String s, int a, int b) {
        return s.substring(a, b);
    }
}

public class Interfaces {

    public static void main(String args[]) {
        Worker worker = new Worker();

        System.out.println("PI is " + worker.getPI());

        System.out.println("2 + 2 = " + worker.sum(2, 2));

        System.out.println("2 * 2 = " + worker.prod(2, 2));

        System.out.println("Hello concat(World) = " + worker.concat("Hello", "World!"));

        System.out.println("Hello substring(0,2) = " + worker.substring("Hello", 0, 2));

    }
}