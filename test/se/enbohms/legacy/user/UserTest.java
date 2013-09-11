package se.enbohms.legacy.user;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class UserTest {

	@Test
	public void should_inform_when_users_are_not_friends() throws Exception {
		// given
		User user = new User();
		User anotherUser = new User();

		// when
		boolean isFriends = user.isFriendsWith(anotherUser);

		// then
		assertThat(isFriends).isFalse();
	}

	@Test
	public void should_inform_when_users_are_friends() throws Exception {
		// given
		User user = new User();
		User anotherUser = new User();
		user.addFriend(anotherUser);

		// when
		boolean isFriends = user.isFriendsWith(anotherUser);

		// then
		assertThat(isFriends).isTrue();
	}
}
