package slack.app.tiny.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Base62 {

    private static final HashMap<Integer,Character> code = createMap();
    private static HashMap<Integer,Character>  createMap(){
        HashMap<Integer,Character> map = new HashMap<>();
        map.put(0,'a');
        map.put(1,'b');
        map.put(2,'c');
        map.put(3,'d');
        map.put(4,'e');
        map.put(5,'f');
        map.put(6,'g');
        map.put(7,'h');
        map.put(8,'i');
        map.put(9,'j');
        map.put(10,'k');
        map.put(11,'l');
        map.put(12,'m');
        map.put(13,'n');
        map.put(14,'o');
        map.put(15,'p');
        map.put(16,'q');
        map.put(17,'r');
        map.put(18,'s');
        map.put(19,'t');
        map.put(20,'u');
        map.put(21,'v');
        map.put(22,'w');
        map.put(23,'x');
        map.put(24,'y');
        map.put(25,'z');
        map.put(26,'A');
        map.put(27,'B');
        map.put(28,'C');
        map.put(29,'D');
        map.put(30,'E');
        map.put(31,'F');
        map.put(32,'G');
        map.put(33,'H');
        map.put(34,'I');
        map.put(35,'J');
        map.put(36,'K');
        map.put(37,'L');
        map.put(38,'M');
        map.put(39,'N');
        map.put(40,'O');
        map.put(41,'P');
        map.put(42,'Q');
        map.put(43,'R');
        map.put(44,'S');
        map.put(45,'T');
        map.put(46,'U');
        map.put(47,'V');
        map.put(48,'W');
        map.put(49,'X');
        map.put(50,'Y');
        map.put(51,'Z');
        map.put(52,'0');
        map.put(53,'1');
        map.put(54,'2');
        map.put(55,'3');
        map.put(56,'4');
        map.put(57,'5');
        map.put(58,'6');
        map.put(59,'7');
        map.put(60,'8');
        map.put(61,'9');
        return map;


    }

    private static  Character getChar(int num){
        return code.get(num);
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

    public static void main(String [] args) {
        System.out.println(Base62.getShortCode(345).orElse("nothing"));
    }
}