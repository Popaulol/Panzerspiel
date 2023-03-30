 

/**
 * Die Hauptklasse des Spiels
 *
 * @author Lina & Strawberry
 * @version 0.0.1
 */

import java.util.Scanner;

public class Spiel
{
    /**
     * Ein Array, das alle Spieler Speichert
     */
    private Panzer[] spieler;

    /**
     * Die Karte, auf der das Spiel Stattfindet
     */
    private Karte karte;

    /**
     * Der Scanner zum verarbeiten der Nutzereingaben
     */
    private final Scanner scanner;

    /**
     * Konstruiere ein neues Spiel, starte dies Aber noch nicht
     */
    public Spiel() {
        scanner = new Scanner(System.in);
    }

    /**
     * Starte das Spiel und lasse es durchlaufen
     */
    public void spielen() throws Exception {
        // Erstelle die Karte
        this.karte = new Karte();
        //this.karte.KarteLaden(1);
       // karte.ausgabe();
        //System.exit(0);

        System.out.print("Welche Karte möchtet ihr: ");
        // Lade die Von den Spielern gewählte Karte
        this.spieler = this.karte.KarteLaden(scanner.nextInt());

        scanner.nextLine(); // Entferne die neue Zeile aus dem Input scanner

        for (Panzer value : this.spieler) {
            System.out.print("Spieler, nenne mir deinen Namen: ");
            value.setName(scanner.nextLine());

            System.out.println(value.getName() + ", dein Panzer ist Panzer: '" + value.getZeichen() + "'");

            System.out.println(value.getName() + ", welchen Panzer willst du spielen? Du hast folgende Optionen:");
            System.out.println("\tID\t| Name\t\t\t\t| Leben\t| Schüsse\t| Schaden\t| Reichweite\t| Bewegungsreichweite");
            System.out.println("\t-------------------------------------------------------------------------------------------------");
            System.out.println("\t 1\t| Tiger H1\t\t\t| 100\t| 10\t\t| 40\t\t| 60\t\t| 12");
            System.out.println("\t 2\t| Semovente 75/32 M41\t\t| 60\t| 5\t\t| 60\t\t| 60\t\t| 7");
            System.out.println("\t 3\t| Type 3 Chi-Nu\t\t\t| 65\t| 7\t\t| 100\t\t| 20\t\t| 12");
            System.out.println("\t 4\t| M41A1 Walker Bulldog\t\t| 50\t| 8\t\t| 30\t\t| 70\t\t| 20");
            System.out.println("\t 5\t| KV-2\t\t\t\t| 175\t| 5\t\t| 90\t\t| 50\t\t| 7");
            System.out.print("Gib die ID von dem Panzer aus der Liste ein, den du spielen möchtest.");
            switch (scanner.nextInt()) {
                case 1:
                    value.setStats(100, 10, 40, 60, 12);
                    break;
                case 2:
                    value.setStats(60, 5, 60, 60, 7);
                    break;
                case 3:
                    value.setStats(65, 7, 100, 20, 12);
                    break;
                case 4:
                    value.setStats(50, 8, 30, 70, 20);
                    break;
                case 5:
                    value.setStats(175, 5, 90, 50, 7);
                    break;
                }
            scanner.nextLine(); // Entferne die neue Zeile aus dem Input scanner
        }
        
        
        for (int i = 1; this.runde(); i++) {
            System.out.println("Runde " + i + ": ");
            this.karte.verifyBord(); // Gehe sicher, dass das Board noch valide ist
        }

        for (Panzer panzer : this.spieler) {
            if (panzer.isLebendig()) {
                System.out.println(panzer.getName() + ", hat gewonnen!");
            }
        }
    }

    /**
     * Kontroliere, ob es einen Gewinner gibt.
     * @return gibt es einen gewinner?
     */
    private boolean gewonnen() {
        int count = 0;
        for (Panzer panzer : this.spieler) {
            if (panzer.isLebendig()) count++;
        }
        return count < 2;
    }

    /**
     * Führe eine einzelne Runde des Spiels durch
     * @return gab es in dieser Runde einen Gewinner?
     */
    private boolean runde() throws Exception {
        for (Panzer panzer : this.spieler) {
            this.zug(panzer);
            if (this.gewonnen()) return false;
        }
        return true;
    }

    /**
     * Führe einen einzelnen Zugs eines Spielers durch
     * @param spieler Der Spieler, der am Zug ist
     */
    public void zug(Panzer spieler) throws Exception {
        this.karte.ausgabe();
        System.out.print(spieler.getName() + ", giv deinen vollständigen Zug ein, du hast folgende mögliche befehle:\n\t'w': Nach oben fahren\n\t'a': Nach links fahren\n\t's': Nach unten fahren\n\t'd': Nach rechts fahren\n\t'q': Nach links drehen\n\t'e': Nach rechts drehen\n\t' ': Schießen\nDein Zug: ");
        spieler.status_ausgeben();
        spieler.zug_durchfuehren(scanner.nextLine());
    }
}
