package slack.app.tiny.model;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class LinkTest {

    @Test
    public void test_row_create(){
        Link link = new Link("http://example.com");
        Optional optional = link.createRow();
        assertEquals(optional.get(),1);
    }

}
