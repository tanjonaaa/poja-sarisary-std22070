package hei.school.sarisary.repository;

import hei.school.sarisary.repository.model.FileProcessing;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileProcessingRepository extends CrudRepository<FileProcessing, String> {
  @Override
  Optional<FileProcessing> findById(String id);
}
