package it.pezzi.aurora;


import org.springframework.util.StringUtils;

import java.math.BigInteger;

public class Converter {

    public static void main(String[] args)
    {
        BigInteger dec = new BigInteger("938571980750874560846238947123908412358019875");
        BigInteger min = new BigInteger("0");
        BigInteger divideby = new BigInteger("2");
        BigInteger resto;

        String bin = "";

        while (dec.compareTo(min) > 0){
            resto = dec.mod( divideby );
            bin = resto.toString() + bin;
            dec = dec.divide(divideby);
        }

        System.out.println(bin);
        System.out.println(StringUtils.countOccurrencesOf(bin, "1"));
    }
}
