/**
 * @name        Simple Java Calculator
 * @package     ph.calculator
 * @file        Main.java
 * @author      SORIA Pierre-Henry
 * @email       pierrehs@hotmail.com
 * @link        http://github.com/pH-7
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 */

package simplejavacalculator;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Double.NaN;
import static java.lang.Math.log;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class Calculator {

    public enum BiOperatorModes {
        normal, add, minus, multiply, divide , xpowerofy 
    }

    public enum MonoOperatorModes {
        square, squareRoot, oneDividedBy, cos, sin, tan, log, rate, abs, ln,
    }

    private Double num1, num2;
    private BiOperatorModes mode = BiOperatorModes.normal;

    protected final Queue<String> queue = new LinkedList<>();
    public void Make_History(Double num1 , Double num2, String symbol,Double result)
    {
        //Make the line
        String line = String.valueOf(num1) + symbol + String.valueOf(num2) + "=" + result;

        if(queue.size()==20)
            queue.poll();
        else
        {
            queue.add(line);
        }
    }
    public void Make_History(Double num , String symbol, Double result)
    {
        //Make the line
        String line = symbol + String.valueOf(num) + ") =" + result ;

        if(queue.size()==20)
            queue.poll();
        else
            queue.add(line);
    }

    private Double calculateBiImpl() {
        if (mode == BiOperatorModes.normal) {
            return num2;
        }
        if (mode == BiOperatorModes.add) {
            if (num2 != 0) {
                Make_History(num1,num2,"+",num1 + num2);
                return num1 + num2;
            }
            return num1;
        }
        if (mode == BiOperatorModes.minus) {
            Make_History(num1,num2,"-" , num1 - num2);
            return num1 - num2;
        }
        if (mode == BiOperatorModes.multiply) {
            Make_History(num1,num2,"*" , num1 * num2);
            return num1 * num2;
        }
        if (mode == BiOperatorModes.divide) {
            Make_History(num1,num2,"/" , num1 / num2);
            return num1 / num2;
        }
        if (mode == BiOperatorModes.xpowerofy) {
            Make_History(num1,num2,"^" , pow(num1,num2));
            return pow(num1,num2);
        }

        // never reach
        throw new Error();
    }

    public Double calculateBi(BiOperatorModes newMode, Double num) {
        if (mode == BiOperatorModes.normal) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            return NaN;
        } else {
            num2 = num;
            num1 = calculateBiImpl();
            mode = newMode;
            return num1;
        }
    }

    public Double calculateEqual(Double num) {
        return calculateBi(BiOperatorModes.normal, num);
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.normal;

        return NaN;
    }

    
    public Double calculateMono(MonoOperatorModes newMode, Double num) {
        if (newMode == MonoOperatorModes.square) {
            Make_History(num,num,"*",num * num);
            return num * num;
        }
        if (newMode == MonoOperatorModes.squareRoot) {
            Make_History(num,"sqr(",Math.sqrt(num));
            return Math.sqrt(num);
        }
        if (newMode == MonoOperatorModes.oneDividedBy) {
            Make_History(1.0 , num,"/", 1 / num);
            return 1 / num;
        }
        if (newMode == MonoOperatorModes.cos) {
            Make_History(num,"cos(",Math.cos(Math.toRadians(num)));
            return Math.cos(Math.toRadians(num));
        }
        if (newMode == MonoOperatorModes.sin) {
            Make_History(num,"sin(",Math.sin(Math.toRadians(num)));
            return Math.sin(Math.toRadians(num));
        }
        if (newMode == MonoOperatorModes.tan) {
            if (num == 0 || num % 180 == 0) {
                Make_History(num,"tan(",0.0);
                return 0.0;
            }
            if (num % 90 == 0 && num % 180 != 0) {
                Make_History(num,"tan(", NaN);
                return NaN;
            }
            Make_History(num,"tan(",Math.tan(Math.toRadians(num)));
            return Math.tan(Math.toRadians(num));
        }
        if (newMode == MonoOperatorModes.log) {
            Make_History(num,"log10(",log10(num));
            return log10(num);
        }
        if (newMode == MonoOperatorModes.ln) {
            Make_History(num,"log(",log(num));
            return log(num);
        }
        if (newMode == MonoOperatorModes.rate) {
            Make_History(num,100.0,"/",num / 100);
           return num / 100;
        }
        if (newMode == MonoOperatorModes.abs){
            Make_History(num,"abs(",Math.abs(num));
            return Math.abs(num);
        }

        // never reach
        throw new Error();
    }

}
