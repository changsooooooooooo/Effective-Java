<H1>Item15</H1>

- public class 의 인스턴스 필드는 되도록 public 이 아니어야 한다
  
  - final 이 아닌 인스턴스 필드를 public 으로 선언하게 되면 값의 제한 여부를 외부에서 결정할 수 있다
  - 심지어 이 경우에는 thread 안전하지 않은 경우가 발생한다.
  
- But, 구성요소로써의 상수라면 public static final 로 선언하여 접근할 수 있다.
  
  - 배열의 길이라든지 등등,,,
  - 그러나 배열자체를 public static final 로 선언하게 되면 어차피 내부 원소에 접근이 가능한 문제가 야기된다.


    private static final Thing[] PRIVATE_VALUES = {., ., .};
    public static final List<Thing> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

  - public 불변리스트로 변경하는 방법


    private static final Thing[] PRIVATE_VALUES = {., ., .};
    public static final Thing[] values() {
      return PRIVATE_VALUES.clone();
    }

  - 복사 객체를 별도로 전달하는 방법(방어적 복사)
