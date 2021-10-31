<h2>Effective Java - Item10</h2>


<b>값 클래스라 해도, 값이 같은 인스턴스가 둘 이상 만들어지지 않음을 보장하는 인스턴스라면 equals를 재정의하지 않아도 된다</b>

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

- enum 의 경우에는 위 코드 처럼 정의해도 원하는 결과를 얻을 수 있다.
- final static 의 경우에도 (constructor 선언) 마찬가지이다.

<b>값 클래스의 경우 재정의가 필요하다</b>

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

<b>대칭성 위반 예시</b>

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
        System.out.println(cis.equals(s)); // return true
        System.out.println(s.equals(cis)); // return false
    }
