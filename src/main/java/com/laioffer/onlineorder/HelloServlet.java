package com.laioffer.onlineorder;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import com.laioffer.onlineorder.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void init() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("GET");
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        Customer customer= new Customer();
        customer.setEmail("sun@laioffer.com");
        customer.setPassword("123456");
        customer.setFirstName("rick");
        customer.setLastName("sun");
        customer.setEnabled(true);

        response.getWriter().print(mapper.writeValueAsString(customer));
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = mapper.readValue(IOUtils.toString(req.getReader()), Customer.class);
        System.out.println(customer.getEmail());
        System.out.println(customer.getFirstName());
        System.out.println(customer.getLastName());

        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        resp.getWriter().print(jsonResponse);
    }


    public void destroy() {
    }
}