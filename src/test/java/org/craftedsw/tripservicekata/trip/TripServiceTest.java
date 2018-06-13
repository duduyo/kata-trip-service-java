package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TripServiceTest {


    private static final User USER = null;
    private static final User NOT_LOGGED_USER = null;

    @Test
    public void should_throw_user_not_logged_in_exception() {
        TripService tripService = new TripService();
        Assertions.assertThrows(UserNotLoggedInException.class, () -> tripService.getTripsByUser(USER, NOT_LOGGED_USER));
    }

}