package oppgave3;

import javax.swing.*;

public class UnikeTall {
    private static int[] slumpTall;
    private final int lengde;

    public UnikeTall(int lengde) {
        this.lengde = lengde;
        slumpTall = new int[lengde];
    }
    public boolean erTallGjentatt(int tall) {
        for(int i = 0; i < slumpTall.length; i++) {
            if (tall == slumpTall[i]) {
                System.out.println(tall + " = " + slumpTall[i]);
                return true;
            }
        }
        return false;
    }
    public void fyllArray() {
        int random = 0;
        for (int i = 0; i < slumpTall.length; i++) {
            random = (int)(Math.random()*(900)+100);
            if (erTallGjentatt(random)) {
                i--;
            } else {
                slumpTall[i] = random;
            }
        }
    }
    public static int getMaxValue(int[] numbers) {
        int maxValue = numbers[0];
        for(int i= 1; i < numbers.length; i++) {
            if(numbers[i]> maxValue) {
                maxValue = numbers[i];
            }
        } return maxValue;
    }
    public static int getMinValue(int[] numbers) {
        int minValue = numbers[0];
        for(int i = 1; i < numbers.length; i++) {
            if(numbers[i] < minValue) {
                minValue = numbers[i];
            }
        } return minValue;
    }
    public static double gjennomsnitt(int[] numbers) {
        int sum = 0;
        for(int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println(sum);
        double gjennomsnitt = (double) sum / numbers.length;
        return gjennomsnitt;
    }
    public void visMelding() {
        String melding = "Tilfeldige tall utvalgte for deg er: ";
        for(int i = 0; i <= slumpTall.length - 1; i++) {
            if(i%8 == 0) {
                melding += "\n";
            }
            melding += slumpTall[i] + " ";
        }
        String meldingMinst= "Minste tall er " + getMinValue(slumpTall);
        String meldingMax= "Største tall er " + getMaxValue(slumpTall);
        String toPlass = String.format("%.2f",gjennomsnitt(slumpTall));
        String meldinggjenom = "Gjennomsnittverdien er " + toPlass;
        String full = melding + "\n\n" + meldingMinst + "\n" + meldingMax + "\n" + meldinggjenom;
        JOptionPane.showMessageDialog(null, full, "Resultat",JOptionPane.INFORMATION_MESSAGE);
    }
}
