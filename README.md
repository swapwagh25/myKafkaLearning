# myKafkaLearning

Below are the few important Kafka commands which I have used through out my learning session.

Kafka command
https://kafka.apache.org/quickstart
Start ZooKeeper:
brew services start zookeeper
==> Successfully started `zookeeper` (label: homebrew.mxcl.zookeeper)

bin/zookeeper-server-start.sh config/zookeeper.properties

Start Kafka:
brew services start zookeeper
==> Successfully started `zookeeper` (label: homebrew.mxcl.zookeeper)

bin/kafka-server-start.sh config/server.properties
Stop Kafka:
brew services start zookeeper
==> Successfully started `zookeeper` (label: homebrew.mxcl.zookeeper)
Stop ZooKeeper:
brew services stop zookeeper
Stopping `zookeeper`... (might take a while)
==> Successfully stopped `zookeeper` (label: homebrew.mxcl.zookeeper)

Create Topic:
bin/kafka-topics.sh --create --topic my_topic --zookeeper localhost:2181 --replication-factor 1 --partitions 1

List the Topic:
bin/kafka-topics.sh --list --zookeeper localhost:2181 

Producer statement: 
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic my_topic

Consumer Statement: 
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my_topic --from-beginning

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my_topic

Starting Multiple Kafka on single ZooKeeper:
bin/kafka-server-start.sh config/server.properties
bin/kafka-server-start.sh config/server-1.properties
bin/kafka-server-start.sh config/server-2.properties

Updated the server property as below

broker.id=0
listeners=PLAINTEXT://:9092
log.dirs=/tmp/kafka-logs


server.1.properties
broker.id=1
listeners=PLAINTEXT://:9093
log.dirs=/tmp/kafka-logs1


server.2.properties
broker.id=2
listeners=PLAINTEXT://:9094
log.dirs=/tmp/kafka-logs2

Create a Topic with 3 replication factor 
bin/kafka-topics.sh --create --topic replicated_topic --zookeeper localhost:2181 --replication-factor 3 --partitions 1

See the details of the topic created
bin/kafka-topics.sh --describe --topic replicated_topic --zookeeper localhost:2181

Eg.
bin/kafka-topics.sh --describe --topic replicated_topic --zookeeper localhost:2181 
Topic: replicated_topic	PartitionCount: 1	ReplicationFactor: 3	Configs: 
	Topic: replicated_topic	Partition: 0	Leader: 2	Replicas: 2,1,0	Isr: 2,1,0


Other Usefull commands which were used throughout the learning phase :

bin/kafka-console-producer.sh --broker-list localhost:9092 --topic replicated_topic

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic replicated_topic --from-beginning

Killed the 2 instance of broker and verified the status
bin/kafka-topics.sh --describe --topic replicated_topic --zookeeper localhost:2181
Topic: replicated_topic	PartitionCount: 1	ReplicationFactor: 3	Configs: 
	Topic: replicated_topic	Partition: 0	Leader: 1	Replicas: 2,1,0	Isr: 1,0


bin/kafka-topics.sh --describe --topic replicated_topic --zookeeper localhost:2181 
Topic: replicated_topic	PartitionCount: 1	ReplicationFactor: 3	Configs: 
	Topic: replicated_topic	Partition: 0	Leader: 2	Replicas: 2,1,0	Isr: 1,0,2

/Users/mohswap/Documents/Personal/US/Career/Learning/kafka/kafka_2.13-2.6.0
bin/kafka-topics.sh --describe --topic replicated_topic --zookeeper localhost:2181 
bin/kafka-topics.sh --describe --topic my-topic --zookeeper localhost:2181 
bin/kafka-topics.sh --create --topic my-topic --zookeeper localhost:2181 --replication-factor 3 --partitions 3
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic my-topic
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my-topic --from-beginning

bin/kafka-topics.sh --create --topic my-other-topic --zookeeper localhost:2181 --replication-factor 3 --partitions 3

bin/kafka-topics.sh --describe --zookeeper localhost:2181 


bin/kafka-producer-perf-test.sh --topic my-other-topic --num-records 50 --record-size 1 --throughput 10 --producer-props bootstrap.servers=localhost:9092 key.serializer=org.apache.kafka.common.serialization.StringSerializer value.serializer=org.apache.kafka.common.serialization.StringSerializer

bin/kafka-producer-perf-test.sh --topic my-topic --num-records 50 --record-size 1 --throughput 10 --producer-props bootstrap.servers=localhost:9092 key.serializer=org.apache.kafka.common.serialization.StringSerializer value.serializer=org.apache.kafka.common.serialization.StringSerializer

bin/kafka-topics.sh --zookeeper localhost:2181 --alter --topic my-topic --partitions 4

bin/kafka-topics.sh --zookeeper localhost:2181 --describe --topic __consumer_offsets


bin/kafka-topics.sh --create --topic my-big-topic --zookeeper localhost:2181 --replication-factor 4 --partitions 4

bin/kafka-topics.sh --zookeeper localhost:2181 --alter --topic my-big-topic --partitions 4 --replication-factor 4

bin/kafka-topics.sh --zookeeper localhost:2181 --alter --topic my-big-topic --replication-factor 4

bin/kafka-topics.sh --zookeeper localhost:2181 --delete --topic my-big-topic


