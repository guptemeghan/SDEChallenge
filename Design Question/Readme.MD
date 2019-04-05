Thought process : 

We want to build a highly scalable and robust system capable of handling billions of request per day. We also need to be able to process the historical data. Since a delay of upto 1 hour is acceptable, I thought of using asynchronous mechanisms such as JMS or Kafka. But since Kafka is highly scalable and more reliable, I decided to use Kafka. Kafka persists the events on disk and this will help us playback the events in case of any bug in the processing logic. Kafka MirrorMaker will provide geolocation support by replicating the data across multiple cloud regions. Since the kafka topics are replicated across multiple servers, it is more fault tolerant

On a high level, there would be 2 services - 

publishEvent : This will publish the messages to the Kafka queue

getInsight : Provide non-real time insights

Since we are dealing with billions of requests, we need some sort of auto scaling in place. I will use aws auto scaling to handle this.

We can use Kafka stream or spark stream for processing the events. However, since we are dealing with a large amount of data, spark stream is more optimal for this use case. Spark streaming would process the incoming messages in the queue and perform ETL operations to push it to Hive. The getInsights service would directly query Hive to fetch the insight. 


![alt text](https://github.com/guptemeghan/SDEChallenge/blob/master/Design%20Question/Capture.PNG)

Overall flow :

Write an event

1. When the user performs any action, analytics event is fired.
2. The request reaches the API gateway, which is will authenticate and forward the request to the publishEvents service.
3. The publish events service will publish these events to a particular kafka topic.
4. Spark streaming will consume these messages and will perform ETL operation and ingest the data into Apache Hive.


Read Insights 

1. When the user request to see insight, the request first reaches the api gateway which will authenticate and forward the request to the getInsights service
2. The getInsights service will connect to hive database which already has the pre processed data and return it to the user.



