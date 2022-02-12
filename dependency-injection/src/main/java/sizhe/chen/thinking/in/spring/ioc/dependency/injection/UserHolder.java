package sizhe.chen.thinking.in.spring.ioc.dependency.injection;

import sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User;

/**
 * {@link User}的保有对象
 */
public class UserHolder {
    public UserHolder(){

    }
    public UserHolder(User user) {
        this.user = user;
    }

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user.toString() +
                '}';
    }
}
