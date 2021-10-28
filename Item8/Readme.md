<H2>Effective Java Item8</H2>

<H3>finalizer, cleaner 사용을 피하라</H3>

- finalizer, cleaner 의 경우에는 실행 시간을 예측할 수 없다
  - 우선순위가 낮아 다른 프로세스가 실행되는 동안 후순위로 밀려 계속 쌓이고 있을 가능성이 높다
  - finalizer, cleaner 로 제거할 프로세스의 경우에는 결국 축적되어 OOM Error 로 작용할 수 있다
    > 만약 database 에 접근하는 권한을 사용한 후 lock = false 로 바꾸는 경우에 finalizer, cleaner 를 사용하게 되면 lock = true 로 영원히 다른 process의 경우에 참조하지 못하는 웃픈 경우가 발생한다

- cleaner 의 경우에는 api 가 없기에 내부적으로 직접 구현해야 한다
  - 또한 내부 구현 class 를 static 으로 선언해야 하는데, 이 이유는 바깥 class 를 참조하지 않게 하기 위함이다
    - 왜냐하면 내부 class 가 바깥 class 를 참조하게 되면 순환참조가 생기게 되고 JVM GC 가 수거해갈 기회가 오지 않는다!
  
이 부분을 꼭 기억하자
><b>System.exit 을 호출할 때의 cleaner 동작은 구현하기 나름이며 청소를 보장하지 않는다</b>

결국, 왠만하면 finalizer, cleaner 의 사용을 피해야 한다

---

<H2>Effective Java Item9</H2>

    BufferedReader br = new BufferedReader(new FileReader(path));
    try{
        return br.readLine();
    }finally{
        br.close();
    }

- 만약, 애초에 코드 자체를 실행하지 못하는 경우 close() 를 실행하지 못한 Exception 이 readLine() 하지 못한 Exception 을 덮어 버린다.
---

    BufferedReader br = new BufferedReader(new FileReader(path));
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            br.readLine();
        }
    }

- 이 경우에는 finally 가 없으므로 br.readLine() 하는 부분의 에러가 우선순위를 가지고 stack 에 close 하지 못했다는 에러 역시 suppressed 되어 유지된다.
- 또한, 코드의 간결성이 높아진다
  
  -> 만약 try 안에 또 try 를 해야 하는 상황이 생기면 더 생각하기 쉬워진다! 

