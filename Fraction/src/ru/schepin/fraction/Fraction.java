package ru.schepin.fraction;

public class Fraction implements IFraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {

        if (denominator == 0 || numerator == 0) {
            throw new ZeroException("  Какое-то число равно 0!");
        }
        this.numerator = numerator;
        this.denominator = denominator;

    }

    public Fraction plus(Fraction fraction) {
        int newDenominator = findCommonDivisor(this.denominator, fraction.denominator);
        int newNumerator = (this.numerator * (newDenominator / this.denominator) + (fraction.numerator * (newDenominator / fraction.denominator)));
        int greatestCommonDivisor = findGreatestCommonDivisor(newDenominator, newNumerator);


        return new Fraction(newNumerator / greatestCommonDivisor, newDenominator / greatestCommonDivisor);
    }

    public Fraction minus(Fraction fraction) {
        int newDenominator = findCommonDivisor(this.denominator, fraction.denominator);
        int newNumerator = (this.numerator * (newDenominator / this.denominator) - (fraction.numerator * (newDenominator / fraction.denominator)));

        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction fraction) {
        return new Fraction
                (this.numerator * fraction.numerator, this.denominator * fraction.denominator);
    }

    public Fraction divide(Fraction fraction) {
        return new Fraction
                (this.numerator * fraction.denominator, this.denominator * fraction.numerator);
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

    public static int findGreatestCommonDivisor(int a, int b) {

        while (a % b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }

        return b;
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
