package com.example.sub;

import com.example.Component;
import com.example.PostConstruct;

@Component(name = "mydog")
public class Dog {

    @Autowired
    Cat cat;

    @Autowired
    Dog dog;

    @PostConstruct
    public void init() {
        System.out.println("Dog创建了 dog里面有一只猫" + this.cat);
        System.out.println("Dog创建了 dog里面有一只狗" + dog);
    }
}
