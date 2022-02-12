package sizhe.chen.think.in.spring.dependency.factory;

import org.springframework.beans.factory.FactoryBean;
import sizhe.chen.think.in.spring.dependency.domain.User;


/**
 * {@link  User} 的{@link FactoryBean} 实现
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
       return  User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
