import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {

	int total = 0;

	public static void main(String args[]){
		new Dice();
	}


	Dice(){
		Scanner in = new Scanner(System.in);
		System.out.println("Skriven av Erik Häregård, Maj 8 2020");
		System.out.println("");
		Loop(in);
	}

	void Loop(Scanner in){
		System.out.println("Hur många Tärningar vill du slå?");

		String s = in.nextLine();
		int i = 0;
		try{
			//Converts the String 's' into an Integer 'i'.
			//If the user inputs something that cannot be converted to an Integer, an exception is called and restarts Loop.
			i = Integer.valueOf(s);
		}
		catch(Exception e){
			System.out.println("Skriv in ett tal mellan 1 och 4, försök igen.");
			Loop(in);
		}
		
		if(i<1 || i>4){
			//Checks if the Integer is within range.
			//If 'i' is out of range Loop restarts.
			System.out.println("Antalet tärningar måste vara mellan 1 och 4, försök igen.");
			Loop(in);
		}


		total = 0;
		Roll(i); //Roll function, throws as many dies as the input "i";

		System.out.println("Total summa: " + total);
		System.out.println("");

		System.out.println("Vill du spela igen?");
		System.out.println("(Skriv 'Ja' om du vill spela igen)");
		s = in.nextLine();

		if(s.equals("Ja")){
			System.out.println("");
			Loop(in);
		}
		//If 's' is not exactly "Ja", the program ends.
	}

	void Roll(int i){
		for(int j = 0; j < i; j++){
			int roll = ThreadLocalRandom.current().nextInt(1, 7); //Generates a random number 1 - 6.
			if(roll == 6){
				System.out.println("Sexa, två extra slag!");
				Roll(2);
				//If a 6 is rolled, recursively call Roll(2) to roll another 2 die.
			}
			else{
				total += roll;
				System.out.println("Du slog: " + roll + " Total: " + total);
				//If not a 6, add to total and print the Roll and Total sum thus far.
			}		
		}		
	}
}