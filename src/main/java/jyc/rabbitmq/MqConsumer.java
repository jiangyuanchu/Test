package jyc.rabbitmq;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * MQ 消费者
 */
@Slf4j
public class MqConsumer {

    //队列名称
    private static final String QUEUE_NAME = "jyc_test_mq_queue";

    public static void main(String[] args) throws InterruptedException, IOException, TimeoutException {
        //获取连接
        Connection connection = CollectionUtil.getConnection();
        //创建信道
        assert connection != null;
        final Channel channel = connection.createChannel();
        //设置客户端最多接受未被ack的消息的个数
        channel.basicQos(64);
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("recv message: " + new String(body));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(QUEUE_NAME, consumer);
        //等待回调函数执行完毕后，关闭资源
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();
    }
}
