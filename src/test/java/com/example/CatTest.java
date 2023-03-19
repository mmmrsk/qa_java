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
    Feline feline = new Feline();
    Cat cat = new Cat(feline);
    @Mock
    Animal animal = new Animal();

    @Test
    public void getSoundCatTest () {
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        String expected = "Мяу";
        assertEquals("Введено некорректное значение",expected, actual);
    }

    @Test
    public void getFoodCatTest () throws Exception {
        Mockito.when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = cat.getFood();

        assertEquals("Введено некорректное значение еды для кошки",animal.getFood("Хищник"), actual);
    }
}