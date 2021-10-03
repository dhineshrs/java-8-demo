package defaultAndStaticSamples;

/* Java 8 interface static method demo*/
interface MyData {

	default void print(String str) {
		if (!isNull(str))
			System.out.println("MyData Print::" + str);
	}

	static boolean isNull(String str) {
		System.out.println("Interface Null Check");
		return str == null ? true : "".equals(str) ? true : false;
	}
}

public class MyDataImpl implements MyData {

	public static void main(String[] args) {
		MyDataImpl obj = new MyDataImpl();
		obj.print("");
		// obj.isNull("abj");

		/*
		 * Java interface static method is visible to interface methods only, if we
		 * remove the isNull() method from the MyDataImpl class, we wonâ€™t be able to
		 * use it for the MyDataImpl object. However like other static methods, we can
		 * use interface static methods using class name. For example, a valid statement
		 * will be:
		 */

		boolean result = MyData.isNull("abc");
		System.out.println("test interface static method :: " + result);
	}

	/*
	 * @Override boolean isNull(String str) { System.out.println("Impl Null Check");
	 * return str == null ? true : "".equals(str) ? true : false; }
	 */
}

/*
 * ## Important points about java interface static method ## 1. Java interface
 * static method is part of interface, we canâ€™t use it for implementation
 * class objects. 2. Java interface static methods are good for providing
 * utility methods, for example null check, collection sorting etc. 3. Java
 * interface static method helps us in providing security by not allowing
 * implementation classes to override them. 3. We canâ€™t define interface
 * static method for Object class methods, we will get compiler error as â€œThis
 * static method cannot hide the instance method from Objectâ€�. This is because
 * itâ€™s not allowed in java, since Object is the base class for all the
 * classes and we canâ€™t have one class level static method and another
 * instance method with same signature. 4. We can use java interface static
 * methods to remove utility classes such as Collections and move all of itâ€™s
 * static methods to the corresponding interface, that would be easy to find and
 * use.
 */
