package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Family;
import pl.coderslab.repository.FamilyRepository;

import javax.transaction.Transactional;

@Component
@Transactional
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    public Family findById(Long id) {
        return familyRepository.findOne(id);
    }

    public void saveFamily(Family family) {
        familyRepository.save(family);
    }


}
