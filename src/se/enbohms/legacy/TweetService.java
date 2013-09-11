package se.enbohms.legacy;

import java.util.Collections;
import java.util.List;

import se.enbohms.legacy.exception.UserNotLoggedInException;
import se.enbohms.legacy.tweet.Tweet;
import se.enbohms.legacy.user.User;

/**
 * The service after refactoring
 * 
 * @author Andreas Enbohm @enbohm
 * 
 */
public class TweetService {

	private ITweetDao dao;

	public TweetService(ITweetDao dao) {
		this.dao = dao;
	}

	@Logged
	public List<Tweet> getTweetsByUser(User user, User loggedInUser)
			throws UserNotLoggedInException {

		validate(loggedInUser);

		return user.isFriendsWith(loggedInUser) ? dao.findTweetsBy(user)
				: noTweets();
	}

	private List<Tweet> noTweets() {
		return Collections.emptyList();
	}

	private void validate(User user) throws UserNotLoggedInException {
		if (user == null) {
			throw new UserNotLoggedInException();
		}
	}
}