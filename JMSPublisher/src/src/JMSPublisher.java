package src;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Topic;

public class JMSPublisher {
	public void publishTopicMessages() {
		ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
		JMSContext jmsContext = connectionFactory.createContext();
		JMSProducer jmsProducer = jmsContext.createProducer();
		try {
			Topic topic = new com.sun.messaging.Topic("ATJTopic");
			for (int i = 0; i < 10; i++) {
				String msg = "Message_" + i;
				jmsProducer.send(topic, msg);
				System.out.printf("Wiadomoœæ '%s' zosta³a opublikowana.\n", msg);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
		jmsContext.close();
	}

}
