package sizhe.chen.thinking.in.spring.ioc.dependency.injection;

import sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User;

/**
 * {@link User}的保有对象
 */
public class StringHolder {
    public StringHolder(){

    }
    private String name1;
    private String name2;

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }


    public StringHolder(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    @Override
    public String toString() {
        return "StringHolder{" +
                "name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                '}';
    }
}
