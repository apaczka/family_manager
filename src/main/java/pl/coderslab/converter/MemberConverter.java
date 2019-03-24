package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.FamilyMember;
import pl.coderslab.service.MemberService;

public class MemberConverter implements Converter<String, FamilyMember> {

    @Autowired
    private MemberService memberService;

    @Override
    public FamilyMember convert(String s) {
        return memberService.findbyId(Long.parseLong(s));
    }
}
