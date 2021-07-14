import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.Person;

/**
 * @Description todo
 * @ClassName ApplicationStart
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/7/7 15:17
 * @Version V1.0
 */
public class ApplicationStart {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);
    }

}
