package exception;

@SuppressWarnings("serial")
public class SavePizzaException extends RuntimeException {

	public static int u;

	public SavePizzaException(String msg) {
		super(msg);
	}

	public SavePizzaException() {
		super();
		// TODO Auto-generated constructor stub
	}
}
