/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.console;

import pl.polsl.lab.model.UnitList;
import pl.polsl.lab.model.Unit.Type;
import java.util.Scanner;

public class Controller {

    /**
     * Value represents object of the UnitList class
     */
    private final UnitList model;

    /**
     * Controller class constructor
     *
     * @param view represents the View class
     * @param model represents the UnitList class
     */
    public Controller(UnitList model) {
        this.model = model;
    }

    /**
     * Method obtains integer parameters from user.
     *
     * @return obtained integer parameter
     */
    public int getIntFromUser() {
        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.next();
        if (intValidation(tmp)) {
            return Integer.parseInt(tmp);
        } else {
            return 0;
        }
    }

    /**
     * Method checks if obtained integer parameters are truly numbers.
     *
     * @param input parameter to be checked
     * @return boolean value of result
     */
    public boolean intValidation(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            //view.printWrongInit();
            return false;
        }
        return true;
    }

    /**
     * Method lets user choose which action the application should do by showing
     * them menu and asking for the number of option.
     */
    public void Menu() {
        Scanner scan = new Scanner(System.in);
        boolean toContinue = true;
        while (toContinue) {
            //view.printMenu();
            int number = getIntFromUser();
            switch (number) {
                case 1:
                    model.writeElementsOfList();
                    break;
                case 2: {
                   /* //view.printUnitName();
                    String uName = scan.nextLine();
                    //view.printAskBaseUnitName();
                    String bName = scan.nextLine();
                    //view.printAskAction();
                    String action = scan.nextLine();
                    //view.printAskFormula();
                    Double aName = scan.nextDouble();
                    model.addListElem(uName, bName, this.actionTypeChecker(action), aName);*/
                    break;
                }
                case 3: {
                    //view.printAskForNumberToCalculate();
                    //Double num = scan.nextDouble();
                    //view.printAskForUnitChoose();
                    //int temp = scan.nextInt();
                    //view.printResultOfCalculation(model.findElemAndCalculate(num, (temp - 1)));
                    break;
                }
                case 4:
                    toContinue = false;
                    break;
                default:
                    //view.printWrongInit();
                    break;
            }
        }
    }

    public Type actionTypeChecker(String s) {
        Type newAction;
        switch (s) {
            case "+": {
               newAction=Type.Dodaj;
               break;
            }
            case "-": {
                 newAction=Type.Odejmij;
                 break;
            }
            case "*": {
                 newAction=Type.Mnozenie;
                 break;
            }
            default:
                 newAction=Type.Dzielenie;
                 break;
        }
        return newAction;
    }
}
