package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TripServiceTest {

    private static final User USER = new User();
    private static final User NOT_LOGGED_USER = null;
    private static final User LOGGED_USER = new User();

    private TripService tripService = new TripService();

    @Test
    public void should_throw_user_not_logged_in_exception() {
        assertThrows(UserNotLoggedInException.class, () -> tripService.getTripsByUser(USER, NOT_LOGGED_USER));
    }

    @Test
    public void should_return_empty_list_when_users_are_not_friends() {
        // when
        List<Trip> tripsByUser = tripService.getTripsByUser(USER, LOGGED_USER);
        // then
        assertIterableEquals(asList(), tripsByUser);
    }

}