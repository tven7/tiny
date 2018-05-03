package com.tiny.persistence.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tven on 5/11/18.
 */
@Configuration
public class S3Config {
    @Value("${aws_access_key}")
    private static String key;

    @Value("${aws_secret}")
    private static String secret;

    @Value("${aws_s3_region")
    private static String region;

    @Value("${aws_s3_bucket")
    private static String bucket;

    public static String getKey(){
        return key;
    }

    public static String getSecret(){
        return secret;
    }

    public static String getRegion(){
        return region;
    }

    public static String getBucket(){
        return bucket;
    }
}
