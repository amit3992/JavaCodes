package game.numberguess;
import java.math.*;
import java.util.*;
import java.io.*;

public class NumberGame {
	
	Player p;
	
	void setPlayerInformation(Scanner sc) {
		
		System.out.println("Hi! What is your name? ");
		String name = sc.next();
		p = new Player(name);
		
		sc.close();
	
	}
	
	void start() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		do {
			setPlayerInformation(sc);
			playGame(p);
		} while(wantToPlayAgain());
		
	}

	private boolean wantToPlayAgain() {
		
		String input;
		boolean fail;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			fail = false;
			System.out.println("Do you want to play again? yes/no");
			input = sc.next();
			
			if(!input.equalsIgnoreCase("yes") || !input.equalsIgnoreCase("no")) {
				System.out.println("ERROR! Invalid input. Try again.");
				fail = true;
			}
			
			sc.close();
			
		} while(fail);
		
		return input.equalsIgnoreCase("yes");
	}

	private void playGame(Player p) throws IOException {
		
		int games = p.getGames();
		games++;
		p.setGames(games);
		
		int secretNumber = 65; // TODO: Implement randomNumberGenerator
		final int UPPER_BOUND = 100;
		int numberOfTries = (int) Math.ceil(Math.log(UPPER_BOUND));
		int guess = 0; 
		
		System.out.println("Hello, " + p.getName() + ". Let's begin. ");
		System.out.println("\nSecret number is in the range: 0 - 100");
		
		do {
			
			guess = getGuess(numberOfTries);
			int d = guess - secretNumber;
			
			if(guess != secretNumber) {
				if(d > 0) {
					System.out.println("Oh no! You guessed too high!");
					checkTemp(d);
				} else {
					System.out.println("Oh shoot! You guessed too low. ");
					checkTemp(d);
				}
			}
			
		} while(isGameOver(secretNumber, guess, numberOfTries));
		
		displayResult(secretNumber, numberOfTries, p);
		
	}

	private void checkTemp(int d) {
		d = Math.abs(d);
		if(d <= 5) {
			System.out.println("BUT...SO COLD! SO COLD!");
			return;
		} else if(d > 5 && d <= 10) {
			System.out.println("BUT..COLD!");
			return;
		} else if(d > 10 && d <= 15) {
			System.out.println("BUT...You're warm!");
			return;
		} else if(d > 20) {
			System.out.println("BUT...You're not close. Hot!");
			return;
		}
		
	}

	private int getGuess(int numberOfTries) throws IOException {
		
		int guess;
		boolean fail;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		do {
			fail = false;
			System.out.println("Enter your guess (Number of tries: " + numberOfTries + " ): ");
			line = br.readLine();
			guess = Integer.parseInt(line);
			
			if(guess < 0 || guess > 100) {
				System.out.println("ERROR! Invalid Input. Try again!");
				fail = true;
			}
			
		} while(fail);
		
		return guess;
		
	}

	private void displayResult(int secretNumber, int numberOfTries, Player p) {
		
		if(numberOfTries > 0) {
			System.out.println("Woo-hoo! You got it! It was: " + secretNumber);
		} else {
			System.out.println("Womp womp. You lost. It was: " + secretNumber);
		}
		
		p.getStats();
		
	}

	private boolean isGameOver(int secretNumber, int guess, int numberOfTries) {
		
		return !(secretNumber == guess || numberOfTries <= 0);
	}

}
