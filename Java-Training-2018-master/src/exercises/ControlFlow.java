package exercises;

public class ControlFlow {

    public static void main(String[] args) {

        // IF - ELSE
        int a = 10;
        if (a % 2 == 0)
            System.out.println("My number is even");
        else
            System.out.println("My number odd");

        if (a < 5)
            System.out.println("My number is less than 5");
        else if (a < 9)
            System.out.println("My number is less than 9");
        else
            System.out.println("My number is bigger than 9");


        // SWITCH
        int dayOfWeek = 1;
        switch (dayOfWeek) {
            case 1:
                System.out.println("Today is Monday");
                break;
            case 2:
                System.out.println("Today is Tuesday");
                break;
            case 3:
                System.out.println("Today is Wednesday");
                break;
            case 4:
                System.out.println("Today is Thursday");
                break;
            case 5:
                System.out.println("Today is Friday");
                break;
            case 6:
                System.out.println("Today is Saturday");
                break;
            case 7:
                System.out.println("Today is Sunday");
                break;
            default:
                System.out.println("The number is not a day of the week!");
                break;
        }


        // WHILE
        int count = 0;
        while (count < 11) {
            System.out.println("WHILE ||| Count is: " + count);
            count++;
        }
        count = 0;
        do {
            System.out.println("DO-WHILE ||| Count is: " + count);
            count++;
        } while (count < 11);

        // FOR
        for (int i = 1; i < 11; i++) {
            System.out.println("Iteration number " + i);
        }
    }
}
