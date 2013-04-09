package se.enbohms.legacy.user;

import se.enbohms.legacy.exception.NastyDependencyExceptionDuringUnitTest;

public class SessionService {
	private static final SessionService sessionService = new SessionService();

	private SessionService() {
	}

	public static SessionService getInstance() {
		return sessionService;
	}

	public boolean isUserLoggedIn(User user) {
		throw new NastyDependencyExceptionDuringUnitTest(
				"SessionService.isUserLoggedIn() should not be called in an unit test");
	}

	public User getLoggedUser() {
		throw new NastyDependencyExceptionDuringUnitTest(
				"SessionService.getLoggedUser() should not be called in an unit test");
	}
}