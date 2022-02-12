package sizhe.chen.think.in.spring.dependency.domain;

public class User {

    private String name;
    private Long id;
    private Integer age;

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
                '}';
    }
}
