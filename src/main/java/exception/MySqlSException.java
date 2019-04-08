package exception;

public class MySqlSException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MySqlSException(String msg) {
		super(msg);
	}

	public MySqlSException(Exception e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	public MySqlSException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MySqlSException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MySqlSException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
