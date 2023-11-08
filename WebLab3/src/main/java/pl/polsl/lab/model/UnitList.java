/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.model;

import pl.polsl.lab.model.Unit;
import java.util.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnitList {

    /**
     * Enumeration type, by default extends Enum
     */

    public final List<Unit> listOfUnit = new ArrayList<>();
    
    /**
     * List of units
     */
    public UnitList() {
        this.startUnits();
    }


    public List<Unit> getListOfUnit() {
        return listOfUnit;
    }

    /**
     * Method is printing elements of list
     */
    public void writeElementsOfList() {
        int i = 0;
        Iterator<Unit> listElementIterator = listOfUnit.iterator();

        while (listElementIterator.hasNext()) {
            int temp = i + 1;
            System.out.print(temp);
            Unit x = listElementIterator.next();
            System.out.print(" " + x.getUnitName() + " " + x.getBasicName() + "\n");
            i++;
        }
    }

    public Unit elementOfList(int num) {
        return listOfUnit.get(num);
    }

    /**
     * Method insert start values
     */
    public void startUnits() {
        listOfUnit.add(new Unit("h", "s", Unit.Type.Mnozenie, (3600)));
        listOfUnit.add(new Unit("h", "min", Unit.Type.Mnozenie, (60)));
        listOfUnit.add(new Unit("km", "m", Unit.Type.Mnozenie, (1000)));
        listOfUnit.add(new Unit("m", "km", Unit.Type.Dzielenie, (1000)));
        listOfUnit.add(new Unit("k", "C", Unit.Type.Odejmij, (272.15)));
        listOfUnit.add(new Unit("C", "K", Unit.Type.Dodaj, (272.15)));
    }

    /**
     * Method is adding element to list
     */
    public void addListElem(String uName, String bName, Unit.Type aName, Double formula) {
        listOfUnit.add(new Unit(uName, bName, aName, formula));
    }

    /**
     * Method is deleting calue from list
     *
     * @param listNumber elem number in list
     */
    public void deleteListElem(int elemNumber) {
        listOfUnit.remove(elemNumber);
    }

    /**
     * Method finds element of list
     *
     * @param listNumber elem number in list
     * @return reference
     */
    public Unit findElem(int listNumber) {
        Unit u = listOfUnit.get(listNumber);
        return u;
    }

    /**
     * Method use findElem and calculating result of program
     *
     * @param numberToCalculate number that will be calculated with formula
     * @param listNumber elem number in list
     * @return score
     */
    public Double findElemAndCalculate(Double numberToCalculate, int listNumber) {
        Unit u = listOfUnit.get(listNumber);
        if (null == u.getAction()) {
            return 2137.666;
        } else {
            switch (u.getAction()) {
                case Dodaj:
                    return ((u.getFormulaToBasic()) + (numberToCalculate));
                case Mnozenie:
                    return ((u.getFormulaToBasic()) * (numberToCalculate));
                case Odejmij:
                    return ((numberToCalculate) - (u.getFormulaToBasic()));
                default:
                    return (((numberToCalculate / u.getFormulaToBasic())));
            }
        }
    }
}
