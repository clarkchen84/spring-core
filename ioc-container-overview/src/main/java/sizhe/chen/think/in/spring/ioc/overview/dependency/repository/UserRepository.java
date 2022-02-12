package sizhe.chen.think.in.spring.ioc.overview.dependency.repository;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User;

import java.util.Collection;

/**
 * User 的仓储
 */
public class UserRepository {
    private Collection<User> userCollection;
    private BeanFactory beanFactory;
    private ObjectFactory<User> userObjectFactory;

    public ObjectFactory<User> getUserObjectFactory() {
        return userObjectFactory;
    }

    public void setUserObjectFactory(ObjectFactory<User> userObjectFactory) {
        this.userObjectFactory = userObjectFactory;
    }

    public ObjectFactory<ApplicationContext> getApplicationContextObjectFactory() {
        return applicationContextObjectFactory;
    }

    public void setApplicationContextObjectFactory(ObjectFactory<ApplicationContext> applicationContextObjectFactory) {
        this.applicationContextObjectFactory = applicationContextObjectFactory;
    }

    private ObjectFactory<ApplicationContext> applicationContextObjectFactory;

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "userCollection=" + userCollection +
                '}';
    }
}
