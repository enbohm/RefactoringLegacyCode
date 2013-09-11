package se.enbohms.legacy;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import se.enbohms.legacy.exception.UserNotLoggedInException;
import se.enbohms.legacy.tweet.Tweet;
import se.enbohms.legacy.user.User;

public class TweetServiceTest {

	private static final User GUEST = null;
	private static final User REGISTERD_USER = new User();
	private static final User JOHN_DOE = new User();
	private static final Tweet TWEET_1 = null;
	private static final Tweet TWEET_2 = null;
	private static final User NOT_USER_USER = null;
	private TweetService tweetService;

	@Before
	public void setUp() {
		ITweetDao fakeDao = new ITweetDao() {

			@Override
			public List<Tweet> findTweetsBy(User user) {
				return user.getTweets();
			}
		};

		tweetService = new TweetService(fakeDao);
	}

	@Test(expected = UserNotLoggedInException.class)
	public void should_throw_exception_when_user_is_no_logged_in()
			throws Exception {
		tweetService.getTweetsByUser(NOT_USER_USER, GUEST);
	}

	@Test
	public void should_return_no_tweets_when_uses_are_not_friends()
			throws Exception {
		// given
		User notFriend = new User();
		notFriend.addFriend(JOHN_DOE);

		// when
		List<Tweet> result = tweetService.getTweetsByUser(notFriend,
				REGISTERD_USER);

		// then
		assertThat(result).isEmpty();
	}

	@Test
	public void should_return_tweets_when_users_are_friends() throws Exception {
		// given
		User friend = new User();
		friend.addFriend(JOHN_DOE);
		friend.addFriend(REGISTERD_USER);
		friend.addTweet(TWEET_1);
		friend.addTweet(TWEET_2);

		// when
		List<Tweet> result = tweetService.getTweetsByUser(friend,
				REGISTERD_USER);

		// then
		assertThat(result).isNotEmpty();
		assertThat(result.size()).isEqualTo(2);
	}
}
