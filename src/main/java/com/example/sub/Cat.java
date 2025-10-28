package com.example.sub;

import com.example.Component;

@Component
public class Cat {

    @Autowired
    private Dog dog;

    @PostConstruct
    public void init(){
        System.out.println("cat创建了 cat里面有一个属性"+dog);
    }

}
