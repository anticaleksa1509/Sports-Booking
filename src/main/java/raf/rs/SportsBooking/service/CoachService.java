package raf.rs.SportsBooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raf.rs.SportsBooking.model.Coach;
import raf.rs.SportsBooking.repository.CoachRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CoachService {

    @Autowired
    CoachRepo coachRepo;

    public String createCoach(Coach coach) throws Exception{
        if(coach.getName() != null && coach.getLastName() != null && coach.getCoachingTitle() != null
        && coach.getAreaOfExpertise() != null){
            coachRepo.save(coach);
            return "Successfully created!";
        }
        throw new Exception("All fields must be covered");
    }

    public List<Coach> getByNameAndLastName(String name, String lastName) throws Exception{

        Optional<List<Coach>> coaches = coachRepo.findCoachByNameAndLastName(name,lastName);
        if(coaches.isPresent() && !coaches.get().isEmpty())
            return coaches.get();
        throw new Exception("Coach with the name and last name you entered does not exist");
    }
}
