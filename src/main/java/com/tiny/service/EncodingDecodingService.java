package com.tiny.service;

import java.util.Optional;

/**
 * Created by venktatineni on 5/3/18.
 */
public interface EncodingDecodingService {

   public Optional<String> encode(String in);
   public Optional<String> decode(String in);
}
