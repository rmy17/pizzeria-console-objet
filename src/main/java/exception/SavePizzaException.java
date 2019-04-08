package exception;

@SuppressWarnings("serial")
public class SavePizzaException extends StockageException {

	public static int u;

	public SavePizzaException(String msg) {
		super(msg);
	}

	public SavePizzaException() {
		super();
		// TODO Auto-generated constructor stub
	}
}
