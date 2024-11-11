package raf.rs.SportsBooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import raf.rs.SportsBooking.model.Field;
import raf.rs.SportsBooking.repository.FieldRepo;

import java.util.List;
import java.util.Optional;

@Service
public class FieldService {

    @Autowired
    FieldRepo fieldRepo;

    public String createNewField(Field field) throws Exception {
        if(field.getType() != null && field.getMark() != null && field.getCapacity() != 0 &&
        field.getOutsideOrInside() != null) {
            if(field.getCapacity() < 10 || field.getCapacity() > 30) {
                throw new Exception("Field capacity must be between 10 and 30");
            }
            List<Field> fields = fieldRepo.findAll();
            for(Field field1 : fields){
                if(field.getMark().equals(field1.getMark()))
                    throw new Exception("A field with the mark u entered already exist!");
            }
                fieldRepo.save(field);
                return "Successfully created!";

        }else{
            throw new Exception("All fields must be covered!");
        }
    }
    public Field getFieldByMark(String mark) throws Exception{
        Optional<Field> optionalField = fieldRepo.findByMark(mark);
        if(optionalField.isPresent()) {
            Field field = optionalField.get();
            return field;
        }else {
            throw new Exception("Field with entered mark does not exist");
        }


    }

}
