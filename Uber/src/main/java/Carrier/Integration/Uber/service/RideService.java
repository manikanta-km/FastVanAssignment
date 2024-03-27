package Carrier.Integration.Uber.service;

import Carrier.Integration.Uber.model.Ride;
import Carrier.Integration.Uber.model.User;
import Carrier.Integration.Uber.repository.IRideRepo;
import Carrier.Integration.Uber.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RideService {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    IRideRepo rideRepo;


    public String  BookARide(String email, String password, Ride ride) {
            User existingUser = userRepo.findFirstByUserEmail(email);
            ride.setRider(existingUser);
            rideRepo.save(ride);
            return "Ride is Booked";
    }

    public String GetFare(Integer rideId){
        Ride ride = rideRepo.findById(rideId).orElseThrow();
        String pickup = ride.getPickUpAddress();
        String drop = ride.getDropAddress();
        Integer n1 = pickup.length();
        Integer n2 =  drop.length();
        Integer fair = n1 * n2;
        return  "Your Fair For The Ride Is : " + fair;
    }

    public String updatePickUp(Integer rideId, String newPickUp){
        Ride ride = rideRepo.findById(rideId).orElseThrow();
        ride.setPickUpAddress(newPickUp);
        rideRepo.save(ride);
        return "PickUp Address Has Been Updated";
    }

    public String updateDrop(Integer rideId, String newDrop){
        Ride ride = rideRepo.findById(rideId).orElseThrow();
        ride.setDropAddress(newDrop);
        rideRepo.save(ride);
        return "Destination Address Has Been Updated";
    }

    public String trackService(Integer rideId){
        return "Captain is on thw way";
    }


}
