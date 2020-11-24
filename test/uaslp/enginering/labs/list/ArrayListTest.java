package uaslp.enginering.labs.list;

import org.junit.jupiter.api.Test;
import uaslp.enginering.labs.model.Student;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {


    @Test
    public void givenNewList_whenSize_thenZeroIsReturned() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        // When:
        int size = arrayList.size();

        // Then:
        assertEquals(0, size);
    }

    @Test
    public void givenNewList_whenAdd_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student student = new Student("Ivan");

        // When:
        arrayList.add(student);

        // Then:
        assertEquals(1, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
    }

    @Test
    public void givenAListWithNoMoreCapacity_whenAdd_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>(2);

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));


        // When:
        arrayList.add(new Student("Francisco"));

        // Then:
        assertEquals(3, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteFirst_thenElementIsDeleted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When - Then:
        assertThrows(IndexOutOfBoundsException.class,()-> arrayList.delete(0),"El indice no existe");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteLast_thenElementIsDeleted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When - Then:
        assertThrows(IndexOutOfBoundsException.class,()->arrayList.delete(2),"El indice no existe");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteMiddle_thenElementIsDeleted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When - Then:

        assertThrows(IndexOutOfBoundsException.class,()->arrayList.delete(1),"El indice no existe");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteNegative_thenDoesNothing() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When - Then:
        assertThrows(IndexOutOfBoundsException.class,()->arrayList.delete(-1),"El indice no existe");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteOutOfSize_thenDoesNothing() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When - Then:

        assertThrows(IndexOutOfBoundsException.class,()->arrayList.delete(4),"El indice no existe");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtBeginningBefore_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Ivan");
        arrayList.add(reference);
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When - Then:
        assertThrows(NoSuchElementException.class,()->arrayList.insert(reference,new Student("Lupita"),ArrayList.InsertPosition.BEFORE),"El elemento reference no se encuentra");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtEndBefore_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Francisco");

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(reference);

        // When - Then:
        assertThrows(NoSuchElementException.class,()->arrayList.insert(reference,new Student("Lupita"),ArrayList.InsertPosition.BEFORE));
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtMiddleBefore_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Israel");

        arrayList.add(new Student("Ivan"));
        arrayList.add(reference);
        arrayList.add(new Student("Francisco"));

        // When - Then:
        assertThrows(NoSuchElementException.class,()->arrayList.insert(reference, new Student("Lupita"),ArrayList.InsertPosition.BEFORE));
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtBeginningAfter_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Ivan");

        arrayList.add(reference);
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When - Then:
        assertThrows(NoSuchElementException.class,()->arrayList.insert(reference, new Student("LUpita"),ArrayList.InsertPosition.AFTER));
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtEndAfter_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Francisco");

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(reference);

        // When - Then:
        assertThrows(NoSuchElementException.class,()->arrayList.insert(reference, new Student("Lupita"),ArrayList.InsertPosition.AFTER));
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtMiddleAfter_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Israel");

        arrayList.add(new Student("Ivan"));
        arrayList.add(reference);
        arrayList.add(new Student("Francisco"));

        // When - Then:
        assertThrows(NoSuchElementException.class,()->arrayList.insert(reference, new Student("Lupita"),ArrayList.InsertPosition.AFTER));
    }

    @Test
    public void givenEmptyList_whenGetIterator_thenIteratorIsEmpty(){
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        // When:
        ArrayList<Student>.Iterator iterator = arrayList.getIterator();

        // Then:
        assertNotNull(iterator);
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
    }

    @Test
    public void givenListWithOneElement_whenGetIterator_thenIteratorHasOneNext(){
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));

        // When:
        ArrayList<Student>.Iterator iterator = arrayList.getIterator();

        // Then:
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        Student student = iterator.next();
        assertNotNull(student);
        assertEquals("Ivan", student.getName());
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
    }
}
