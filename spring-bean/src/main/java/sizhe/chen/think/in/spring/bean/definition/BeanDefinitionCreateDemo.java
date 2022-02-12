package sizhe.chen.think.in.spring.bean.definition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import sizhe.chen.think.in.spring.ioc.overview.dependency.domain.User;

/**
 * {@link  org.springframework.beans.factory.config.BeanDefinition}
 */
public class BeanDefinitionCreateDemo {
    public static void main(String[] args) {

        //mvn dependency:resolve -Dclassifier=sources
        //1.通过 BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder =BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("name","张三")
                .addPropertyValue("age",13).addPropertyValue("id",1L);
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();


        //通过AbstractBeanDefinition 的派生
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.add("name","李四");
        mutablePropertyValues.addPropertyValue("age",12);
        mutablePropertyValues.addPropertyValue("id",2L);
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);




    }
}
