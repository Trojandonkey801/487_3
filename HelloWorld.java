public class HelloWorld{
	public native void displayHelloWord();
	static{
			System.loadLibrary("hello");
	}
	public static void main(String[] args) {
		new HelloWorld().displayHelloWord();
	}
}
