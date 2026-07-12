package com.cognizant.spring_learn;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLearnApplication {

    public static void main(String[] args) {
        displayDate();
    }

    public static void displayDate() {

        try {

            ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("date-format.xml");

            SimpleDateFormat format =
                    context.getBean("dateFormat", SimpleDateFormat.class);

            Date date = format.parse("31/12/2018");

            System.out.println(date);

            context.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}