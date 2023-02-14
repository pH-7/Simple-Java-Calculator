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

import static java.lang.Double.NaN;
import static java.lang.Math.log;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class Calculator {

    public enum BiOperatorModes {
        normal, add, minus, multiply, divide , xpowerofy, div, mod
    }

    public enum MonoOperatorModes {
        square, squareRoot, oneDividedBy, cos, sin, tan ,log , rate, abs
    }

    private Double num1, num2;
    private BiOperatorModes mode = BiOperatorModes.normal;

    private Double calculateBiImpl() {
        if (mode == BiOperatorModes.normal) {
            return num2;
        }
        if (mode == BiOperatorModes.add) {
            if (num2 != 0) {
                return num1 + num2;
            }

            return num1;
        }
        if (mode == BiOperatorModes.minus) {
            return num1 - num2;
        }
        if (mode == BiOperatorModes.multiply) {
            return num1 * num2;
        }
        if (mode == BiOperatorModes.divide) {
            return num1 / num2;
        }
        if (mode == BiOperatorModes.xpowerofy) {
            return pow(num1,num2);
        }
        if (mode == BiOperatorModes.div) {
            if(num1 % 1==0 && num2 % 1==0){ //check if both numbers are integers
                double temp1  = num1;
                double temp2 = num2;
                int numa = (int) temp1;
                int numb = (int) temp2;
                int result = numa/numb;
                return 1.0*result;
            }
            else{
                return NaN;
            }
        }
        if (mode == BiOperatorModes.mod) {
            if(num1 % 1==0 && num2 % 1==0){ //check if both numbers are integers
                double temp1  = num1;
                double temp2 = num2;
                int numa = (int) temp1;
                int numb = (int) temp2;
                int result = numa % numb;
                return 1.0*result;
            }
            else{
                return  NaN;
            }
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
            return num * num;
        }
        if (newMode == MonoOperatorModes.squareRoot) {
            return Math.sqrt(num);
        }
        if (newMode == MonoOperatorModes.oneDividedBy) {
            return 1 / num;
        }
        if (newMode == MonoOperatorModes.cos) {
            double wantedCos;
            wantedCos = Math.cos(num);
            wantedCos= Math.round(wantedCos*10000000.0)/10000000.0; //round to 7th decimal place
            return wantedCos;
        }
        if (newMode == MonoOperatorModes.sin) {
            double wantedSin;
            wantedSin = Math.sin(num);
            wantedSin= Math.round(wantedSin*10000000.0)/10000000.0;
            return wantedSin;
        }
        if (newMode == MonoOperatorModes.tan) {
            if (num == 0 || num % 180 == 0) {
                return 0.0;
            }
            if (num % 90 == 0 && num % 180 != 0) {
                return NaN;
            }
            double wantedTan;
            wantedTan = Math.tan(num);
            wantedTan = Math.round(wantedTan*10000000.0)/10000000.0;
            return wantedTan;
        }
        if (newMode == MonoOperatorModes.log) {
            return log10(num);
        }
        if (newMode == MonoOperatorModes.rate) {
           return num / 100;
        }
        if (newMode == MonoOperatorModes.abs){
            return Math.abs(num);
        }

        // never reach
        throw new Error();
    }

}
