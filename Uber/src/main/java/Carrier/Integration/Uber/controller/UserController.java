package Carrier.Integration.Uber.controller;

import Carrier.Integration.Uber.model.Ride;
import Carrier.Integration.Uber.model.User;
import Carrier.Integration.Uber.service.RideService;
import Carrier.Integration.Uber.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    RideService rideService;

    @Autowired
    UserService userService;

    @PostMapping("User/Signup")
    public String userSignUp(@Valid @RequestBody User newUser)
    {
        return userService.userSignUp(newUser);
    }


    @PostMapping("Ride")
    public String bookARide(@RequestParam String email, @RequestParam String password, @RequestBody Ride ride)
    {
        return rideService.BookARide(email, password, ride);
    }

    @PutMapping("Ride/PickUpAddress")
    public String updatePickUp(@RequestParam Integer rideId, @RequestParam String newPickUpAddress)
    {
        return rideService.updatePickUp(rideId, newPickUpAddress);
    }

    @PutMapping("Ride/DropAddress")
    public String updateDrop(@RequestParam Integer rideId, @RequestParam String newDropAddress)
    {
        return rideService.updateDrop(rideId, newDropAddress);
    }

    @GetMapping("Fair")
    public String getFair(@RequestParam Integer rideId)
    {
        return rideService.GetFare(rideId);
    }

    @GetMapping("Track")
    public String track(@RequestParam Integer rideId)
    {
        return rideService.trackService(rideId);
    }



}
