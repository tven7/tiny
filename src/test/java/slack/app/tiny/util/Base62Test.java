package slack.app.tiny.util;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Optional;

public class Base62Test {
    @Test
    public void  testShortCode_negative(){
        assertEquals(Optional.empty(),Base62.getShortCode(-1));
    }

    @Test
    public void testShortCode_valid_small(){
        assertEquals("9",Base62.getShortCode(61).get());
    }

    @Test
    public void testShortCode_valid_big(){
        assertEquals("cLwo",Base62.getShortCode(3423456).get());
    }
}
