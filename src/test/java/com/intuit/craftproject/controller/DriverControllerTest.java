package com.intuit.craftproject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.intuit.craftproject.exception.AlreadyExistException;
import com.intuit.craftproject.exception.NoSuchDriverException;
import com.intuit.craftproject.model.Driver;
import com.intuit.craftproject.service.IDriverService;

@RunWith(MockitoJUnitRunner.class)
public class DriverControllerTest {

    @Mock
    private IDriverService driverService;

    @InjectMocks
    private DriverController driverController;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this); //without this you will get NPE
    }

    @Test
    public void add_whenEmailAlreadyExists() throws AlreadyExistException {

        Driver driver = new Driver();
        driver.setEmail("dglguru@gmail.com");

        Mockito.when(driverService.save(driver)).thenThrow(new AlreadyExistException("Driver already Exists with this EmailId"));

        Exception exception = assertThrows(AlreadyExistException.class,()->{
            driverController.add(driver);
        });

        assertEquals(exception.getMessage(),"Driver already Exists with this EmailId");
    }

    @Test
    public void add() throws AlreadyExistException {

        Driver driver = new Driver();
        driver.setEmail("dglguru@gmail.com");

        Mockito.when(driverService.save(driver)).thenReturn(driver);

        assertNotNull(driverController.add(driver));
    }

    @Test
    public void get() throws NoSuchDriverException {

        Mockito.when(driverService.get(1)).thenThrow(new NoSuchDriverException("No Driver exist with this id"));

        Exception exception = assertThrows(NoSuchDriverException.class,()->{
            driverController.get(1);
        });

        assertEquals(exception.getMessage(),"No Driver exist with this id");
    }
    
    @Test
    public void getDriver() throws NoSuchDriverException {

    	 Driver driver = new Driver();
    	 driver.setEmail("dglguru@gmail.com");
        Mockito.when(driverService.get(1)).thenReturn(driver);
        Driver controllerDriver = driverController.get(1);
        assertEquals(controllerDriver.getEmail(),"dglguru@gmail.com");

    }

}
