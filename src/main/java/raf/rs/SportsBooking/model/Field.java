package raf.rs.SportsBooking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long field_id;

    private String type;
    private String mark;
    private int capacity;
    private String outsideOrInside;

    @JsonIgnore
    @OneToMany(mappedBy = "field")
    private List<Session> sessions;

}
