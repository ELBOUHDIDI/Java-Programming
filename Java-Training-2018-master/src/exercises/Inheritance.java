package exercises;

public class Inheritance {

    public static void main(String[] args) {
        Dog max = new Dog("Max", 5, 15.0);
        System.out.println("My dog's name is: " + max.getName());
        System.out.println("My dog's age is: " + max.getAge());
        System.out.println("My dog's weight is: " + max.getWeight());

        Animals animal = new Animals("Generic",0);
        System.out.println("My animals's name is: " + animal.getName());
    }

}

class Animals {
    protected String name;
    protected int age;

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAge(int newAge) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}

class Dog extends Animals {

    private double weight;

    public Dog(String name, int age, double weight) {
        super(name, age);
        this.setWeight(weight);
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }
}
