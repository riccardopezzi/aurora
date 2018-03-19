package it.pezzi.aurora;

public class Inverter {

    public static void main(String[] args)
    {
        String toRevert = "Ciao, come stai?";
        String[] toRevertSplit = toRevert.split(" ");

        StringBuilder invert = new StringBuilder();

        for(int i=toRevertSplit.length-1; i>=0; i--){
            invert.append(toRevertSplit[i] + " ");
        }

        System.out.println(invert);

    }
}
