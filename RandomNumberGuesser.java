import java.util.Scanner;


public class RandomNumberGuesser {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Random Number Guesser. A number has been chosen between 0 and 100.");
		
		Scanner in = new Scanner (System.in);
		

		int nextGuess; //User's guess
		String answer = "yes";
		boolean inputVal = false;
		
		   do {
				//Calling RNG class to get new random number
				int secretNum=RNG.rand();
				RNG.resetCount();
				
				int lowGuess = 0;
				int highGuess = 100;
				
				//System.out.println("The secret number is: "+secretNum);
				
			   // loop until the user gets the number correct/plays again
				do {
					

					System.out.println("Enter your guess:");
					nextGuess = in.nextInt();
					
					//if the guess is not within the range of possible numbers
					if (nextGuess>highGuess||nextGuess<lowGuess)
						inputVal = RNG.inputValidation(nextGuess, lowGuess, highGuess);
					 
					//if guess is CORRECT
					else if (nextGuess==secretNum) {       
						System.out.println("You have guessed correctly! You used "+RNG.getCount()+" guesses.");
						}
					
					//if guess is HIGHER than the secret number
					else if (nextGuess > secretNum) {
						highGuess = nextGuess;
						System.out.println("Your guess is too high. You have had "+RNG.getCount()+" guesses so far.");
						System.out.println("Enter your next guess between "+lowGuess+" and "+highGuess);
					}
					
					//if guess is LOWER than the secret number
					else if (nextGuess < secretNum) {
						lowGuess = nextGuess;
						System.out.println("Your guess is too low.You have had "+RNG.getCount()+" guesses so far.");
						System.out.println("Enter your next guess between "+lowGuess+" and "+highGuess);
					}
					
				                
				}while (nextGuess!=secretNum);
				
				

				System.out.println("Would you like to play again?");
				answer = in.next();

				
		   } while(answer.equals("yes"));
		
		System.out.println("Thanks for playing!");
		System.out.println("Programmer: Marilyn Ortega");
	}
}
