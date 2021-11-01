/**
 * Main class for lottoApp.
 * 
 * Program first asks "player" to input lottery numbers one at a time, then i generates a winning row and checks if the player has won.
 * If the player has not won, program generates a new winning row until the player gets all 7 numbers right.
 * After winning program checks how long it took to win the game. 
 * If over 120 years (1 year is 52 weeks/winning rows) the game tries again until the player wins under 120 years.
 * 
 * @author Tommi Tyni
 */

package fi.tuni.tamk.tiko.tommityni;
import fi.tuni.tamk.tiko.tommityni.util.Arrays;
import fi.tuni.tamk.tiko.tommityni.util.Math;
import fi.tuni.tamk.tiko.tommityni.util.MyConsole;

class lottoApp{

    
    public static void main(String [] args) {
        final int lottoRowLength = 7;
        int correctNumbers = 0;
        int bestSoFar = 0;
        int weeks = 0;
        int years = 150;
        int[] lottoRow = new int[lottoRowLength];
        int[] winningRow = new int[lottoRowLength];
        
        //Ask for the lotto row and check if the array generated is valid.
        for (int i = 0; i <= lottoRowLength - 1; i++){
            System.out.println("Please give a unique number between [1, 40]");
            lottoRow[i] = MyConsole.readInt(1,40, "Input is not a number", "Inputted Number not in range");
            
            boolean getNewNumber = Arrays.contains(lottoRow[i], lottoRow);

            while (!getNewNumber) {
                lottoRow[i] = MyConsole.readInt(1,40, "Input is not a number", "Inputted Number not in range");
                getNewNumber = Arrays.contains(lottoRow[i], lottoRow);
            }
            
        }

        //generate winning row 
        winningRow = calculateLotto();

        //loop to check if you've won and how long it took, repeats until under 120 years. 1 loop is 1 week.
        do{
            weeks = 0;
            while (correctNumbers < lottoRowLength){
                correctNumbers = Arrays.containsSameValues(lottoRow, winningRow);
                weeks++;
                if (correctNumbers == lottoRowLength) {
                    System.out.println("You got " + correctNumbers + " correct!");
                    System.out.println("Took only " + (weeks / 52) + " years!");
                } else {
                    if (correctNumbers > bestSoFar){
                        bestSoFar = correctNumbers;
                
                        System.out.println("You got " + correctNumbers + " correct!");
                        System.out.println("Took only " + (weeks / 52) + " years! ");
                    }

                    winningRow = calculateLotto();
                    
                }
                
            } 
            years = weeks / 52;

            if(years>=120){
                correctNumbers = 0;
                System.out.println("Winning took longer than a lifetime");
                winningRow = calculateLotto();
            }else if(years<120){
                System.out.println("You won with in a lifetime!");
            }
            
        } while(years>120);
    }


    private static int[] calculateLotto() {
        int lottoRowLength = 7;

        int[] calculatedLotto = new int[lottoRowLength];

        for (int i = 0; i <= lottoRowLength - 1; i++){
            calculatedLotto[i] = Math.getRandom(1, 40);
            
            boolean getNewNumber = Arrays.contains(calculatedLotto[i], calculatedLotto);

            while (!getNewNumber) {
                calculatedLotto[i] = Math.getRandom(1, 40);
                getNewNumber = Arrays.contains(calculatedLotto[i], calculatedLotto);
            }
        }
        return calculatedLotto;
    }




}