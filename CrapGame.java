import java.util.Scanner;
import java.util.Random;

public class CrapGame {
	public static final int PLAYS = 10000;
	public static Random rand = new Random();
	public static Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) {
		description();
		play();
	}
	public static void play() {
      //reset these variables beacuse each game has to start of fresh: teacher said too
		int numOfWins = 0;
		int numOfLoss = 0;
		for(int i = 1; i <= PLAYS; i++) {
//          System.out.println(i);
			int comeOutRoll = rollDice() ;//+ rollDice();
			int thePoint;
			String gameResult = winOrLose(comeOutRoll);
			if(gameResult.equals("win"))
				numOfWins++;
			else if(gameResult.equals("loss"))
				numOfLoss++;
			else 
			{
			//boolean gResultEqualsWin = gameResult.equals("win");
			//if(gResultEqualsWin || gameResult.equals("The Point")) {
				//if(!gResultEqualsWin) {					
					//numOfWins++;
				//} else {
					thePoint = comeOutRoll;
					String roll = keepRolling(thePoint);
					if(roll.equals("seven"))
						numOfLoss++;
					else
						numOfWins++;
					//numOfWins += comeOutRoll;
			}
			//} else {
			//	numOfLoss++;
			//}
		}

		System.out.println("In the simulation we :");;
		System.out.printf("\twon %d times\n", numOfWins);
		System.out.printf("\tlost %d times,\n", numOfLoss);
		System.out.printf("\tfor a probability of %.4f\n", winProbability(numOfWins, numOfLoss));
		
		System.out.println("Hit enter key to continue");
		kb.nextLine();
		
		System.out.println("");
		System.out.println("");
		
		String anotherGame = promptInput("Would you like to play another game yes/no? ");
		while(!anotherGame.equals("yes") && !anotherGame.equals("no")) {
			anotherGame = promptInput("Would you like to play another game yes/no? ");
		}
		if(anotherGame.equals("yes")) {
			numOfWins = 0;
			numOfLoss = 0;
			play();
		} else {			
			System.out.println("Have a nice day. GoodBye");
			return;
		}
		kb.close();
	}
	public static int rollDice() {
		return rand.nextInt(6) + 1 + rand.nextInt(6) + 1;
	}
	public static String winOrLose(int comeOutRoll) {
      String result = "";
		if(isWin(comeOutRoll)) {
			result = "win";
		} else
		if (isLoss(comeOutRoll)) {
			result = "loss";
		} else
		if (isPoint(comeOutRoll)){
			result = "The Point";
		}
		return result;
	}
	public static boolean isWin(int num) {
		return num == 7 || num == 11;
	}
	public static boolean isLoss(int num) {
		return num == 2 || num == 3 || num == 12;
	}
	public static boolean isPoint(int num) {
		return num == 4 || num == 5 || num == 6 || num == 8 || num ==  9 || num ==  10;
	}
	public static String keepRolling(int thePoint) {
		String rWinOrLose = "";//Prime pump because while evaluations on the first iteration unlike do while
		int sum = rollDice();
		//while (thePoint != 7 && !rWinOrLose.equals("The Point")) {
		  while(sum != 7 && sum != thePoint) {   
			sum = rollDice();
//          System.out.println(thePoint);
			//rWinOrLose = winOrLose(thePoint);
//          //System.out.print("  " + rWinOrLose + "\n");
		}
		return sum == 7 ? "seven" : "The Point";
	}
	public static void description() {
		System.out.println("Computer will play a crap game for you. Here are the rules of the game:");
		System.out.println(" Two six sided dice is rolled");
		System.out.println(" Come out roll: The first roll of the dice in a craps round");
		System.out.println("A come out roll of 7 or 11 automatically wins");
		System.out.println("A come out roll of 2, 3, or 12 automatically losses");
		System.out.println("A come out roll of 4, 5, 6, 8, 9, or 10 becomes The Point");
		System.out.println("If the player gets the point he/she will keep playing by rolling the dice until he/she gets a 7 or the point.");
		System.out.println("If the point is rolled first, then the player wins the bet.");
		System.out.println("If a 7 is rolled first, then the player loses.");
		System.out.print("\n\n\n\n");
		System.out.println("Let's start playing");
	}
	public static double winProbability(int wins, int losses) {
		return wins / (double) (losses+wins);
	}
	public static String promptInput(String question) {
		System.out.print(question);
		//use next() and then nextLine to buffer flush, otherwise use nextLine to get a string of text
		return kb.nextLine();
	}
}
