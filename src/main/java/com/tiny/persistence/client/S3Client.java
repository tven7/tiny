package com.tiny.persistence.client;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.File;

/**
 * Created by tven on 5/11/18.
 */
public class S3Client {
    private AWSCredentials credentials = new BasicAWSCredentials(
                                                S3Config.getKey(),
                                                S3Config.getSecret()
                                              );
    private AmazonS3 s3Client = AmazonS3ClientBuilder
                                    .standard()
                                    .withCredentials(new AWSStaticCredentialsProvider(credentials))
                                    .withRegion(S3Config.getRegion())
                                    .build();
    public S3Client(){}
    
    public void upload(File file){
        s3Client.putObject(S3Config.getBucket(), file.getName(),file);
    }
}
