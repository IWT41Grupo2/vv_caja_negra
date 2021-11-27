package com.practica.cajanegra;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.ValueSource;

import com.cajanegra.SingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;

import java.util.NoSuchElementException;

public class CheckTest {

    private SingleLinkedListImpl<String> lista;

    @BeforeEach
    public void setUp() {
        lista = new SingleLinkedListImpl<String>("A","B","C", "M", "Y", "Z");
    }

    @Nested
    class isEmptyTest {

        @Test
        void isEmptyTestNotEmpty() {
            assertEquals(false, lista.isEmpty());
        }

        @Test
        void isEmptyTestEmpty() {
            SingleLinkedListImpl<String> listaVacia = new SingleLinkedListImpl<>();
            assertEquals(true, listaVacia.isEmpty());
        }

    }

    @Nested
    public class isSubListClass {

        SingleLinkedListImpl<String> l;

        @Test
        public void isSubListFalse() {
            l = new SingleLinkedListImpl<>("H");
            assertEquals(-1, lista.isSubList(l));
        }

        @Test
        public void isSubListTrueFirst() {
            l = new SingleLinkedListImpl<>("A", "B");
            assertEquals(1, lista.isSubList(l));
        }

        @Test
        public void isSubListTrueMid() {
            l = new SingleLinkedListImpl<>("B");
            assertEquals(2, lista.isSubList(l));
        }
    }

}
