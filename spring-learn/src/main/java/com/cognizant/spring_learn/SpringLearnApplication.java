package com.cognizant.spring_learn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) throws Exception {

        SpringApplication app = new SpringApplication(SpringLearnApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);

        displayDate();
        displayCountry();
        displayCountries();
    }

    public static void displayDate() throws Exception {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("date-format.xml");

        SimpleDateFormat format =
                context.getBean("dateFormat", SimpleDateFormat.class);

        Date date = format.parse("31/12/2018");

        LOGGER.debug("Date : {}", date);

        ((ClassPathXmlApplicationContext) context).close();

        LOGGER.info("END");
    }

    public static void displayCountry() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        Country country = context.getBean("in", Country.class);
        Country anotherCountry = context.getBean("in", Country.class);

        LOGGER.debug("Country : {}", country);
        LOGGER.debug("Another Country : {}", anotherCountry);

        ((ClassPathXmlApplicationContext) context).close();

        LOGGER.info("END");
    }

    @SuppressWarnings("unchecked")
    public static void displayCountries() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        ArrayList<Country> countryList =
                (ArrayList<Country>) context.getBean("countryList");

        LOGGER.debug("Countries : {}", countryList);

        ((ClassPathXmlApplicationContext) context).close();

        LOGGER.info("END");
    }
}