 

/**
 * Ein Panzer im Spiel
 *
 * @author Lina & Strawberry
 * @version 0.0.1
 */
public class Panzer extends Feldobjekt
{
    /**
     * Der Name des Spielers
     */
    private String name;

    /**
     * Die Anzahl der Leben
     */
    private int kp;

    /**
     * Die Anzahl an Schüsse, die der Panzer verbleiben hat
     */
    private int schuesse;

    /**
     * Der Schaden, den der Panzer macht
     */
    private int schaden;

    /**
     * Die Reichweite, die die Schüsse des Panzers haben
     */
    private int schuss_reichweite;

    /**
     * Die Anzahl an Bewegungen, die der Panzer pro Zug durchführen kann
     */
    private int bewegungs_reichweite;

    /**
     * Ist der Panzer noch Lebendig?
     */
    private boolean lebendig = true;

    /**
     * Die Aktuelle Blickrichtung des Panzers
     */
    private Richtung blick_richtung;

    /**
     * Konstruiere einen neuen Panzer
     * @param blick_richtung Die Initiale Blickrichtung
     * @param xp Die X-Startposition des Panzers
     * @param yp Die Y-Startposition des Panzers
     * @param zeichen Das zeichen, mit dem der Panzer auf dem Spielfeld angezeigt wird
     * @param karte Die Karte des Spiels
     */
    public Panzer(Richtung blick_richtung, int xp, int yp, char zeichen, Karte karte) {
        super(xp, yp, zeichen, karte);
        this.blick_richtung = blick_richtung;
    }

    /**
     * Setze die Statistiken des Panzers
     * @param kp Die Anzahl an Leben, die der Panzer am Anfang besitzt
     * @param schuesse Die Anzahl an Schüssen, die der Panzer am Anfang besitzt
     * @param schaden Der Schaden, den der Panzer macht
     * @param schuss_reichweite Die Reichweite, die der Panzer schießen kann
     * @param bewegungs_reichweite Die Recihweite, die der Panzer sich bewegen kann
     */
    public void setStats(int kp, int schuesse, int schaden, int schuss_reichweite, int bewegungs_reichweite) {
        this.kp = kp;
        this.schuesse = schuesse;
        this.schaden = schaden;
        this.schuss_reichweite = schuss_reichweite;
        this.bewegungs_reichweite = bewegungs_reichweite;
    }

    /**
     * Der Name des Spielers
     * @return Der Name des Spielers
     */
    public String getName() {
        return this.name;
    }

    /**
     * Führe einen Zug mit diesem Panzer durch
     * @param zug Die einzelnen Aktionen des Zuges in einem String
     */
    public void zug_durchfuehren(String zug) throws Exception {
        boolean hasShot = false;
        int bewegungszahl = this.bewegungs_reichweite;
        for (int i = 0; i < zug.length(); i++) {
            switch (zug.charAt(i)) {
                // Bewegung nach Oben
                case 'w': 
                    if (bewegungszahl == 0) {
                        System.out.println("Du darfst dich nur " + this.bewegungs_reichweite + " Felder pro Runde bewegen!");
                        return;
                    }
                    this.drehen(Richtung.OBEN);
                    if (!this.bewegen()) {
                        System.out.println("Du bist in eine Wand gefahren.");
                        return;
                    }
                    bewegungszahl -= 1;
                    break;
                // Bewegung nach Links
                case 'a':
                    if (bewegungszahl == 0) {
                        System.out.println("Du darfst dich nur " + this.bewegungs_reichweite + " Felder pro Runde bewegen!");
                        return;
                    }
                    this.drehen(Richtung.LINKS);
                    if (!this.bewegen()) {
                        System.out.println("Du bist in eine Wand gelaufen.");
                        return;
                    }
                    bewegungszahl -= 1;
                    break;
                
                // Bewegung nach Unten
                case 's':
                    if (bewegungszahl == 0) {
                        System.out.println("Du darfst dich nur " + this.bewegungs_reichweite + " Felder pro Runde bewegen!");
                        return;
                    }
                    this.drehen(Richtung.UNTEN);
                    if (!this.bewegen()) {
                        System.out.println("Du bist in eine Wand gelaufen.");
                        return;
                    }
                    bewegungszahl -= 1;
                    break;
                
                // Bewegung nach Rechts
                case 'd':
                    if (bewegungszahl == 0) {
                        System.out.println("Du darfst dich nur " + this.bewegungs_reichweite + " Felder pro Runde bewegen!");
                        return;
                    }
                    this.drehen(Richtung.RECHTS);
                    if (!this.bewegen()) {
                        System.out.println("Du bist in eine Wand gelaufen.");
                        return;
                    }
                    bewegungszahl -= 1;
                    break;
                // Drehung nach Links
                case 'q':
                    if (bewegungszahl == 0) {
                        System.out.println("Du darfst dich nur " + this.bewegungs_reichweite + " Felder pro Runde bewegen!");
                        return;
                    }
                    bewegungszahl -= 1;
                    switch (this.blick_richtung) {
                        case OBEN :this.drehen(Richtung.LINKS);break;
                        case UNTEN : this.drehen(Richtung.RECHTS);break;
                        case LINKS : this.drehen(Richtung.UNTEN);break;
                        case RECHTS : this.drehen(Richtung.OBEN);break;
                    }
                    break;
                
                // Drehung nach Rechts
                case 'e' :
                    if (bewegungszahl == 0) {
                        System.out.println("Du darfst dich nur " + this.bewegungs_reichweite + " Felder pro Runde bewegen!");
                        return;
                    }
                    bewegungszahl -= 1;
                    switch (this.blick_richtung) {
                        case OBEN : this.drehen(Richtung.RECHTS); break;
                        case UNTEN : this.drehen(Richtung.LINKS); break;
                        case LINKS : this.drehen(Richtung.OBEN); break;
                        case RECHTS : this.drehen(Richtung.UNTEN); break;
                    }
                    break;
                
                // Schießen
                case ' ' :
                    if (hasShot) {
                        System.out.println("Du darfst nur einmal pro Runde schießen!");
                        return;
                    }
                    if (this.schuesse == 0) {
                        System.out.println("Du hast keine Munition mehr!");
                        return;
                    }
                    hasShot = true;
                    this.schuesse--;
                    this.schiessen();
                    break;
            }
        }
    }

