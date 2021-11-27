package com.practica.cajanegra;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.ValueSource;

import com.cajanegra.SingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;

import java.util.NoSuchElementException;

public class GetTest {

    private SingleLinkedListImpl<String> lista;

    @BeforeEach
    public void setUp() {
        lista = new SingleLinkedListImpl<String>("A","B","C", "M", "Y", "Z");
    }

    @Nested
    public class getAtPosClass{

        @Test
        void getAtPosTestSub() {
            assertThrows(IllegalArgumentException.class, () -> {lista.getAtPos(-1);});
        }

        @Test
        void getAtPosTestZero() {
            assertThrows(IllegalArgumentException.class, () -> {lista.getAtPos(0);});
        }

        @Test
        public void getAtPosFirst(){
            assertEquals("A" , lista.getAtPos(1));
        }

        @Test
        public void getAtPosMid(){
            assertEquals("C" , lista.getAtPos(3));
        }

        @Test
        public void getAtPosLast(){
            assertEquals("Z" , lista.getAtPos(6));
        }

        @Test
        public void getAtPosSup(){
            assertThrows(IllegalArgumentException.class, () -> {lista.getAtPos(7);});
        }
    }

    @Nested
    public class indexOfClass{

        @Test
        public void indexOfFirst(){
            assertEquals(1 , lista.indexOf("A"));
        }

        @Test
        public void indexOfMid(){
            assertEquals(3 , lista.indexOf("C"));
        }

        @Test
        public void indexOfLast(){
            assertEquals(6 , lista.indexOf("Z"));
        }

        @Test()
        public void indexOfEx(){
            assertThrows(NoSuchElementException.class, () -> { lista.indexOf("H");});
        }
    }

    @Nested
    public class sizeClass{
        @Test
        public void sizeTest(){
            assertEquals(6,lista.size());
        }

        @Test
        public void sizeVacio(){
            lista = new SingleLinkedListImpl<>();
            assertEquals(0,lista.size());
        }
    }

    @Nested
    public class reverseClass{
        @Test
        public void reverseTest(){
            assertAll(
                    () -> assertEquals("[Z, Y, M, C, B, A]",lista.reverse().toString()),
                    () ->assertEquals("[A, B, C, M, Y, Z]", lista.toString())
            );
        }

        @Test
        public void reverseVacio(){
            lista = new SingleLinkedListImpl<>();
            assertAll(
                    () -> assertEquals("[]",lista.reverse().toString()),
                    () ->assertEquals("[]", lista.toString())
            );
        }
    }
}
