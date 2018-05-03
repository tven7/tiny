package com.tiny.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Optional;

public class Md5 {

    private ByteArrayBitIterable bitIterable;
    public static int ERROR = -1;

    public int hash(String text)  {

        if(text == null || text.length() < 4){
            return -1;
        }

        int bitCount = 0;

        try{
            createHash(text);
            StringBuilder builder = new StringBuilder();
            for(boolean b:bitIterable){
                if(bitCount > 30) //greater than 30 bits would result in an Integer overflow
                    break;
                builder.append(b==true?1:0);
                bitCount++;
            }
            return Integer.parseInt(builder.toString(),2);
        }catch(NoSuchAlgorithmException nsae){
            nsae.printStackTrace();
        }
        return -1;
    }

    private void createHash(String text) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(text.getBytes());
        this.bitIterable = new ByteArrayBitIterable(md.digest());

    }

    class ByteArrayBitIterable implements Iterable<Boolean>{

        byte[] byteArray;
        public ByteArrayBitIterable(byte[] array) {
            this.byteArray = array;
        }

        public Iterator<Boolean> iterator() {

            return new Iterator<Boolean>() {
                int bitIndex = 0;
                int arrayIndex = 0;
                @Override
                public boolean hasNext() {
                    return (arrayIndex < byteArray.length) && (bitIndex < 8);
                }

                @Override
                public Boolean next() {
                    boolean val = (byteArray[arrayIndex] >> (7-bitIndex) & 1) == 1;
                    bitIndex++;
                    if(bitIndex == 8) {
                        bitIndex = 0;
                        arrayIndex++;
                    }
                    return val;
                }
            };
        }
    }


}

