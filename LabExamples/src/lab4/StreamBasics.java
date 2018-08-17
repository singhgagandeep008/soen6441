/**
 * 
 */
package lab4;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Amandeep Singh
 *
 */
public class StreamBasics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Dish> firstTwoMeatDishes = Dish.menu.stream().filter((Dish d)->!d.isVegetarian()).limit(2).collect(Collectors.toList());
		System.out.println(firstTwoMeatDishes);
		
		List<Dish> firstTwoVeganDishes = Dish.menu.stream().filter((Dish d)->d.isVegetarian()).limit(2).collect(Collectors.toList());
		System.out.println(firstTwoVeganDishes);
		
		List<Dish> secondThirdVeganDishes = Dish.menu.stream().filter((Dish d)->d.isVegetarian()).skip(1).limit(2).collect(Collectors.toList());
		System.out.println(secondThirdVeganDishes);
	}

}
