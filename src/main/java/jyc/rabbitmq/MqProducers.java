package jyc.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * MQ 生产者
 */
@Slf4j
public class MqProducers {

    //队列名称
    private static final String QUEUE_NAME = "jyc_test_mq_queue";

    public static final String EXCHANGE_NAME = "exchange_demo";

    public static final String ROUTING_KEY = "rounting_demo";

    public static void main(String[] args) {
        try{
            //获取MQ连接
            Connection connection = CollectionUtil.getConnection();
            //从连接中获取一个通道
            assert connection != null;
            Channel channel = connection.createChannel();
            //创建一个type="direct", 持久化、非自动删除的交换器
            channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);
            //创建一个持久化、非排他的、非自动删除的队列
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            //将交换器与队列通过路由键绑定
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
            //消息内容
            String message = "Hello World";
            //发送持久化消息
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            channel.close();
            connection.close();
        } catch (IOException | TimeoutException e){
            e.printStackTrace();
            log.info("发送队列消息失败");
        }
    }


}
