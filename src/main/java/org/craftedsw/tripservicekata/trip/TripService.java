package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;

import java.util.ArrayList;
import java.util.List;

public class TripService {

    final TripDAO tripDAO;

    public TripService(TripDAO tripDAO) {
        this.tripDAO = tripDAO;
    }

    public List<Trip> getTripsByUser(User user, User loggedUser) {
        assertRequesterUserIsLoggedIn(loggedUser);

        return user.isFriend(loggedUser) ?
                tripDAO.findTripsBy(user) :
                noTrips();
    }

    protected void assertRequesterUserIsLoggedIn(User loggedUser) {
        if (loggedUser == null) throw new UserNotLoggedInException();
    }

    protected ArrayList<Trip> noTrips() {
        return new ArrayList<Trip>();
    }


}
