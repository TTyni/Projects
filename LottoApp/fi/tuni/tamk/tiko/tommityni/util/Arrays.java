/**
 * Array tools
 * 
 * 
 */


package fi.tuni.tamk.tiko.tommityni.util;

public class Arrays {

    /**
     * converts String[] array to int[]
     * 
     * @param array
     * @return returns string array converted to int.
     */
    public static int [] toIntArray(String [] array) {

        int[] intArray = new int[array.length];
        for (int i = 0; i <= array.length - 1; i++){
            intArray[i] = Integer.parseInt(array[i]);
        }
        return intArray;
    }


    /**
     * Searches for the given value in the array.
     * 
     * @param value
     * @param array
     * @return returns boolean value if array includes the chosen value.
     */
    public static boolean contains(int value, int [] array) {
        boolean contain = false;
        for (int i = 0; i <= array.length -1; i++) {
            if (array[i] == value) {
                contain = true;
                i = i + array.length;
            }
        }
        return contain;
    }

    /**
     * Checks how many identical values the arrays have in common, assumes unique values.
     * 
     * @param array1
     * @param array2
     * @return returns int value of how many same values the arrays have
     */
    public static int containsSameValues(int [] array1, int [] array2) { 
        int sameValues = 0;

 
        for (int i = 0; i <= array1.length - 1; i++){
            for (int y = 0; y <= array2.length - 1; y++){
                if (array1[i] == array2[y]){
                   sameValues++;
                }
            }
        }
        return sameValues;
    } 

        
}

