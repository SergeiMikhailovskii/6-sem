package com.mikhailovskii.lab4;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/Queue"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/Queue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MessageBean implements MessageListener {

    private MessageDrivenContext context;

    @Override
    public void onMessage(Message message) {

        TextMessage textMessage = null;

        if (message instanceof TextMessage) {
            textMessage = (TextMessage) message;
            try {
                if (isInFile(textMessage.getText())) {
                    System.out.println("Line found");
                } else {
                    System.out.println("Line is not found");
                }
            } catch (JMSException e) {
                e.printStackTrace();
                context.setRollbackOnly();
            }
        }

    }

    private boolean isInFile(String message) {
        File file = new File("test.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.equals(message)) {
                    return true;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        return false;
    }

}
