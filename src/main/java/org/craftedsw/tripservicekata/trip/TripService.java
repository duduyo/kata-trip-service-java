package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

import java.util.ArrayList;
import java.util.List;

public class TripService {

    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        return getTripsByUser(user, UserSession.getInstance().getLoggedUser());
    }

    public List<Trip> getTripsByUser(User user, User loggedUser) {
        assertRequesterUserIsLoggedIn(loggedUser);

        return user.isFriend(loggedUser) ?
                findTripsBy(user) :
                noTrips();
    }

    protected void assertRequesterUserIsLoggedIn(User loggedUser) {
        if (loggedUser == null) throw new UserNotLoggedInException();
    }

    protected List<Trip> findTripsBy(User user) {
        return TripDAO.findTripsByUser(user);
    }

    protected ArrayList<Trip> noTrips() {
        return new ArrayList<Trip>();
    }


}
