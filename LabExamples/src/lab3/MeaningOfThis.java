/**
 * 
 */
package lab3;

/**
 * @author Amandeep Singh
 *
 */
public class MeaningOfThis {
	
	
	public final int value = 4;
	public void doit() {
		int value = 6;
		Runnable r = new Runnable() {
			public final int value=5;
			@Override
			public void run() {
				int value = 10;
				System.out.println(this.value);
			}
		}; 
		r.run();
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MeaningOfThis m = new MeaningOfThis();
		m.doit();
	}

}
