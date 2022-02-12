package sizhe.chen.think.in.spring.bean.factory;

import sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User;

/**
 * {@link User} 工厂类
 */
public interface UserFactory {
    default User create(){
       return User.createUser();
    }
}
