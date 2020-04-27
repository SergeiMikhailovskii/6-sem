package com.mikhailovskii.lab8;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mikhailovskii.lab8.entity.Person;
import com.mikhailovskii.lab8.entity.PersonResponse;
import com.mikhailovskii.lab8.service.PersonService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonService service = (PersonService) context.getBean("personService");

        while (true) {
            System.out.println("1 - Work with xml");
            System.out.println("2 - Work with json");
            System.out.println("3 - exit");

            int choice = new Scanner(System.in).nextInt();

            if (choice == 3) {
                return;
            } else if (choice == 1) {
                try {
                    JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
                    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                    Person person = (Person) jaxbUnmarshaller.unmarshal(new File("person.xml"));
                    int id = service.persistPerson(person);
                    PersonResponse response = service.getPersonById(id);

                    jaxbContext = JAXBContext.newInstance(PersonResponse.class);
                    Marshaller marshaller = jaxbContext.createMarshaller();
                    marshaller.marshal(response, new File("output.xml"));
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            } else if (choice == 2) {
                try {
                    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
                    Person person = gson.fromJson(new FileReader("person_json.json"), Person.class);
                    int id = service.persistPerson(person);
                    PersonResponse response = service.getPersonById(id);
                    gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
                    Writer writer = new FileWriter("output_json.json");
                    gson.toJson(response, writer);
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
