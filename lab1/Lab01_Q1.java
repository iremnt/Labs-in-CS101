// Lab 01, Q1, Debugging programme, Gülser İrem AÇIKGÖZ, 13.02.2025 

public class Lab01_Q1
{
	public static void main(String[] args) 
	{
		System.out.println("Movie Stream Pirated Movies:"); //adding " to end
		System.out.println("Movie Stream offers 1323 movies for streaming"); //changing comment line to normal code and changing the order of first two

		int noOfPiratedMovies = 1323; // changing 1383 to 1323, changin varName # with no
		double moviePrice = 100.0;  //changing 10 with 100.0
		
		// calculate the revenue amassed
		double totalRevenueGained = noOfPiratedMovies * moviePrice;
		
		System.out.println("Movie Stream earns " + moviePrice + " TL per movie (total of " + totalRevenueGained + " TL)."); //adding + symbols
		
		double fine = 0.3; //changing , with .
		double penaltyPerMovie = 3000.0;
		
		// calculate his total debt and and fine
		double totaldebt = noOfPiratedMovies * penaltyPerMovie;
		double totalFine = totalRevenueGained * fine;
		
		System.out.println("Recently Movie Rights Protection Agency (MRPA) started to crackdown."); 
		System.out.println("MRPA sued them " + penaltyPerMovie + " for every movie they streamed and claimed " + fine * 100 + "% of their income.");
		System.out.println("Now they owe a total of " + totaldebt + " TLs and " + totalFine + " TL worth fine for their actions.");
		
		/* now calculate debt if they choose to repay with suspension*/
		int hoursOfPrisonTimePerMovie = 900;
		System.out.println("They can either choose to pay this or the company license will be suspended" + hoursOfPrisonTimePerMovie + " hours for every movie pirated.");
		
		int totalHours = hoursOfPrisonTimePerMovie * noOfPiratedMovies; //changing double with int
		
		// convert hours to year:day:hour format
		int hours = totalHours % 24;
		int days = totalHours / 24;
		int years = days / 365; //deleting .0
		days = days % 365;
		
		// Now print what is calculated and be done with this question
		System.out.println("Which is equal to " + years + " years " + days + " days and " + hours + " hours of prison time."); //correcting print statement
	}

}
