package it.pezzi.aurora;

public class SumMultiple {

    public static void main(String[] args)
    {
        Integer maxval = 10000;
        Integer sumMultiple = 0;
        for(int i=1; i<=maxval; i++){
            if(i%7 == 0 || i%9 == 0){
                sumMultiple += i;
            }
        }

        System.out.println(sumMultiple);

    }
}
