package sizhe.chen.think.in.spring.bean.factory;

import org.springframework.beans.factory.FactoryBean;
import sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User;

/**
 * {@link  sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User} 的{@link org.springframework.beans.factory.FactoryBean} 实现
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
