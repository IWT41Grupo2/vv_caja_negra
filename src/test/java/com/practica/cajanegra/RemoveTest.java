package com.practica.cajanegra;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.ValueSource;

import com.cajanegra.SingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;

import java.util.NoSuchElementException;

public class RemoveTest {

    private SingleLinkedListImpl<String> lista;

    @BeforeEach
    public void setUp() {
        lista = new SingleLinkedListImpl<String>("A","B","C", "M", "Y", "Z");
    }

    @Nested
    public class removeLastClass{

        @Test
        public void removeLastSingle() throws EmptyCollectionException {
            assertEquals("Y", lista.removeLast("Y"));
        }

        @Test
        public void removeLastMultiple() throws EmptyCollectionException {
            SingleLinkedListImpl<Object> listaRepetidos = new SingleLinkedListImpl<> ("C", "A", "B", "C", "M", "X", "Y", "C", "Z");
            Object expected = new String ("C");
            assertEquals(expected.toString(), listaRepetidos.removeLast("C").toString());
        }

        @Test
        public void removeLastTest() throws EmptyCollectionException {
            assertEquals("Z", lista.removeLast());
        }

        @Test
        public void removeLastEx() throws EmptyCollectionException {
            lista = new SingleLinkedListImpl<>();
            assertThrows(EmptyCollectionException.class, () -> { lista.removeLast();});
        }
    }

}
