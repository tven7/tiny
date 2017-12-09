package slack.app.tiny.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Base62 {

    private static final codeStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static  Character getChar(int num)
    {
        return codeStr.charAt(num);
    }

    // Given a number calculate  base 62 short code
    public static Optional<String> getShortCode(int num){
        if(num < 0) return Optional.empty();

        if(num==0) return Optional.of(getChar(0).toString());

        List<Integer> digits = new ArrayList<Integer>();
        StringBuffer code = new StringBuffer();

        while (num >0){
            code.append(getChar(num % 62));
            num = num / 62;
        }

        return Optional.of(code.toString()) ;
    }
}