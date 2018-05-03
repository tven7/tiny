package com.tiny.service;

import org.springframework.stereotype.Service;
import com.tiny.util.Base62;
import com.tiny.util.Md5;

import java.util.Optional;

/**
 * Created by venktatineni on 5/3/18.
 */
@Service
public class Md5EncodingDecodingService implements EncodingDecodingService{

    @Override
    public Optional<String> encode(String url){
        Md5 md5 = new Md5();
        int hash = md5.hash(url);
        Optional<String> code = Base62.getShortCode(hash);
        return code;
    }

    @Override
    public Optional<String> decode(String code){
        return Optional.ofNullable("");
    }

}
