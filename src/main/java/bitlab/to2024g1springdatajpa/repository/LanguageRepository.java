package bitlab.to2024g1springdatajpa.repository;

import bitlab.to2024g1springdatajpa.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

}
