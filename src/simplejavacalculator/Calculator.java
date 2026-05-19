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
        normal {
            public Double apply(Double n1, Double n2) { return n2; }
        },
        add {
            public Double apply(Double n1, Double n2) { return n1 + n2; }
        },
        minus {
            public Double apply(Double n1, Double n2) { return n1 - n2; }
        },
        multiply {
            public Double apply(Double n1, Double n2) { return n1 * n2; }
        },
        divide {
            public Double apply(Double n1, Double n2) { return n1 / n2; }
        },
        xpowerofy {
            public Double apply(Double n1, Double n2) { return pow(n1, n2); }
        };

        public abstract Double apply(Double num1, Double num2);
    }

    public enum MonoOperatorModes {
        square {
            public Double apply(Double n) { return n * n; }
        },
        squareRoot {
            public Double apply(Double n) { return Math.sqrt(n); }
        },
        oneDividedBy {
            public Double apply(Double n) { return 1 / n; }
        },
        cos {
            public Double apply(Double n) { return Math.cos(Math.toRadians(n)); }
        },
        sin {
            public Double apply(Double n) { return Math.sin(Math.toRadians(n)); }
        },
        tan {
            public Double apply(Double n) {
                if (n == 0 || n % 180 == 0) return 0.0;
                if (n % 90 == 0) return NaN;
                return Math.tan(Math.toRadians(n));
            }
        },
        log {
            public Double apply(Double n) { return log10(n); }
        },
        ln {
            public Double apply(Double n) { return log(n); }
        },
        rate {
            public Double apply(Double n) { return n / 100; }
        },
        abs {
            public Double apply(Double n) { return Math.abs(n); }
        };

        public abstract Double apply(Double num);
    }

    private Double num1, num2;
    private BiOperatorModes mode = BiOperatorModes.normal;

    private Double calculateBiImpl() {
        return mode.apply(num1, num2);
    }

    public Double calculateBi(BiOperatorModes newMode, Double num) {
        if (mode.equals(BiOperatorModes.normal)) {
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
        return newMode.apply(num);
    }
}
