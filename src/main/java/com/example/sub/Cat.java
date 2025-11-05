package com.example.sub;

import com.example.Autowired;
import com.example.Component;
import com.example.PostConstruct;

@Component
public class Cat {

    @Autowired
    private Dog dog;

    @PostConstruct
    public void init(){
        System.out.println("cat创建了 cat里面有一个属性"+dog);
    }

}
