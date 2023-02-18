package com.vodafone.CarFactoryTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarFactoryTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetCarTypeWithCabrio() {
        String response = restTemplate.getForObject("/carFactory/cabrio", String.class);
        assertEquals("Cabrio Car has produced", response);
    }

    @Test
    public void testGetCarTypeWithSedan() {
        String response = restTemplate.getForObject("/carFactory/sedan", String.class);
        assertEquals("Sedan Car has produced", response);
    }

    @Test
    public void testGetCarTypeWithHatchback() {
        String response = restTemplate.getForObject("/carFactory/hatchback", String.class);
        assertEquals("Hatchback Car has produced", response);
    }

    @Test
    public void testGetCarTypeInvalidType() {
         String  response = restTemplate.getForObject("/carFactory/invalid", String.class);
        assertEquals("Invalid type", response);
    }
}
