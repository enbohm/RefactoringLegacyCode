package se.enbohms.legacy.exception;

public class NastyDependencyExceptionDuringUnitTest extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NastyDependencyExceptionDuringUnitTest() {
		super();
	}

	public NastyDependencyExceptionDuringUnitTest(String message,
			Throwable cause) {
		super(message, cause);
	}

	public NastyDependencyExceptionDuringUnitTest(String message) {
		super(message);
	}

	public NastyDependencyExceptionDuringUnitTest(Throwable cause) {
		super(cause);
	}

}