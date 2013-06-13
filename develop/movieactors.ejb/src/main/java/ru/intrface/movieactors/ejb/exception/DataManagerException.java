package ru.intrface.movieactors.ejb.exception;

public class DataManagerException extends Exception {

	public DataManagerException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1917172819567328771L;

	public DataManagerException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataManagerException(Throwable cause) {
		super(cause);
	}

}
