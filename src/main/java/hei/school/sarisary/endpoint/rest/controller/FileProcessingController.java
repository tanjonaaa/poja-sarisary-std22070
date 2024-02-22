package hei.school.sarisary.endpoint.rest.controller;

import hei.school.sarisary.service.FileProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileProcessingController {

  private final FileProcessingService fileProcessingService;

  @Autowired
  public FileProcessingController(FileProcessingService fileProcessingService) {
    this.fileProcessingService = fileProcessingService;
  }

  @RequestMapping(
          path = "/black-and-white/{id}",
          method = RequestMethod.PUT,
          consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}
  )
  public ResponseEntity<String> putBlackAndWhite(
          @PathVariable String id,
          @RequestPart("file") MultipartFile file) throws IOException {
    this.fileProcessingService.process(id, file);
    return ResponseEntity.status(HttpStatus.OK).body("OK");
  }

  @GetMapping("/black-and-white/{id}")
  public ResponseEntity<String> getBlackAndWhite(@PathVariable String id) {
    return ResponseEntity.status(HttpStatus.OK).body("OK");
  }
}
