package com.rx.config;

import com.rx.entity.Car;
import com.rx.entity.Person;
import com.rx.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//次注解表示当前类为一个配置类
@Configuration(proxyBeanMethods = false)
public class TestConfig {
    @Bean
    public Car getCar(){
        return new Car("五菱宏光","粉色");
    }

    @Bean
    //参数会自动从容器中去获取
    public Person getPerson(Car car){
        return new Person("炎龙铠甲", getCar());
    }
    //将User类的对象注入到容器中
    @Bean
    @Scope("prototype")
    public User getUser(){
        return new User();
    }
    public TestConfig(){
        System.out.println("构造方法");
    }

    public String test(){
        System.out.println("勇毅前行");
        return "一口一个";
    }
}
