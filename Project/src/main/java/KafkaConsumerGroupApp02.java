import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.ArrayList;
import java.util.Properties;

public class KafkaConsumerGroupApp02 {
    public static void main(String[] args){
        //Create a properties dictionary for the required/optional Producer config settings:

        Properties props = new Properties();
        props.put("bootstrap.servers","localhost:9092,localhost:9093");
        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("group.id","test-group");

        //--> props.put("config.setting","value");
        // :: http://kafka.apache.org/documentation.html#consumerconfigs

        KafkaConsumer myConsumer = new KafkaConsumer(props);

        ArrayList<String> topics = new ArrayList<String>();
        topics.add("my-big-topic");

        myConsumer.subscribe(topics);

        try{
            while(true){
                ConsumerRecords<String,String> records = myConsumer.poll(10);
                for(ConsumerRecord<String, String> record : records){
                    //Process each record;
                    System.out.println
                            (String.format("Topic : %s, Partition: %d, Value: %s",
                                    record.topic(), record.partition(), record.value().toUpperCase()));

                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            myConsumer.close();
        }
    }
}
