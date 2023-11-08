/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import pl.polsl.lab.model.Unit;
import pl.polsl.lab.model.UnitList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;



/**
 *
 * Tests for Model
 */
public class ModelTest {

    public ModelTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     *
     * Test checks if elements are good and not going out of range
     */
    @ParameterizedTest
    @CsvSource({"0", "3", "5"})
    public void paramTestElementOfList(int t) {
        UnitList instance = new UnitList();
        instance.startUnits();
        try {
            assertNotNull(instance.elementOfList(t));
        } catch (Exception ex) {
            fail("exeption paramTestElementOfList");
        }
    }

    /**
     * Test of getListOfUnit checks if new list was created and returns
     * reference
     */
    @Test
    public void testGetListOfUnit() {
        System.out.println("getListOfUnit");
        UnitList instance = new UnitList();
        List<Unit> result = instance.getListOfUnit();
        assertEquals(result.isEmpty(), false); //true
    }

    /**
     * Test of elementOfList method, of class Model.
     */
    @ParameterizedTest
    @CsvSource({"0", "2"})
    public void testElementOfList(int t) {
        UnitList instance = new UnitList();
        instance.startUnits();
        try {
            assertNotNull(instance.elementOfList(t));
        } catch (Exception ex) {
            fail("exeption paramTestElementOfList");
        }
    }

    /**
     * Test of addListElem method checks if elem size of list is 1 or 2.
     */
    @Test
    public void testAddListElem() {
        String uName = "";
        String bName = "";
        Double formula = 0.1;
        UnitList instance = new UnitList();
        try {
            for (int i = 0; i < 5; i++) {
                instance.addListElem(uName, bName, Unit.Type.Odejmij, formula);
            }
        assertEquals(instance.listOfUnit.size(), 11);//5
        } catch (Exception ex) {
            fail("exeption testAddListElem");
        }
    }

    /**
     * Test of deleteListElem method cheks if after adding and deleting size()
     * is 0.
     */
    @Test
    public void testDeleteListElem() {
        String uName = "";
        String bName = "";
        Double formula = 0.1;
        UnitList instance = new UnitList();
        try {
            instance.addListElem(uName, bName, Unit.Type.Dodaj, formula);
            instance.deleteListElem(0);
            assertEquals(instance.listOfUnit.size(), 6); //0
        } catch (Exception ex) {
            fail("exeption testDeleteListElem");
        }
    }

    /**
     * Test of findElem method check is after adding it can find it
     */
    @Test
    public void testFindElem() {
        String uName = "";
        String bName = "";
        Double formula = 0.1;
        UnitList instance = new UnitList();
        instance.addListElem(uName, bName, Unit.Type.Odejmij, formula);
        instance.addListElem(uName, bName, Unit.Type.Odejmij, formula);
        instance.addListElem(uName, bName, Unit.Type.Odejmij, formula);
        try {
            instance.findElem(0);
            instance.findElem(1);
            instance.findElem(2);
        } catch (Exception ex) {
            fail("exeption testFindElem");
        }
    }

    /**
     * Test of findElemAndCalculate method, of class Model.
     */
    @Test
    public void testFindElemAndCalculate() {
        Double numberToCalculate = 10.0;
        int listNumber = 0;
        UnitList instance = new UnitList();
        String uName = "";
        String bName = "";
        Double formula = 0.1;
        instance.addListElem(uName, bName, Unit.Type.Mnozenie, formula);
        Double expResult = 1.0;
        try {
            Double result = instance.findElemAndCalculate(numberToCalculate, listNumber);
            assertEquals(expResult, 1.0); //result
        } catch (Exception ex) {
            fail("exeption testFindElem");
        }
    }

}

