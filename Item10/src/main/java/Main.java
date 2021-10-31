import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

enum EffectiveJava{
    ITEM1, ITEM2, ITEM3, ITEM4, ITEM5
}


public class Main {
    public static void main(String[] args) {

    }

    @Test
    @DisplayName("Enum Equal Method Test")
    void defaultEffectiveTest(){
        EffectiveJava x = EffectiveJava.ITEM1;
        EffectiveJava y = EffectiveJava.ITEM1;
        if(x == y){
            System.out.println("Effective Java == Method Correct");
        }
        if(x.equals(y)) {
            System.out.println("Effective Java Equal Method Correct");
        }

        EffectiveJava z = EffectiveJava.ITEM3;
        if(x == z){
            System.out.println("Effective Java == Method Correct");
        }
        if(x.equals(z)) {
            System.out.println("Effective Java Equal Method Correct");
        }
    }

    @Test
    @DisplayName("Enum Equal Method Test")
    void defaultValueEqualTest(){
        Integer x = 3;
        Integer y = 4;
        if(x == y){
            System.out.println("Effective Java == Method Correct");
        }
        if(x.equals(y)){
            System.out.println("Effective Java Equal Method Correct");
        }
    }

    @Test
    void equalMethodTestOnString(){
        class CaseInsensitiveString{
           private final String s;

           public CaseInsensitiveString(String s){
               this.s = s;
           }

           @Override
           public boolean equals(Object o) {
               if (o instanceof CaseInsensitiveString) {
                   return s.equalsIgnoreCase(((CaseInsensitiveString)o).s);
               }
               if (o instanceof String) {
                   return s.equalsIgnoreCase((String) o);
               }
               return false;
           }
        }

        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println(cis.equals(s));
        System.out.println(s.equals(cis));
    }
}




