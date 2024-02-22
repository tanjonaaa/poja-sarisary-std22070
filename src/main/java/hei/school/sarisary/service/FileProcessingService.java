package hei.school.sarisary.service;

import hei.school.sarisary.file.BucketComponent;
import hei.school.sarisary.repository.FileProcessingRepository;
import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageConverter;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

@Service
public class FileProcessingService {
  private final BucketComponent bucketComponent;
  private final FileProcessingRepository fileProcessingRepository;
  private final String DIRECTORY = "sary/";

  @Autowired
  public FileProcessingService(
      BucketComponent bucketComponent, FileProcessingRepository fileProcessingRepository) {
    this.bucketComponent = bucketComponent;
    this.fileProcessingRepository = fileProcessingRepository;
  }

  private String getExtension(String filename){
    return FilenameUtils.getExtension(filename);
  }

  public void process(String id, MultipartFile file) throws IOException {
    String extension = this.getExtension(file.getName());
    File initial = File.createTempFile(
            id + "initial",
            "." + extension
    );
    file.transferTo(initial);
    File transformed = this.toBlackAndWhite(initial);

    this.uploadToS3(id + "-initial", initial);
    this.uploadToS3(id + "-black-and-white", transformed);
  }

  private File toBlackAndWhite(File file) throws IOException {
    String extension = this.getExtension(file.getName());
    ImagePlus originalImage = IJ.openImage(file.getAbsolutePath());
    new ImageConverter(originalImage).convertToGray32();
    File transformed = File.createTempFile("transformed", "." + extension);
    ImageIO.write(originalImage.getBufferedImage(), extension, transformed);
    return transformed;
  }

  private void uploadToS3(String prefix, File toUpload) throws IOException {
    String suffix = "." + FilenameUtils.getExtension(toUpload.getName());
    String bucketKey = DIRECTORY + prefix + suffix;

    bucketComponent.upload(toUpload, bucketKey);
  }
}
