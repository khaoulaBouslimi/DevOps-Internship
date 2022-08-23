package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entity.TrainingSession;

@Repository
public interface TsRepository extends JpaRepository<TrainingSession, Integer> {

}
