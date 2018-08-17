/**
 * 
 */
package lab11;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lab4.Dish;

/**
 * @author Amandeep Singh
 *
 */
public class Question3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Optional<String> maxName = Dish.menu.stream().map(Dish::getName).collect(Collectors.maxBy(Comparator.naturalOrder()));
		System.out.println(maxName.get());
		
		
		Optional<String> s = Dish.menu.stream().map(d->d.getName()).reduce((a,b)->a.length()>b.length()?a:b);
		System.out.println(s.get());
		
		Stream<String> names = Stream.of("Pasta", "Fish", "Pasta", "Meat", "Pasta", "Meat");
		Map<String,Long> m = names.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(m);
		
	}

}
