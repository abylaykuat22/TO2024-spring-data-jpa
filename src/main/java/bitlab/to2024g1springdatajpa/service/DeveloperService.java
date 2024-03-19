package bitlab.to2024g1springdatajpa.service;

import bitlab.to2024g1springdatajpa.model.Developer;
import bitlab.to2024g1springdatajpa.repository.DeveloperRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class DeveloperService {
  @Autowired
  private DeveloperRepository developerRepository;
  @Autowired
  private HistoryService historyService;

  public List<Developer> getSortedDevelopers() {
    List<Developer> developers = developerRepository.findAll();
    return developers;
  }

  public Developer addDeveloper(Developer developer) {
    return developerRepository.save(developer);
  }

  public Developer getDeveloperById(Long id) {
    return developerRepository.findById(id).orElse(null);
  }

  @Transactional
  public Developer editDeveloper(Developer updatedDeveloper) {
    // Разработчик из БД.
    Developer currentDeveloper = getDeveloperById(updatedDeveloper.getId());

    historyService.addHistory(currentDeveloper, updatedDeveloper);

    updatedDeveloper.setName(null);
    Developer saved = developerRepository.save(updatedDeveloper);
    log.info("UPDATED developer ID:{}", saved.getId());
    return saved;
  }

  public List<Developer> search(String search) {
    return developerRepository.search(search);
  }
}
