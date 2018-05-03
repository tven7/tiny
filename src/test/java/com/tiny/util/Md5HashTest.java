package com.tiny.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class Md5HashTest {

    @Test
    public void test_hash(){
        Md5 md5 = new Md5();
        int hash = md5.hash("http://java.com");
        assertEquals(1465655010, hash);

    }

}
