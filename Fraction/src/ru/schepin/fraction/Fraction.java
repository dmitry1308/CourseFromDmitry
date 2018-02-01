package ru.schepin.fraction;

public class Fraction implements IFraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {

        if (denominator == 0 || numerator == 0) {
            throw new ZeroException("Какое-то число равно 0!");
        }
        this.numerator = numerator;
        this.denominator = denominator;

    }

    public Fraction plus(Fraction fraction) {
        int newDenominator = findCommonDivisor(this.denominator, fraction.denominator);


        int newNumerator = (this.numerator * (newDenominator / this.denominator) +
                (fraction.numerator * (newDenominator / fraction.denominator)));

        return divisionByCommonFactor(newNumerator, newDenominator,
                findGreatestCommonDivisor(newDenominator, newNumerator));
    }

    public Fraction minus(Fraction fraction) {
        int newDenominator = findCommonDivisor(this.denominator, fraction.denominator);

        int newNumerator = (this.numerator * (newDenominator / this.denominator) -
                (fraction.numerator * (newDenominator / fraction.denominator)));

        if (newNumerator == 0) {
            throw new ZeroException("Результат вычисления = 0");
        }

        return divisionByCommonFactor(newNumerator, newDenominator,
                findGreatestCommonDivisor(newDenominator, newNumerator));
    }

    public Fraction multiply(Fraction fraction) {
        int newNumerator = this.numerator * fraction.numerator;
        int newDenominator = this.denominator * fraction.denominator;

        return divisionByCommonFactor(newNumerator, newDenominator,
                findGreatestCommonDivisor(newDenominator, newNumerator));
    }

    public Fraction divide(Fraction fraction) {
        int newNumerator = this.numerator * fraction.denominator;
        int newDenominator = this.denominator * fraction.numerator;

        return divisionByCommonFactor(newNumerator, newDenominator,
                findGreatestCommonDivisor(newDenominator, newNumerator));
    }

    private static int findCommonDivisor(int a, int b) {
        int max = a > b ? a : b;
        while (true) {
            if (max % a == 0 && max % b == 0) {
                break;
            } else {
                max++;
            }
        }
        return max;
    }

    private static int findGreatestCommonDivisor(int a, int b) {

        while (a % b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }

        return b;
    }

    private Fraction divisionByCommonFactor(int a, int b, int commonDivisor) {
        return new Fraction(a / commonDivisor, b / commonDivisor);
    }


    public String toString() {
        return numerator + "/" + denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
}
