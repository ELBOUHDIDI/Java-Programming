package exercises;

public class Classes {

    public static void main(String[] args) {
        Animal bobby = new Animal("Dog", 3);
        System.out.println(bobby.getAnimal());
        System.out.println("[VARIABLE] Bobby is " + bobby.age);
        System.out.println("[METHOD] Bobby is " + bobby.getAge());
        // System.out.println("[VARIABLE] Bobby is a " + bobby.type); // ERROR!
        System.out.println("[METHOD] Bobby is a " + bobby.getType());

        bobby.setAge(10);
        System.out.println("Bobby now is " + bobby.getAge());

    }
}

class Animal {
    private String type;
    public int age;

    public Animal(String type, int age) {
        this.type = type;
        this.age = age;
    }

    public String getAnimal() {
        return "My Animal is a " + getType() + " and is " + getAge() + " years old!";
    }

    public String getType() {
        return this.type;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }
}