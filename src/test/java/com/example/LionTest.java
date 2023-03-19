package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline ;

    @Test
    public void getKittensLionTest() throws Exception {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void exceptionLionTest() throws Exception {

        String sex = "";
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Lion lion = new Lion(sex);
        }, "Exception was expected");

        assertEquals("Используйте допустимые значения пола животного - самец или самка", thrown.getMessage());

    }

    @Test
    public void getFoodLionTest() throws Exception {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

}