package se.enbohms.legacy;

import java.util.List;

import se.enbohms.legacy.tweet.Tweet;
import se.enbohms.legacy.user.User;

public interface ITweetDao {

	List<Tweet> findTweetsBy(User user);

}
