package lab11;

import static java.util.stream.Collectors.*;

import lab4.Dish;

public class Question1 {

	public static void main(String[] args) {
		String shortMenu = Dish.menu.stream().map(Dish::getName).collect(joining());
		
		System.out.println(shortMenu);
		
		//a
		String shortMenu_A = Dish.menu.stream().map(Dish::getName).collect(reducing((s1,s2)->s1+s2)).get();
		System.out.println(shortMenu_A);
		
		//b
		String shortMenu_B = Dish.menu.stream()
                .collect( reducing( (d1, d2) -> d1.getName() + d2.getName() ) ).get();
		System.out.println(shortMenu_B);
		//c
		String shortMenu_C = Dish.menu.stream()
                .collect( reducing( "", Dish::getName, (s1, s2) -> s1 + s2 ) );
		System.out.println(shortMenu_C);
	}

}
