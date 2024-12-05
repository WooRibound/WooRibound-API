package com.wooribound.global.util;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class S3Util {

    @Value("${cloud.aws.s3.bucketName}")
    private String bucket;

    private final AmazonS3Client amazonS3Client;

    // S3에 파일 업로드
    public String uploadFile(MultipartFile multipartFile, String s3FolderName) {
        try {
//            String uploadFileName = createFileName(multipartFile.getOriginalFilename());
            String uploadFileName = createFileName();

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(multipartFile.getContentType());
            metadata.setContentLength(multipartFile.getSize());

            amazonS3Client.putObject(bucket + s3FolderName, uploadFileName, multipartFile.getInputStream(), metadata);

            return amazonS3Client.getUrl(bucket + s3FolderName, uploadFileName).toString();

        } catch (AmazonServiceException e) {
            e.printStackTrace();
            throw new RuntimeException("S3에 파일 업로드 중 오류가 발생했습니다", e);
        } catch (SdkClientException e) {
            e.printStackTrace();
            throw new RuntimeException("클라이언트 오류가 S3에 업로드 중 발생했습니다", e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("파일 입력 중 오류가 발생했습니다", e);
        }

    }

    public void deleteFile(String fileURL, String s3FolderName) {
        try {
            String encodedFileName = fileURL.substring(fileURL.lastIndexOf("/") + 1);
            String deleteFileName = URLDecoder.decode(encodedFileName, StandardCharsets.UTF_8);

            amazonS3Client.deleteObject(new DeleteObjectRequest(bucket + s3FolderName, deleteFileName));
        } catch (AmazonServiceException e) {
            e.printStackTrace();
            throw new RuntimeException("S3에서 파일 삭제 중 오류가 발생했습니다", e);
        }
    }

    // 파일 이름 생성 메소드
//    private String createFileName(String fileName) {
//        return UUID.randomUUID().toString().concat(fileName);
//    }

    private String createFileName() {
        return UUID.randomUUID().toString();
    }
}
