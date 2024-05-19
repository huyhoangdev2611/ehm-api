package com.ehm.ehmapi.service;


import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.time.Instant;
import java.util.Date;


@Service
@Slf4j
public class StorageService {
    @Value("${aws.s3.bucket}")
    private String bucket;

    @Value("${aws.s3.expireSeconds}")
    private Long expireSeconds;

    @Autowired
    private AmazonS3 s3Client;

    public String presign(String objectKey) {
        if (StringUtils.isBlank(objectKey) || StringUtils.isBlank(bucket)) {
            return null;
        }

        Instant expiration = Instant.now().plusSeconds(expireSeconds);

        GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest(bucket, objectKey)
                        .withMethod(HttpMethod.GET)
                        .withExpiration(Date.from(expiration));
        URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }

//    public byte[] downloadFile(String objectKey) {
//        if (StringUtils.isBlank(objectKey)) {
//            throw new RuntimeException("File not found");
//        }
//
//        try {
//            S3Object s3object = s3Client.getObject(new GetObjectRequest(bucket, objectKey));
//            S3ObjectInputStream objectInputStream = s3object.getObjectContent();
//
//            return IOUtils.toByteArray(objectInputStream);
//        } catch (IOException | AmazonClientException e) {
//            log.error(e.getMessage());
//            throw new RuntimeException("Cannot download file");
//        }
//    }

//    public byte[] downloadFile(File file) {
//        return downloadFile(file.getObjectKey(), file.getBucket());
//    }
}
