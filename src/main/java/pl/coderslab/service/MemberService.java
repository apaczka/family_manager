package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Family;
import pl.coderslab.model.FamilyMember;
import pl.coderslab.repository.MemberRepository;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    public List<FamilyMember> showAllMembers() {
        return memberRepository.findAll();
    }

    public FamilyMember findbyId(Long id) {
        return memberRepository.findOne(id);
    }

    public void saveMember(FamilyMember familyMember) {
        memberRepository.save(familyMember);
    }

    public List<FamilyMember> findAllFamilyMembers(Family family) {
        return memberRepository.findFamilyMemberByFamily(family);

    }

    public void removeMember(Long id) {
        memberRepository.delete(id);
    }
}


