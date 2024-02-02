package training.pp;

import java.util.Random;

public class Training1 {
    public static void main(String[] args) {
        String[] carNames = {"Audi", "BMW", "Mercedes S-Class"};

// Sunt interesat sa stiu daca exista aceste masini in baza de date
// Inca o cerinta este ca numele masinii trebuie sa fie mai mic decat 5 caractere

        for (String carName : carNames) {
            System.out.println();
            if (areMaiPutinDe5Caractere(carName)) {
                if (existaInBazaDeDateAsaMasina(carName)) {
                    System.out.println("Da exista asa masina in baza de date");
                } else {
                    System.out.println("Nu, nu exista asa masina in baza de date");
                }
            }
        }
    }

    /**
     * Avem o baza de date cu 10.000.000 de masini  <br>
     * Verificarea daca exista asa masina in baza de date dureaza 10 secunde
     */
    static boolean existaInBazaDeDateAsaMasina(String carName) {
//    Simulam cautarea in baza de date 10 secunde
        sleep(1000 * 10);
        return new Random().nextBoolean();
    }

    static boolean areMaiPutinDe5Caractere(String carName) {
        return carName.length() > 5;
    }

    private static void sleep(final int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
