package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    Feline feline;

    @Test
    public void getKittensFelineTest(){
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getCountKittensFelineTest(){ assertEquals(2, feline.getKittens(2)); }

    @Test
    public void getFamilyFelineTest(){
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void eatMeatFelineTest() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());

    }


}