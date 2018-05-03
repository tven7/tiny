package com.tiny.util;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Optional;

public class Base62Test {

    @Test
    public void  testShortCode_negative()
    {
        assertEquals(Optional.empty(),Base62.getShortCode(-1));
    }

    @Test
    public void testShortCode_valid_small()
    {
        assertEquals("b",Base62.getShortCode(1).get());
    }

    @Test
    public void testShortCode_valid_big(){
        assertEquals("bLMuvc",Base62.getShortCode(2147483647).get());     //max  int value
    }
}
