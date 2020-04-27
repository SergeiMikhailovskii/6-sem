package com.mikhailovskii.lab9_servlet;

import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/searchPersonById")
public class SearchPersonById extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req);
        int id = Integer.parseInt(req.getParameter("personId"));

        String url = "http://localhost:8080/persons/" + id;
        HttpGet get = new HttpGet(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();

        System.out.println("Query: " + get.getRequestLine());

        ResponseHandler<String> responseHandler = httpResponse -> {
            HttpEntity httpEntity = httpResponse.getEntity();
            String entityString = EntityUtils.toString(httpEntity);

            JSONParser parser = new JSONParser();
            try {
                JSONObject json = (JSONObject) parser.parse(entityString);
                String surname = (String) json.get("surname");
                String name = (String) json.get("name");
                String lastName = (String) json.get("lastName");
                req.setAttribute("lastName", lastName);
                req.setAttribute("name", name);
                req.setAttribute("surname", surname);
                RequestDispatcher dispatcher = req.getRequestDispatcher("person.jsp");
                dispatcher.forward(req, resp);
            } catch (ParseException | ServletException e) {
                e.printStackTrace();
            }

            return entityString;
        };

        String responseBody = httpClient.execute(get, responseHandler);

        System.out.println("-------------------------------------------");
        System.out.println(responseBody);
        System.out.println("-------------------------------------------");

    }

}
