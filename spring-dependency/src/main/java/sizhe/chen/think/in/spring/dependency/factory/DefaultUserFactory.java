package sizhe.chen.think.in.spring.dependency.factory;

import sizhe.chen.think.in.spring.dependency.domain.User;


/**
 * {@link User} 工厂类
 */
public class DefaultUserFactory implements UserFactory {
    public User create(){
        User user = new User();
        user.setId(2L);
        user.setAge(32);
        user.setName("赵六");
        return  user;
    }
}
