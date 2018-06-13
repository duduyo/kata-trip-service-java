package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class TripServiceTest {

    private static final User NOT_FRIEND_USER = new User();

    private static final User NOT_LOGGED_USER = null;
    private static final User LOGGED_USER = new User();

    private static final Trip TOULOUSE = new Trip();
    private static final Trip BORDEAUX = new Trip();

    private TripService tripService = new TripService();

    @Test
    public void should_throw_user_not_logged_in_exception() {
        assertThrows(UserNotLoggedInException.class, () -> tripService.getTripsByUser(NOT_FRIEND_USER, NOT_LOGGED_USER));
    }

    @Test
    public void should_return_empty_list_when_users_are_not_friends() {
        // when
        List<Trip> tripsByUser = tripService.getTripsByUser(NOT_FRIEND_USER, LOGGED_USER);
        // then
        assertIterableEquals(asList(), tripsByUser);
    }

    @Test
    void should_return_trips_when_users_are_friend() {
        // given
        User friendUser = new User();
        friendUser.addFriend(LOGGED_USER);
        friendUser.addTrip(TOULOUSE);
        friendUser.addTrip(BORDEAUX);

        TripService testableTripService = spy(this.tripService);
        doReturn(asList(TOULOUSE, BORDEAUX)).when(testableTripService).findTripsBy(friendUser);

        // when
        List<Trip> tripsByUser = testableTripService.getTripsByUser(friendUser, LOGGED_USER);

        // then
        assertIterableEquals(asList(TOULOUSE, BORDEAUX), tripsByUser);
    }

}