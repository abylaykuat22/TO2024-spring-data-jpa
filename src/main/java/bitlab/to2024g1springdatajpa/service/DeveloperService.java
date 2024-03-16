package bitlab.to2024g1springdatajpa.service;

import bitlab.to2024g1springdatajpa.model.Developer;
import bitlab.to2024g1springdatajpa.repository.DeveloperRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperService {
  @Autowired
  private DeveloperRepository developerRepository;

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

  public Developer editDeveloper(Developer developer) {
    return developerRepository.save(developer);
  }

  public List<Developer> search(String search) {
    return developerRepository.search(search);
  }
}
