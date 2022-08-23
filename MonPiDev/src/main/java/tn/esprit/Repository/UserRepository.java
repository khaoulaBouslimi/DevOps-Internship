package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
