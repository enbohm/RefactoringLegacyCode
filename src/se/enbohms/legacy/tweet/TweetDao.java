package se.enbohms.legacy.tweet;

import java.util.List;

import se.enbohms.legacy.exception.NastyDependencyExceptionDuringUnitTest;
import se.enbohms.legacy.user.User;

public class TweetDao {

	public static List<Tweet> findTweetsByUser(User user) {
		throw new NastyDependencyExceptionDuringUnitTest(
				"TweetDao couldn't be invoked by the unit test.");
	}
}