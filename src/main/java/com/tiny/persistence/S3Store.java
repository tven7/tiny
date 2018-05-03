package com.tiny.persistence;

import java.io.File;

/**
 * Created by tven on 5/10/18.
 */
public class S3Store implements Store<File> {
    @Override
    public boolean isExists(Class<File> file){
        return false;
    }

    @Override
    public void index(Class<File> file){

    }
}
