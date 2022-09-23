package game;

public class Debug {

	private static boolean isDebug = false;
	
	public Debug() {
		super();
	}
	
	public static void log(String info) {
		if (isDebug) System.err.print(info);
	}
	
	public static void logln(String info) {
		if (isDebug) System.err.println(info);
	}
	
	public static void open() {
		isDebug = true;
	}
	
	public static void close() {
		isDebug = false;
	}
}
