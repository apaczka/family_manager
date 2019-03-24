package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Family;
import pl.coderslab.model.FamilyMember;
import pl.coderslab.model.User;

import java.util.List;

public interface MemberRepository extends JpaRepository<FamilyMember, Long> {

    List<FamilyMember> findFamilyMemberByFamily(Family family);
}
