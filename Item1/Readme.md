<H1>Effective-Java Item 1</H1>

<H3>
1. 이름을 가질 수 있다
</H3>
<pre>
<code>
public Test(){

}

---

private Test(){

}

public static makeTestByAddress(String address){

}
</code>
</pre>

<H3>
2. 호출할 때마다 인스턴스를 새로 생성하지 않아도 된다
</H3>

<pre>
<code>
public final class Boolean{
    public Boolean valueOf(boolean b){
        if(b){
            return true;
        }
        return false;
    }
}
<hr/>
public final class Boolean implements Serializable,Comparable<Boolean> {

    public static final Boolean TRUE = new Boolean(true);

    public static final Boolean FALSE = new Boolean(false);

    public static Boolean valueOf(boolean b) {
        return (b ? TRUE : FALSE);
    }
}
</code>
</pre>

- 상수화를 시킴으로서 method 호출시 마다 객체를 새로 만들 이유가 없다.
- 이런 식으로 Singleton 패턴을 활용할 수 있다.

<H3>
3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다
</H3>

<pre>
<code>
public interface Test{
    
    public static Test returnFirstChild(){
        return new FirstChild();
    }

    public static Test returnSecondChild(){
        return new SecondChild();
    }
}

public class FirstChild implements Test{

}

public class SecondChild implements Test{

}
</code>
</pre>

<H3>
4. 매개 변수에 따라 다른 객체를 반환할 수 있다
</H3>

<pre>
<code>
class Test{
    
    private name;
    private address;

    public Test(String name){
        this.name = name;
    }

    public Test(String address){
        this.address = address
    }
}

<hr>

class Test{
    
    private name;
    private address;

    public static Test makeByName(String name){
        Test x = new Test();
        x.name = name;
        return x;
    }

    public static Test makeByAddress(String address){
        Test x = new Test();
        x.address = address;
        return x;
    }
}
</code>
</pre>

<H3>
5. 매개 변수에 따라 다른 객체를 반환할 수 있다
</H3>


<pre>
<code>
Class.forName(<"class-path">);
</code>
</pre>
- 이렇게 클래스가 만들어지기 전에 path 로서 등록하여 설정할 수 있다.

<hr>


<H3>
1. 누군가의 부모가될 수 없다.
</H3>

- Constructor 가 private 이기 때문에

<H3>
2. Method 검색이 어렵다.
</H3>
