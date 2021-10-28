<H2>Effective Java Item2</H2>

- 매개변수가 많아질 가능성이 높을 수록 Builder Pattern 을 활용하

'''
    
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
    
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }
    
        abstract Pizza build();
    
        protected abstract T self(); 
    }

- T 의 경우에는 Builder 자기자신을 상속하여 구현하는 자손까지의 범위로 객체 타입을 선언할 수 있다는 의미
