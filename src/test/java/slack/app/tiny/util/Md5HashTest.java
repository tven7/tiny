package slack.app.tiny.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class Md5HashTest {

    @Test
    public void test_bits(){
        Md5Hash md5Hash = new Md5Hash();
        String binary = md5Hash.get42Md5Bits("http://java.com").get();
        assertEquals(32, binary.length());

    }

}
