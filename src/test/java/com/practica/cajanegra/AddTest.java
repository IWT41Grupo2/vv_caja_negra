package com.practica.cajanegra;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.ValueSource;

import com.cajanegra.SingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;

import java.util.NoSuchElementException;


public class AddTest {

    private SingleLinkedListImpl<String> lista;

    @BeforeEach
    public void setUp() {
        lista = new SingleLinkedListImpl<String>("A","B","C", "M", "Y", "Z");
    }

    @ParameterizedTest()
    @ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})
    public void addFirstTest(String s) {
        this.lista.addFirst(s);
        assertEquals("[" + s + ", A, B, C, M, Y, Z]", this.lista.toString());

    }

    @ParameterizedTest()
    @ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})
    public void addLastTest(String s) {
        this.lista.addLast(s);
        assertEquals("[A, B, C, M, Y, Z, " + s + "]", this.lista.toString());

    }

    @Nested
    class addAtPosClass{
        @ParameterizedTest()
        @ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})
        public void addAtPosTestNone(String s){
            assertThrows(IllegalArgumentException.class, () -> { lista.addAtPos(s,0);});
        }

        @ParameterizedTest()
        @ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})
        public void addAtPosTestFirst(String s){
            lista.addAtPos(s, 1);
            assertEquals("[" + s + ", A, B, C, M, Y, Z]", lista.toString());
        }

        @ParameterizedTest()
        @ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})
        public void addAtPosTestMid(String s){
            lista.addAtPos(s, 3);
            assertEquals("[A, B, " + s +", C, M, Y, Z]", lista.toString());
        }

        @ParameterizedTest()
        @ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})
        public void addAtPosTestLast(String s){
            lista.addAtPos(s, 7);
            assertEquals("[A, B, C, M, Y, Z, " + s +"]", lista.toString());
        }

        @ParameterizedTest()
        @ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})
        public void addAtPosTestAfterLast(String s){
            lista.addAtPos(s, 8);
            assertEquals("[A, B, C, M, Y, Z, " + s +"]", lista.toString());
        }
    }

    @Nested
    public class addNTimesClass{
        @ParameterizedTest()
        @ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})
        public void addNTimesSub(String s){
            assertThrows(IllegalArgumentException.class, () -> { lista.addNTimes(s, -1);});
        }

        @ParameterizedTest()
        @ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})
        public void addNTimesNone(String s){
            lista.addNTimes(s, 0);
            assertEquals("[A, B, C, M, Y, Z]", lista.toString());
        }

        @ParameterizedTest()
        @ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})
        public void addNTimesOne(String s){
            lista.addNTimes(s, 1);
            assertEquals("[A, B, C, M, Y, Z, " + s +"]", lista.toString());
        }

        @ParameterizedTest()
        @ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})
        public void addNTimesMul(String s){
            lista.addNTimes(s, 2);
            assertEquals("[A, B, C, M, Y, Z, " + s +", " + s +"]", lista.toString());
        }
    }
}
