package lab4;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PuttingIntoPractice{
    public static void main(String ...args){    
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
        
        
        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        List<Transaction> tr2011 = transactions.stream()
                                               .filter(transaction -> transaction.getYear() == 2011)
                                               .sorted(comparing(Transaction::getValue))
                                               .collect(toList());
        System.out.println(tr2011);
        
        // Query 2: What are all the unique cities where the traders work?
        List<String> cities = 
            transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .distinct()
                        .collect(toList());
        System.out.println(cities);

        // Query 3: Find all traders from Cambridge and sort them by name.
        
        List<Trader> traders = 
            transactions.stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(toList());
        System.out.println(traders);
        
        
        // Query 4: Return a string of all traders’ names sorted alphabetically.
        
        String traderStr = 
            transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(traderStr);
        
        // Query 5: Are there any trader based in Milan?
        
        boolean milanBased =
            transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader()
                                                            .getCity()
                                                            .equals("Milan")
                                 );
        System.out.println(milanBased);
        
        
        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        transactions.stream()
                    .map(Transaction::getTrader)
                    .filter(trader -> trader.getCity().equals("Milan"))
                    .forEach(trader -> trader.setCity("Cambridge"));
        System.out.println(transactions);
        
        
        // Query 7: What's the highest value in all the transactions?
        int highestValue = 
            transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(0, Integer::max);
        System.out.println(highestValue);
        
        //Query 8: Find the transaction with the smallest value.
        int lowestValue = transactions.stream()
        					.map(Transaction::getValue)
        					.reduce(Integer.MAX_VALUE,Integer::min);
        System.out.println(lowestValue);
        
        
        //Query 9 For each trader, return the number of lowercase letters in the name
       List<String> names =  transactions.stream()
        	.map(Transaction::getTrader)
        	.map(Trader::getName)
        	.distinct()
        	.map((name)-> 
        		name+" "+name.chars().filter((Character::isLowerCase)).count())
        	.collect(Collectors.toList());
       System.out.println(names);
       
       /*query10 Find the city String with the largest number of lower-case letters from all the cities
       in the transaction list
       */
        	
       Optional<Long> length = transactions.stream()
    		   							.map(Transaction::getTrader)
    		   							.map(Trader::getCity)
    		   							.distinct()
    		   							.map((String city)->city.chars().filter(Character::isLowerCase).count())
    		   							.reduce(Long::max);
       if(length.isPresent()) {
    	   System.out.println(length.get());
       }else {
    	   System.out.println("nothing");
       }
        
       
       /*
       Optional<String> cityString = transactions.stream()
    		   							.map(Transaction::getTrader)
    		   							.map(Trader::getCity)
    		   							.map(city -> city.chars().filter(Character::isLowerCase).count())
    		   							.
    		   							
			.map(Transaction::getTrader)
			.map(Trader::getCity)
			.distinct()
			.map((String city)->city.chars().filter(Character::isLowerCase).count())
			.reduce(Long::max);
			*/
       
    }
}