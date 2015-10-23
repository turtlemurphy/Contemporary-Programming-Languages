/* CallingMethodsInSameClass.java
 *
 * illustrates how to call static methods a class
 * from a method in the same class
 */

public class CallingMethodsInSameClass
{
	public static void main(String[] args) {
		printOne();
		printOne();
		printTwo();
	}

	public static void printOne() {
		System.out.println("Hello World");
	}

	public static void printTwo() {
		printOne();
		printOne();
	}
}


10 25 10 5 1 1 1 5 25 10 5 5 5 1 1 1 1 1 1 10 25 25 10 1 1 1 1 5 5 5 5 5 1 1 1 1 5 25 10 10 -1 
5 5 5 1 10 10 5 0 10 25 1 1 1 25 25 5 5 5 -1 
5 1 5 5 1 10 5 5 5 10 10 10 1 1 1 25 1 5 10 25

