package com.mo.component;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import lombok.Data;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mo on 2021/5/20
 * kafka日志输出Appender
 */
@Data
public class KafkaAppender extends AppenderBase<ILoggingEvent> {

    //kafka地址
    private String brokers;
    //kafka topic
    private String topic;

    private KafkaTemplate kafkaTemplate;

    @Override
    public void start() {

        Map<String, Object> kafkaProps = new HashMap<>();
        //连接地址
        kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        //键的序列化⽅式
        kafkaProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        //值的序列化⽅式
        kafkaProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        //重试，0为不启⽤重试机制
        kafkaProps.put(ProducerConfig.RETRIES_CONFIG, 1);
        //控制批处理⼤⼩，单位为字节
        kafkaProps.put(ProducerConfig.BATCH_SIZE_CONFIG, 10240);
        //批量发送，延迟为1毫秒，启⽤该功能能有效减少⽣产者发送消息次数，从⽽提⾼并发量
        kafkaProps.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        //⽣产者可以使⽤的最⼤内存字节来缓冲等待发送到服务器的记录
        kafkaProps.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 1024000);

        kafkaTemplate = new KafkaTemplate(new DefaultKafkaProducerFactory(kafkaProps));
        super.start();
    }

    @Override
    protected void append(ILoggingEvent iLoggingEvent) {

        kafkaTemplate.send(topic, iLoggingEvent.getMessage());
    }
}
