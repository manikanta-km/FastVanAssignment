package Carrier.Integration.Uber.repository;

import Carrier.Integration.Uber.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRideRepo extends JpaRepository<Ride,Integer> {

}
