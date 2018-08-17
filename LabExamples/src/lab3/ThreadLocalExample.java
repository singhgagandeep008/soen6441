/**
 * 
 */
package lab3;

/**
 * @author Amandeep Singh
 *
 */
public class ThreadLocalExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadLocal<Integer> tl = new ThreadLocal<>().withInitial(()->1);
	}

}
