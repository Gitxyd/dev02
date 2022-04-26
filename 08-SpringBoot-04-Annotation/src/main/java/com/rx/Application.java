package com.rx;

import com.rx.config.TestConfig;
import com.rx.entity.Car;
import com.rx.entity.Person;
import com.rx.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Map;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //1、用于启动SpringBoot项目
        //2、用于获取Spring容器
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        //从容器中获取Bean对象
        TestConfig testConfig = applicationContext.getBean(TestConfig.class);

        System.out.println("hashCode" + testConfig.hashCode());
        System.out.println("地址：" + testConfig);

        User user = applicationContext.getBean(User.class);
        User user1 = applicationContext.getBean(User.class);

        System.out.println(user);
        System.out.println("容器中的两个对象" + (user == user1));

        User user2 = testConfig.getUser();
        User user3 = testConfig.getUser();

        System.out.println("创建的两个对象" + (user2 == user3));
        System.out.println("容器与创建的两个对象" + (user == user3));

        System.out.println("---------------------------------------------");

        Person person = applicationContext.getBean(Person.class);

        Car car = applicationContext.getBean(Car.class);

//        Car newCar = testConfig.getCar();
//
//        person.setCar(newCar);
        System.out.println("人的车和容器里的车：" + (person.getCar() == car));


    }

}
