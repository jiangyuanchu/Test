import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import selfEditor.Customer;

/**
 * @description todo
 * @author jiangyuanchu
 * @data 2022/1/6 11:56 上午
 */
public class  SpringStart {

    public static void main(String[] args) {
        // 自定义属性资源加载器
        ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
        Customer customer = app.getBean(Customer.class);
        System.out.println(customer);

//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext()
//        Object person = app.getBean("person");
//        System.out.println(person);
//        System.out.println("abc" + null);
    }

}

