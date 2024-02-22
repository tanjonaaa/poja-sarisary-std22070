package hei.school.sarisary.service;

import hei.school.sarisary.file.BucketComponent;
import hei.school.sarisary.repository.FileProcessingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileProcessingService {
  private final BucketComponent bucketComponent;
  private final FileProcessingRepository fileProcessingRepository;

  @Autowired
  public FileProcessingService(
      BucketComponent bucketComponent, FileProcessingRepository fileProcessingRepository) {
    this.bucketComponent = bucketComponent;
    this.fileProcessingRepository = fileProcessingRepository;
  }
}
