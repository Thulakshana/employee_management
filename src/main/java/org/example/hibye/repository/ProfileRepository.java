package org.example.hibye.repository;
import org.example.hibye.entity.Profile;
import org.example.hibye.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface ProfileRepository extends JpaRepository<Profile,Long> {
Optional<Profile>findByUsers(User user);
}
