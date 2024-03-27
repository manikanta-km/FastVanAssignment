package Carrier.Integration.Uber.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rideId;
    private String pickUpAddress;
    private String dropAddress;
    private RideType rideType;

    @ManyToOne
    @JoinColumn(name = "fk_owner_user_id")
    private User rider;
}
