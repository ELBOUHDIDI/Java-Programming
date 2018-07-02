package exercises;

import java.util.Calendar;

public class Exceptions {

    public static void main(String[] args) {

        try {
            String name = null;
            System.out.println("My name is: " + name.toString());
        } catch (NullPointerException e) {
            System.out.println("Exception detected! " + e.toString());
            e.printStackTrace();
        }


        try {
            String a = "one";
            int b = Integer.parseInt(a);
        } catch (NumberFormatException e) {
            System.out.println("Exception detected! " + e.toString());
            e.printStackTrace();
        }


        try {
            int[] array = new int[10];
            System.out.println(array[11]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception detected! " + e.toString());
            e.printStackTrace();
        }

        try {
            int i = setWkday("LOL");
        } catch (IllegalArgumentException e) {
            System.out.println("Exception detected! " + e.toString());
            e.printStackTrace();
        }
    }

    static int setWkday(String weekDay) throws IllegalArgumentException {
        if (weekDay.compareToIgnoreCase("MON") == 0) {
            return Calendar.MONDAY;
        } else if (weekDay.compareToIgnoreCase("TUE") == 0) {
            return Calendar.TUESDAY;
        } else if (weekDay.compareToIgnoreCase("WED") == 0) {
            return Calendar.WEDNESDAY;
        } else if (weekDay.compareToIgnoreCase("THU") == 0) {
            return Calendar.THURSDAY;
        } else if (weekDay.compareToIgnoreCase("FRI") == 0) {
            return Calendar.FRIDAY;
        } else if (weekDay.compareToIgnoreCase("SAT") == 0) {
            return Calendar.SATURDAY;
        } else if (weekDay.compareToIgnoreCase("SUN") == 0) {
            return Calendar.SUNDAY;
        } else {
            throw new IllegalArgumentException("Illegal Week Day :" + weekDay);
        }
    }
}
