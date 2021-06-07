package eus.cic.core.app.session;

public class SessionException extends Exception {


	private static final long serialVersionUID = 2154075027222119100L;
	
	public SessionException() {
		super("Invalid session..");
	}

	@Override
	public synchronized Throwable getCause() {
		return super.getCause();
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	@Override
	public void printStackTrace() {
		super.printStackTrace();
	}

}
