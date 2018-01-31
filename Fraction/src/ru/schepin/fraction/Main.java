package ru.schepin.fraction;

public class Main {
    public static boolean assertNotNull(Fraction fraction) {
        return fraction.getDenominator() != 0;
    }

    public static boolean assertEquals(int a, int b) {
        return a == b;
    }


    public static void main(String[] args) {
        Fraction f1 = new Fraction(2, 6);
        Fraction f2 = new Fraction(4, 12);
        Fraction res = f1.plus(f2);
        System.out.println(res);

        Fraction res1 = f1.minus(f2);
        System.out.println(res1);


        assertNotNull(res);
        assertEquals(2, res.getNumerator());
        assertEquals(3, res.getDenominator());
    }
}
