<H2>Effective Java Item6</H2>

    public class RomanNumerals{
        private static final Patter ROMAN = Pattern.compile(
            "^(?=.)M*(C[]MD|D?C{0, 3})"
        
        )
        static boolean isRomanNumeral(String s){
            return ROMAN.matcher(s).matches();
        }
    }

- 해당 부분 처럼 코드를 작성하면, isRomanNumeral method 가 호출될 때마다 새로운 매칭 패턴이 생성되는게 아니므로 JVM의 로드를 줄여줄 수 있다!
- 만약 기존의 방식을 새로운 class 선언으로 극복하고 해당 method 를 다시 사용하지 않는다 하더라도 @Lazy 로 선언해서 사용하는 것은 비추한다

---

- AutoBoxing 을 피하는 것 역시 불필요한 객체를 생성하는 것을 방지하는 방법 중 하나이다
  - > Long 을 long 으로 바꿔서 사용할 바에는 애초에 long 을 사용하면 된다!

---

<b>Adapter Pattern 이란?</b>

- 특정 객체를 다른 객체로 호환시키는 경우를 의미한다
  - 책에서 나온 Adapter Pattern 의 경우에는 Map 이라는 동일한 하나의 객체를 기준으로 아무리 keySet 을 많이 파생시켜봐도 Map 하나의 불변 객체를 기준으로 만들어지는 거라 모두 동일하다는 의미로 받아들이면 다된
