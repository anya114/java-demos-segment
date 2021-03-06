package com.wxmimperio.hbase.comsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxmimperio on 2016/12/5.
 */
public class ConsumerMain {
    public static void main(String args[]) {
        List<String> topicList = new ArrayList<>();
        topicList.add("test_001");
        topicList.add("test_2");
        topicList.add("test_1");

        List<String> topicList1 = new ArrayList<>();
        topicList1.add("test_001");
        topicList1.add("test_1");

        KafkaNewConsumer consumer = new KafkaNewConsumer(topicList, "group_1");
        consumer.execute(3);

        KafkaNewConsumer consumer1 = new KafkaNewConsumer(topicList, "group_2");
        consumer1.execute(3);

        KafkaNewConsumer consumer2 = new KafkaNewConsumer(topicList1, "group_4");
        consumer2.execute(3);

    }
}
