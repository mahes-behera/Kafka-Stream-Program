# Kafka-Stream-Program
domainList project will just create the list and make it avaialble to url
It contains the 3 projects i. domain-producer ii. domain-service iii. kafkastreamprocessor
domain-producer will get the collection from url and pass to topic "mytopic8"
domain-service in its input stream it takes from "mytopic8" and filter (optional) then pass to topic "mytopic9"
kafkastreamprocessor in its consumer stream it takes from "mytopic9" and process it.
If you run console consumer with "mytopic9" then you can get the output which producer send
We can bypass domain-service by domain-producer to kafkastreamprocessor . In this case domain-producer will send to the topic which kafkastreamprocessor will get it.

https://www.youtube.com/watch?v=rqjdSbIOrJ4&t=602s
