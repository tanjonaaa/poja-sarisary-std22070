package hei.school.sarisary.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "file_processing")
public class FileProcessing {
  @Id private String id;

  @Column(name = "transformation_timestamp")
  private Timestamp transformationTimestamp;
}
