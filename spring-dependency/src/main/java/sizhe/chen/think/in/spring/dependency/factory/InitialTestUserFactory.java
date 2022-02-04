package sizhe.chen.think.in.spring.dependency.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class InitialTestUserFactory implements UserFactory, InitializingBean, DisposableBean {
    //1.基于postConstructor

    @PostConstruct
    public void init(){
        System.out.println("@Post Construct :user factory 初始化中");
    }
    @PreDestroy
    public void destroyByAnnotation(){
        System.out.println("@PreDestroy Construct :user factory 销毁中");
    }
    public void initUserFactory(){
        System.out.println("初始化函数 Construct :user factory 初始化中");
    }


    public void destroyUserFactory(){
        System.out.println("销毁函数  :user factory 销毁中");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("接口InitializingBean Construct :user factory 初始化中");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("接口DisposedBean  :user factory 销毁中");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("当前InitialTestUserFactory 正在被回收");
        super.finalize();
    }
}
