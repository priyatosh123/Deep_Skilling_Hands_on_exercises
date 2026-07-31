package com.cognizant.ormlearn;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        testFindCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
    }

    private static void testFindCountryByCode() {
        LOGGER.info("Start FindCountryByCode Test");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country fetched: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country Code Exception: ", e);
        }
        LOGGER.info("End FindCountryByCode Test");
    }

    private static void testAddCountry() {
        LOGGER.info("Start AddCountry Test");
        Country newCountry = new Country("ZZ", "TestCountry");
        countryService.addCountry(newCountry);
        try {
            Country verifiedCountry = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Added Country confirmation: {}", verifiedCountry);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found after adding: ", e);
        }
        LOGGER.info("End AddCountry Test");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start UpdateCountry Test");
        try {
            countryService.updateCountry("ZZ", "UpdatedTestCountry");
            Country updatedCountry = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Updated Country confirmation: {}", updatedCountry);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error during updating country context: ", e);
        }
        LOGGER.info("End UpdateCountry Test");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start DeleteCountry Test");
        countryService.deleteCountry("ZZ");
        try {
            countryService.findCountryByCode("ZZ");
            LOGGER.debug("Country 'ZZ' still present in database mapping.");
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Success: Country 'ZZ' successfully removed from persistence tracking storage.");
        }
        LOGGER.info("End DeleteCountry Test");
    }
}