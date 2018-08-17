/**
 * 
 */
package lab3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author Amandeep Singh
 *
 */
public class PrettyPrintApple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
		System.out.println("PRINTING WEIGHTS");
		prettyPrintApple(inventory,(Apple a)->String.valueOf(a.getWeight()));
		System.out.println("PRINTING APPLE & HEAVY|LIGHT");
		prettyPrintApple(inventory,(Apple a)->a+" : "+(a.getWeight()>150?"Heavy":"Light"));
	}

	public static void prettyPrintApple(List<Apple> inventory,Function<Apple, String> function) {
		for(Apple apple : inventory) {
			System.out.println(function.apply(apple));
		}
	}
	
}
