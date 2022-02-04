package sizhe.chen.think.in.spring.dependency.factory;


import sizhe.chen.think.in.spring.dependency.domain.User;

/**
 * {@link User} 工厂类
 */
public interface UserFactory {
    default User create(){
       return User.createUser();
    }
}
