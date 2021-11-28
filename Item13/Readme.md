<H2>Item 13</H2>

    public final class FinalClass {

        int x;
    
        public FinalClass(int x){
            this.x = x;
        }
    
        public int getter() {
            return x;
        }
    }

    class FinalHeritClass extends FinalClass {

    }

- final class 는 상속이 불가능하다
  
  - 그래서 상속을 통한 super.clone() 이 애초에 불가능하다!

  

    public Yum(Yum yum) {
    
    }

    public static Yum newInstance(Yum yum) {
    
    }

- Cloneable 을 굳이 구현할 필요가 없는 경우에는 복사생성자/복사팩토리를 사용하는 것이 좋다
