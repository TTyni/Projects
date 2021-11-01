/**
 * Class MyConsole contains a method to read values from console and checks if they are integer.
 * 
 *  @author Tommi Tyni
 *  @return returns integer
 */

package fi.tuni.tamk.tiko.tommityni.util;

import java.io.Console;  

public class MyConsole {

    public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {

        Console c = System.console();
        boolean repeat = true;
        int number = 0;

        while(repeat) {
            try {

                
                number = Integer.parseInt(c.readLine());
                repeat = false;
                if (number < min || number > max) {
                    System.out.println(errorMessageNonMinAndMax);
                    repeat = true;
                }
                
            } catch(NumberFormatException e) {
                System.out.println(errorMessageNonNumeric);
            }
        }

        return number;
    }
}