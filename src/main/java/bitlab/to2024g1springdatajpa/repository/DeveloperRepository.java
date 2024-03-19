package bitlab.to2024g1springdatajpa.repository;

import bitlab.to2024g1springdatajpa.model.Developer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

  List<Developer> findAllByNameIgnoreCaseOrAge(String name, String age);

  @Query("SELECT d FROM Developer d "
      + "WHERE d.name ilike concat('%', :search, '%') "
      + "OR d.age = :search "
      + "OR d.birthPlace ilike concat('%', :search, '%') ")
  List<Developer> search(String search);
}
