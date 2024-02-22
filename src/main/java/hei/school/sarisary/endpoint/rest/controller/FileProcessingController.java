package hei.school.sarisary.endpoint.rest.controller;

import hei.school.sarisary.service.FileProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileProcessingController {

  private final FileProcessingService fileProcessingService;

  @Autowired
  public FileProcessingController(FileProcessingService fileProcessingService) {
    this.fileProcessingService = fileProcessingService;
  }

  @PutMapping("/black-and-white/{id}")
  public ResponseEntity<String> putBlackAndWhite(@PathVariable String id) {
    return ResponseEntity.status(HttpStatus.OK).body("OK");
  }

  @GetMapping("/black-and-white/{id}")
  public ResponseEntity<String> getBlackAndWhite(@PathVariable String id) {
    return ResponseEntity.status(HttpStatus.OK).body("OK");
  }
}
