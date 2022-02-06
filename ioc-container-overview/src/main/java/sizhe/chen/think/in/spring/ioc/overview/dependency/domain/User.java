package sizhe.chen.think.in.spring.ioc.overview.dependency.domain;

import org.springframework.core.io.Resource;
import sizhe.chen.think.in.spring.ioc.overview.dependency.enums.City;

public class User {

    private String name;
    private Long id;
    private Integer age;
    private City city;
    private Resource configLocation;

    public Resource getConfigLocation() {
        return configLocation;
    }

    public void setConfigLocation(Resource configLocation) {
        this.configLocation = configLocation;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    public User() {

    }

    public static User createUser(){
        User user = new User();
        user.setId(1L);
        user.setAge(22);
        user.setName("王五");
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", city=" + city +
                ", configLocation=" + configLocation +
                '}';
    }
}
