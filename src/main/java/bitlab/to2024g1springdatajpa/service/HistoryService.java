package bitlab.to2024g1springdatajpa.service;


import bitlab.to2024g1springdatajpa.model.Developer;
import bitlab.to2024g1springdatajpa.model.History;
import bitlab.to2024g1springdatajpa.repository.HistoryRepository;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HistoryService {
  @Autowired
  private HistoryRepository historyRepository;

  /**
   * Сохранить историю о языках программирования разработчика.
   *
   * @param current - данные из базы.
   * @param updated - данные из формы.
   * @return
   */
  public History addHistory(Developer current, Developer updated) {
    History history = History.builder()
        .oldValue(String.valueOf(current.getLanguage().getId()))
        .newValue(String.valueOf(updated.getLanguage().getId()))
        .createdAt(LocalDateTime.now())
        .build();
    History saved = historyRepository.save(history);
    log.info("CREATED history ID:{}", saved.getId());
    return saved;
  }
}