    /**
     * Drehe den Panzer in eine bestimmte Richtung
     * @param richtung die neue Blickrichtung des Panzers
     */
    private void drehen(Richtung richtung) {
        this.blick_richtung = richtung;
    }

    /**
     * Führe einen Schuss mit dem Panzer durch
     */
    private void schiessen() throws Exception {
        int current_x = this.xp;
        int current_y = this.yp;
        int reichweite = this.schuss_reichweite;
        switch (this.blick_richtung) {
            // schuss nach Oben
            case OBEN:
                while (reichweite > 0) {
                    current_y -= 1;
                    reichweite -= 1;
                    if (!this.karte.zugcheck(current_x, current_y)) {
                        this.karte.getPos(current_x, current_y).treffer(this.schaden);
                        break;
                    }
                }
                break;
            
            // schuss nach Unten
            case UNTEN :
                while (reichweite > 0) {
                    current_y += 1;
                    reichweite -= 1;
                    if (!this.karte.zugcheck(current_x, current_y)) {
                        this.karte.getPos(current_x, current_y).treffer(this.schaden);
                        break;
                    }
                }
                break;
            
            // schuss nach Links
            case LINKS :
                while (reichweite > 0) {
                    current_x -= 1;
                    reichweite -= 1;
                    if (!this.karte.zugcheck(current_x, current_y)) {
                        this.karte.getPos(current_x, current_y).treffer(this.schaden);
                        break;
                    }
                }
                break;
            // schuss nach Rechts
            case RECHTS : 
                while (reichweite > 0) {
                    current_x += 1;
                    reichweite -= 1;
                    if (!this.karte.zugcheck(current_x, current_y)) {
                        this.karte.getPos(current_x, current_y).treffer(this.schaden);
                        break;
                    }
                }
                break;
        }
    }

    /**
     * Bewege den Panzer ein Feld nach vorne
     * @return Wurde der zug valide durchgeführt
     */
    private boolean bewegen() throws Exception {
        int move_x = this.xp;
        int move_y = this.yp;

        switch (this.blick_richtung) {
            case OBEN : move_y -= 1; break;
            case UNTEN : move_y += 1; break;
            case LINKS : move_x -= 1; break;
            case RECHTS : move_x += 1; break;
        }
        
        if (karte.zugcheck(move_x, move_y)) {
            this.karte.moveObject(this.xp, this.yp, move_x, move_y);
            return true;
        }
        else return false;
    }

    /**
     * Gebe den aktuellen Status des Panzers aus
     */
    public void status_ausgeben() {
        System.out.print(this.name + ": Dein Panzer hat noch:\n\t" + this.kp + " Lebenspunkte\n\t" + this.schuesse + " Verbleibende Schüsse\n\tund schaut nach ");
        switch (this.blick_richtung) {
            case OBEN : System.out.println("Oben"); break;
            case UNTEN : System.out.println("Unten"); break;
            case LINKS : System.out.println("Links"); break;
            case RECHTS : System.out.println("Rechts"); break;
        }
    }

    /**
     * Der Panzer wird getroffen
     * @param schaden Wie viel Schaden macht der Schuss
     */
    public void treffer(int schaden) throws Exception {
        this.kp -= schaden;
        
        System.out.println(this.name + " wurde getroffen.");
        
        if (this.kp <= 0) {
            System.out.println(this.name + " ist gestorben.");
            this.karte.removeObject(this.xp, this.yp);
            this.lebendig = false;
        }
    }

    /**
     * Ist der noch Panzer lebendig?
     * @return Ist der Panzer lebendig
     */
    public boolean isLebendig() {
        return this.lebendig;
    }

    /**
     * Bekomme den Namen des Spielers
     * @param name der Name des Spielers
     */
    public void setName(String name) {
        this.name = name;
    }
}
