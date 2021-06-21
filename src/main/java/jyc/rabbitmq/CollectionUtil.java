package jyc.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CollectionUtil {

    public static Connection getConnection()
    {
        try
        {
            Connection connection = null;
            //定义一个连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            //设置服务端地址（域名地址/ip）
            factory.setHost("47.94.103.229");
            //设置服务器端口号
            factory.setPort(5672);
            //设置虚拟主机(相当于数据库中的库)
//            factory.setVirtualHost("/");
            //设置用户名
            factory.setUsername("admin");
            //设置密码
            factory.setPassword("admin");
            connection = factory.newConnection();
            return connection;
        } catch (Exception e)
        {
            log.info("rabbitMQ 连接失败");
            e.printStackTrace();
            return null;
        }
    }

}
