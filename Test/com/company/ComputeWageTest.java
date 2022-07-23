package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class ComputeWageTest {


    @Mock
    Compute inte;



    @InjectMocks
    ComputeWage obj;



    @BeforeEach
    public void initeach(){

        MockitoAnnotations.openMocks(this);
        ByteArrayInputStream in = new ByteArrayInputStream("John\n35".getBytes());
        System.setIn(in);
    }


    @Test
    void exception() throws UnsupportedEncodingException {

        ByteArrayInputStream in = new ByteArrayInputStream("John\nxx\n35".getBytes());
        System.setIn(in);

        PrintStream standardOut = System.out;

        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        obj.Acceptdata();

        assertTrue(new String(captor.toByteArray(), "UTF-8").contains("You didn't enter a valid number"));



    }

    @org.junit.jupiter.api.Test
    void acceptdata() {

        obj.Acceptdata();
        assertEquals("John", obj.getName());
        assertEquals(35, obj.getHours());

    }

    @org.junit.jupiter.api.Test
    void computewage() {

        obj = new ComputeWage(inte);


        when(inte.calculate(anyDouble())).thenReturn(577.5);

        obj.Acceptdata();
        obj.Computewage();
        assertEquals(577.5, obj.getGtotal());


    }

    @org.junit.jupiter.api.Test
    void display() {

        obj.Acceptdata();
        obj.Computewage();

        PrintStream standardOut = System.out;

        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        obj.display();

        assertEquals("The total wage of John is 525.0", captor.toString().trim());


    }
}