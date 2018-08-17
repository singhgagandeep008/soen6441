/**
 * 
 */
package lab4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Amandeep Singh
 *
 */
public class Task2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//#1
		System.out.println("#1");
		List<Integer> numbers = Arrays.asList(1,2,3);
		List<Integer> squares = numbers.stream().map((Integer i) -> i*i).collect(Collectors.toList());
		System.out.println(squares);
		
		//#2
		System.out.println("#2");
		List<Integer> number2 = Arrays.asList(6,7);
		List<int[]> pairs = numbers.stream().flatMap(i -> number2.stream().map(j->new int[] {i,j})).collect(Collectors.toList());
		pairs.stream().forEach((int[] a)->System.out.println(a[0]+" "+a[1]));
		
		
		//#3
		System.out.println("#3");
		pairs = numbers.stream().flatMap(i -> number2.stream().filter(j -> ((i+j)%3==0)).map(j->new int[] {i,j})).collect(Collectors.toList());
		pairs.stream().forEach((int[] a)->System.out.println(a[0]+" "+a[1]));
		
	}

}
