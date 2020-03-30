package com.mikhailovskii.lab3;

public class Main {

    private static int[] gcd(int p, int q) {
        if (q == 0)
            return new int[]{1, 0};

        int[] vals = gcd(q, p % q);
        int a = vals[1];
        int b = vals[0] - (p / q) * vals[1];
        return new int[]{a, b};
    }

    public static void main(String[] args) {

        // Encrypt

        int m = 17;
        int p = 11;
        int q = 19;
        int n = p * q;  //open key
        long c = (m * m) % n;
        System.out.println(c);

        // Decrypt

        int mp = (int) (Math.pow(c, (p + 1) / 4) % p);
        int mq = (int) (Math.pow(c, (q + 1) / 4) % q);

        int[] vals = gcd(p, q);
        int yp = vals[0];
        int yq = vals[1];

        System.out.println(yp);
        System.out.println(yq);

        int[] mArr = new int[4];

        mArr[0] = (yp * p * mq + yq * q * mp) % n;
        mArr[1] = (n - mArr[0]);
        mArr[2] = (yp * p * mq - yq * q * mp) % n;
        mArr[3] = n - mArr[2];

        for (int i : mArr) {
            System.out.println(i);
        }

    }

}