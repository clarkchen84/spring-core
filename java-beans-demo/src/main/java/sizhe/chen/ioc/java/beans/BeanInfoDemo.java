package sizhe.chen.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.Arrays;

/**
 *
 * {@link java.beans.BeanInfo}
 * @Author: sizhe.chen
 * @Date: Create in 10:39 下午 2022/1/15
 * @Description:
 * @Modified:
 * @Version:
 */

public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
        Arrays.stream(beanInfo.getPropertyDescriptors()).forEach( propertyDescriptor ->
            {
                System.out.println(propertyDescriptor);
                //propertyDescriptor 允许添加属性编辑器 -> propertyEditor
                Class<?> propertyType = propertyDescriptor.getPropertyType();
                String name = propertyDescriptor.getName();
                if("age".equals(name)){
                     propertyDescriptor.setPropertyEditorClass(StringToInteger.class);
                    //propertyDescriptor.createPropertyEditor( "1");
                }else{
                    propertyDescriptor.setPropertyEditorClass(PropertyEditorSupport.class);
                    //propertyDescriptor.createPropertyEditor( "张三");
                }
            }
        );
    }

    public static class StringToInteger extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
