package se.enbohms.legacy;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import se.enbohms.legacy.exception.UserNotLoggedInException;
import se.enbohms.legacy.tweet.Tweet;
import se.enbohms.legacy.tweet.TweetDao;
import se.enbohms.legacy.user.SessionService;
import se.enbohms.legacy.user.User;

public class TweetService_Original {

	public List<Tweet> getTweetsByUser(User user)
			throws UserNotLoggedInException {

		Logger.getLogger("default").fine("Entering getTweetsByUser");

		List<Tweet> tweetList = new ArrayList<Tweet>();
		User loggedUser = SessionService.getInstance().getLoggedUser();
		boolean isFriend = false;

		if (loggedUser != null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tweetList = TweetDao.findTweetsByUser(user);
			}
			return tweetList;

		} else {
			throw new UserNotLoggedInException();
		}
	}
}