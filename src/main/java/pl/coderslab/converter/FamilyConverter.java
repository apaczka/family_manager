package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Family;
import pl.coderslab.model.FamilyMember;
import pl.coderslab.service.FamilyService;
import pl.coderslab.service.MemberService;

public class FamilyConverter implements Converter<String, Family> {


    @Autowired
    private FamilyService familyService;

    @Override
    public Family convert(String s) {
        return familyService.findById(Long.parseLong(s));

    }
}
