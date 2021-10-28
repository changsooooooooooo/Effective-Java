<H2>Effective Java Item3</H2>

<h3>1. 정적팩토리 사용</h3>

    public class Elvis {
        private static Elvis INSTANCE;
        
        private Elvis(ConnectionMaker connectionMaker) {
            if(INSTANCE != null){
                throw new IllegalStateException();
            }
            this.connectionMaker = connectionMaker;
        }
        public static synchronized Elvis getlnstance() {
            if (INSTANCE == null) INSTANCE = new Elvis(???);
                return INSTANCE;
        }   
    }

- API 변경하지 않고도 Singleton 을 비 Singleton 으로 변형 가능
- Elvis::getInstance() 로서 Supplier 로 사용할 수 있다
- synchronized 사용해서 Critical Session 으로서 다른 thread 의 참고 영역 방지할 수 있다

<h3>2. public static final 사용</h3>

    public class Elvis {    
        public static final Elvis INSTANCE = new Elvis();

        private Elvis(ConnectionMaker connectionMaker) {
            if(INSTANCE != null){
                throw new IllegalStateException();
            }
            this.connectionMaker = connectionMaker;
        } 
    }
- 한 눈에 보기에 Singleton 임을 확인할 수 있다

단, 해당 경우들로 Singleton 만들 경우 Constructor 가 너무 제한적이기에 Test Code 를 작성하는데에 어려움이 있을 수 있다

또한, Serializable 을 implements 하더라도 readResolve() method 를 를 제공해야 싱글톤 패턴으로 사용할 수 있다

<h3>3. Enum 사용</h3>

    public Enum Elvis {    
        INSTANCE;
        
        private Elvis(){
        
        }
    }

- 가볍게 싱글톤을 구현할 때는 Enum 으로 구현하는 것이 좋다
- 직렬화 상황에서도 적용하기 쉽다는 장점이 존재
  
    -> 별도의 구현이 요구되지 않음

