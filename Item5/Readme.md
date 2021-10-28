<H3>Effective Java Item5</H3>

    public class SpellChecker{
        private static final Lexicon dictionary = ....;
        
        private SpellChecker() {}
        
        public static boolean isValid(String word){...}
        public static List<String> suggestions(String typo){...}
    }
---
    public class SpellChecker{
        
        private final Lexicon dictionary = ...;

        private SpellChecker(){}
        public static final SpellChecker INSTANCE = newe SpellChecker();

        public static boolean isValid(String word){...}
        public static List<String> suggestions(String typo){...}
    }

- 위 코드의 문제는 dictionary 가 오로지 하나 밖에 적용되며 아래도 마찬가지이다.
- 궁극적인 문제는 Constructor 가 private 이라 dictionary 를 변경할 수 없다는데에 있다.

    > DI 를 적용하자!

- 아래와 같이 코드를 적용하면 된다!


    public class SpellChecker{
        
        private final Lexicon dictionary;

        public SpellChecker(Lexicon dictionary){
          this.dictionary = dictionary;
        }
    }
