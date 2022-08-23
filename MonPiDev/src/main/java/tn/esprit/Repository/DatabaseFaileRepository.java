package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entity.DataBaseFile;

@Repository
public interface DatabaseFaileRepository extends JpaRepository<DataBaseFile, String> {

}
