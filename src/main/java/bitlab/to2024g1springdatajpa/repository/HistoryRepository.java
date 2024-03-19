package bitlab.to2024g1springdatajpa.repository;

import bitlab.to2024g1springdatajpa.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

}
