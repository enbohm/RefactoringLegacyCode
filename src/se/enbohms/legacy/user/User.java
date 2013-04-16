package se.enbohms.legacy.user;

import java.util.ArrayList;
import java.util.List;

import se.enbohms.legacy.tweet.Tweet;

public class User {

	private List<Tweet> tweets = new ArrayList<>();

	private List<User> friends = new ArrayList<User>();

	public List<User> getFriends() {
		return friends;
	}

	public void addFriend(User user) {
		friends.add(user);
	}

	public void addTweet(Tweet tweet) {
		tweets.add(tweet);
	}
}
