package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    List<String> foodForPredator = List.of("Животные", "Птицы", "Рыба");
    @Mock
    Feline feline;

    @Test
    public void getSoundCatTest () {
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        String expected = "Мяу";
        assertEquals("Введено некорректное значение",expected, actual);
    }

    @Test
    public void getFoodCatTest () throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(foodForPredator);
        List<String> actual = cat.getFood();

        assertEquals("Введено некорректное значение еды для кошки",foodForPredator, actual);
    }
}