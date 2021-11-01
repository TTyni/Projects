/**
 * Class Math contains basic math tools
 * 
 * This would be tho longer explanation if the class needed it
 * 
 *  @author Tommi Tyni
 */


package fi.tuni.tamk.tiko.tommityni.util;

public class Math {
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}