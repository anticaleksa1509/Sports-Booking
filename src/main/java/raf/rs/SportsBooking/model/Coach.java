package raf.rs.SportsBooking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coach_id;
    private String name;
    private String lastName;
    private String areaOfExpertise;
    private String coachingTitle;

    @JsonIgnore
    @OneToMany(mappedBy = "coach")
    private List<Session> sessions;


}
