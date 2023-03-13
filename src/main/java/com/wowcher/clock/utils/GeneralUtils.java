package com.wowcher.clock.utils;

public class GeneralUtils {

    private static final String ZERO = "zero";
    private static String[] oneToNine = {
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    private static String[] tenToNineteen = {
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static String[] others = {
            "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static String solution(int number) {
        if (number == 0)
            return ZERO;
        return generate(number).trim();
    }

    private static String generate(int number) {
        if (number == 0)
            return "";

        if (number <= 9)
            return oneToNine[number - 1];
        else if (number <= 19)
            return tenToNineteen[number % 10];
        else {
            return others[number / 10 - 1] + " " + generate(number % 10);
        }
    }

    public static void validate(String time) {
        try{
            String [] timeArr = time.split(":");
            if(timeArr.length != 2) throw new IllegalArgumentException("Invalid Input String : " +time);
            validateHour(timeArr[0]);
            validateMinutes(timeArr[1]);
        }catch (IllegalArgumentException e) {
            throw e;
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Something went wrong!!");
        }
    }

    public static void validateHour(String hour) {
        try{
            if(hour.length() != 2) throw new IllegalArgumentException("Invalid Hour Value : " + hour);
            int numeric = Integer.parseInt(hour);
            if(numeric < 0 || numeric > 23) throw new IllegalArgumentException("Invalid Hour Value : " + hour);
        }catch (Exception e) {
            throw new IllegalArgumentException("Invalid Hour Value : " + hour);
        }
    }
    public static void validateMinutes(String minute) {
        try {
            if(minute.length() != 2) throw new IllegalArgumentException("Invalid Minute Value : " + minute);
            int numeric = Integer.parseInt(minute);
            if(numeric < 0 || numeric > 59) throw new IllegalArgumentException("Invalid Minute Value : " + minute);
        }catch (Exception e) {
            throw new IllegalArgumentException("Invalid Minute Value : " + minute);
        }
    }
}
