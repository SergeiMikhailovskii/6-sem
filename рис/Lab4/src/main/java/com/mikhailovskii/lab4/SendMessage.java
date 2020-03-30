package com.mikhailovskii.lab4;

import javax.annotation.Resource;
import javax.jms.*;

public class SendMessage {

    @Resource(mappedName = "jms/ConnectionFactory")
    private static ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/Queue")
    private static Queue queue;

    public static void main(String[] args) {

        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            TextMessage message = session.createTextMessage("Hello world");
            messageProducer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }

}
