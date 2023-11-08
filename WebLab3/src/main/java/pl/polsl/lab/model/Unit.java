/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pl.polsl.lab.model;

public class Unit {

    public enum Type {		// by default extends Enum

        Dodaj("+"),
        Odejmij("-"),
        Mnozenie("*"),
        Dzielenie("/");

        /**
         * Value represents name of type
         */
        private String typeName;

        /**
         * New type constructor
         *
         * @param typeName name of type
         */
        Type(String typeName) {
            this.typeName = typeName;
        }

        /**
         * Method returns one of type parameter.
         *
         * @return typeName parameter
         */
        public String getTypeName() {
            return typeName;
        }
    }
    
    /**
     * Value represents unit name
     */
    private String unitName;
    /**
     * Value represents name of unit we want to transform
     */
    private String basicName;
    /**
     * Value represents action like mul, sub
     */
    private Type action;
    /**
     * Value represents formula to recalculate
     */
    private double formulaToBasic;

    public Unit() {
    }

    public Unit(String unitName, String basicName, Type action, double formulaToBasic) {
        this.unitName = unitName;
        this.basicName = basicName;
        this.action = action;
        this.formulaToBasic = formulaToBasic;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public void setFormulaToBasic(double formulaToBasic) {
        this.formulaToBasic = formulaToBasic;
    }

    public String getUnitName() {
        return unitName;
    }

    public double getFormulaToBasic() {
        return formulaToBasic;
    }

    public void setBasicName(String basicName) {
        this.basicName = basicName;
    }

    public String getBasicName() {
        return basicName;
    }

    public void setAction(Type action) {
        this.action = action;
    }

    public Type getAction() {
        return action;
    }

    public String convertTypeToString(Type type) {
        return switch (type) {
            case Dodaj -> "+";
            case Mnozenie -> "*";
            case Odejmij -> "-";
            default -> ":";
        };
    }
}
