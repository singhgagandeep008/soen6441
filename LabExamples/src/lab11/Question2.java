/**
 * 
 */
package lab11;


import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

import lab4.Dish;

/**
 * @author Amandeep Singh
 *
 */
public class Question2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Boolean,List<Dish>> m = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian));
		System.out.println(m);

		//a
		Map<Boolean,Map<Boolean,List<Dish>>> m1 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian,partitioningBy(d->d.getCalories()>500)));
		System.out.println(m1);
		//b
		/*Map<Boolean,Map<Boolean,List<Dish>>> m2 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian,
                    partitioningBy(Dish::getType)));
		System.out.println(m2);*/
		
		//c
		Map<Boolean,Long> m3 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian,
                counting()));
		System.out.println(m3);
	}

}
