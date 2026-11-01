package edu.course.lab01;

/**
 * Небольшие методы для первой лабораторной работы.
 */
public final class CourseToolkit {

    private CourseToolkit() {
        // Утилитарный класс не должен иметь экземпляров.
    }

    /**
     * Возвращает true, если число четное.
     */
    public static boolean isEven(int number){
        if( number % 2 == 0){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isPrime(int number){
        if (number < 2){
            return false;
        }
        if (number ==2){
           return true; 
        }
        if (number % 2 == 0){
            return false;
        }
        for (int divisor = 3; divisor * divisor <=number ; divisor +=2){
            if (number % divisor == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome(String text){
        if ( text == null){
            throw new IllegalArgumentException("text is null");
        }
        int left = 0;
        int right = text.length() -1;
        while (left < right){
            if (text.charAt(left)!= text.charAt(right)){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }
    public static double average(int[] values){
        if (values == null || values.length == 0){
            throw new IllegalArgumentException("values is null or empty");
        }
        double sum = 0.0;
        for (int value : values){
            sum += value;
        }
        return sum / values.length;
    }
    public static int min (int [] values){
        if (values == null || values.length ==0){
            throw new IllegalArgumentException("values is null or empty");
        }
        int minValue = values[0];
        for ( int i = 1; i < values.length; i++ ){
            if (values[i] < minValue){
                minValue = values[i];
            }
        }
        return minValue;
    }
    public static int max (int [] values){
        if (values == null || values.length ==0){
            throw new IllegalArgumentException("values is null or empty");
        }
        int maxValues = values[0];
        for (int i=1; i < values.length; i++){
            if (values[i] > maxValues){
                maxValues = values[i];
            }
        }
        return maxValues;

    }
}