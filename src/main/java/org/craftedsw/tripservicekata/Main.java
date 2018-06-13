package org.craftedsw.tripservicekata;

import org.craftedsw.tripservicekata.trip.Trip;
import org.craftedsw.tripservicekata.trip.TripDAO;
import org.craftedsw.tripservicekata.trip.TripService;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TripService tripService = new TripService(new TripDAO());
        User aUser = new User();
        List<Trip> tripsByUser = tripService.getTripsByUser(aUser, UserSession.getInstance().getLoggedUser());

        System.out.println("Found trips for user : " + tripsByUser.toString());
    }
}
