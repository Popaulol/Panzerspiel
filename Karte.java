 

import java.util.ArrayList;

/**
 * Die Karte des Spiels
 *
 * @author Lina & Strawberry
 * @version 0.0.1
 */
public class Karte
{
    /**
     * Das 2 Dimensionale Array, dass das Spielfeld speichert
     */
    private ArrayList<ArrayList<Feldobjekt>> objekte;

    /**
     * Konstruktor für die Karte
     */
    public Karte() {}

    /**
     * Initialisiere das Board mit null Werten und baue den Rand auf
     * @param x_size Die X-Größe des Boards
     * @param y_size Die Y-Größe des Boards
     */
    private void init_board(int x_size, int y_size) {
        this.objekte = new ArrayList<>();
        for (int y = 0; y < y_size; y++ ) {
            this.objekte.add(new ArrayList<>());
            for (int x = 0; x < x_size; x++) {
                if (y == 0 || y == (y_size -1 ) || x == 0 || x == (x_size -1 ))
                    this.objekte.get(y).add(new Hindernis(-1, x, y, '#', this));
                else this.objekte.get(y).add(null);
            }
        }
    }

    /**
     * Lade eine bestimmte Karte
     * @param id Die id der Karte, die geladen werden soll
     * @return Die Panzer, die sich auf der Karte befinden
     */
    public Panzer[] KarteLaden(int id) {
        switch (id) {
            case 1:
                Panzer panzer1 = new Panzer(Richtung.RECHTS, 4, 4, 'A', this);
                Panzer panzer2 =  new Panzer(Richtung.LINKS, 45, 5, 'B', this);
                Panzer[] panzer = {panzer1, panzer2};
                this.init_board(50, 10);
                

                this.setPos(4, 4, panzer1);
                this.setPos(45, 5, panzer2);

                this.setPos(3, 5, new Hindernis(10, 3, 5, '%', this));
                this.setPos(3, 6, new Hindernis(10, 3, 6, '%', this));
                this.setPos(3, 7, new Hindernis(10, 3, 7, '%', this));
                this.setPos(4, 7, new Hindernis(10, 4, 7, '%', this));
                this.setPos(5, 7, new Hindernis(10, 5, 7, '%', this));

                this.setPos(8, 3, new Hindernis(50, 8, 3, '%', this));
                this.setPos(8, 4, new Hindernis(50, 8, 4, '%', this));
                this.setPos(9, 3, new Hindernis(50, 9, 3, '%', this));
                this.setPos(9, 4, new Hindernis(50, 9, 4, '%', this));

                this.setPos(12, 7, new Hindernis(-1, 12, 7, '#', this));
                this.setPos(12, 8, new Hindernis(-1, 12, 8, '#', this));
                this.setPos(13, 7, new Hindernis(-1, 13, 7, '#', this));
                this.setPos(13, 8, new Hindernis(-1, 13, 8, '#', this));
                this.setPos(12, 6, new Hindernis(10, 12, 6, '%', this));
                this.setPos(13, 6, new Hindernis(10, 13, 6, '%', this));

                this.setPos(13, 1, new Hindernis(50, 13, 1, '%', this));
                this.setPos(13, 2, new Hindernis(50, 13, 2, '%', this));

                this.setPos(16, 3, new Hindernis(-1, 16, 3, '#', this));
                this.setPos(16, 4, new Hindernis(-1, 16, 4, '#', this));
                this.setPos(16, 5, new Hindernis(-1, 16, 5, '#', this));
                this.setPos(16, 6, new Hindernis(20, 16, 6, '%', this));

                this.setPos(21, 4, new Hindernis(25, 21, 4, '%', this));
                this.setPos(21, 5, new Hindernis(25, 21, 5, '%', this));

                this.setPos(22, 3, new Hindernis(25, 22, 3, '%', this));
                this.setPos(22, 4, new Hindernis(50, 22, 4, '%', this));
                this.setPos(22, 5, new Hindernis(50, 22, 5, '%', this));
                this.setPos(22, 6, new Hindernis(25, 22, 6, '%', this));

                this.setPos(23, 2, new Hindernis(25, 23, 2, '%', this));
                this.setPos(23, 3, new Hindernis(50, 23, 3, '%', this));
                this.setPos(23, 4, new Hindernis(100, 23, 4, '%', this));
                this.setPos(23, 5, new Hindernis(100, 23, 5, '%', this));
                this.setPos(23, 6, new Hindernis(50, 23, 6, '%', this));
                this.setPos(23, 7, new Hindernis(25, 23, 7, '%', this));

                this.setPos(24, 1, new Hindernis(25, 24, 1, '%', this));
                this.setPos(24, 2, new Hindernis(50, 24, 2, '%', this));
                this.setPos(24, 3, new Hindernis(100, 24, 3, '%', this));
                this.setPos(24, 4, new Hindernis(-1, 24, 4, '#', this));
                this.setPos(24, 5, new Hindernis(-1, 24, 5, '#', this));
                this.setPos(24, 6, new Hindernis(100, 24, 6, '%', this));
                this.setPos(24, 7, new Hindernis(50, 24, 7, '%', this));
                this.setPos(24, 8, new Hindernis(25, 24, 8, '%', this));

                this.setPos(25, 1, new Hindernis(25, 25, 1, '%', this));
                this.setPos(25, 2, new Hindernis(50, 25, 2, '%', this));
                this.setPos(25, 3, new Hindernis(100, 25, 3, '%', this));
                this.setPos(25, 4, new Hindernis(-1, 25, 4, '#', this));
                this.setPos(25, 5, new Hindernis(-1, 25, 5, '#', this));
                this.setPos(25, 6, new Hindernis(100, 25, 6, '%', this));
                this.setPos(25, 7, new Hindernis(50, 25, 7, '%', this));
                this.setPos(25, 8, new Hindernis(25, 25, 8, '%', this));

                this.setPos(26, 2, new Hindernis(25, 26, 2, '%', this));
                this.setPos(26, 3, new Hindernis(50, 26, 3, '%', this));
                this.setPos(26, 4, new Hindernis(100, 26, 4, '%', this));
                this.setPos(26, 5, new Hindernis(100, 26, 5, '%', this));
                this.setPos(26, 6, new Hindernis(50, 26, 6, '%', this));
                this.setPos(26, 7, new Hindernis(25, 26, 7, '%', this));

                this.setPos(27, 3, new Hindernis(25, 27, 3, '%', this));
                this.setPos(27, 4, new Hindernis(50, 27, 4, '%', this));
                this.setPos(27, 5, new Hindernis(50, 27, 5, '%', this));
                this.setPos(27, 6, new Hindernis(25, 27, 6, '%', this));

                this.setPos(28, 4, new Hindernis(25, 28, 4, '%', this));
                this.setPos(28, 5, new Hindernis(25, 28, 5, '%', this));

                this.setPos(33, 3, new Hindernis(20, 33, 3, '%', this));
                this.setPos(33, 4, new Hindernis(-1, 33, 4, '#', this));
                this.setPos(33, 5, new Hindernis(-1, 33, 5, '#', this));
                this.setPos(33, 6, new Hindernis(-1, 33, 6, '#', this));

                this.setPos(36, 7, new Hindernis(50, 36, 7, '%', this));
                this.setPos(36, 8, new Hindernis(50, 36, 8, '%', this));

                this.setPos(36, 1, new Hindernis(-1, 36, 1, '#', this));
                this.setPos(36, 2, new Hindernis(-1, 36, 2, '#', this));
                this.setPos(37, 1, new Hindernis(-1, 37, 1, '#', this));
                this.setPos(37, 2, new Hindernis(-1, 37, 2, '#', this));
                this.setPos(36, 3, new Hindernis(10, 36, 3, '%', this));
                this.setPos(37, 3, new Hindernis(10, 37, 3, '%', this));

                this.setPos(40, 5, new Hindernis(50, 40, 5, '%', this));
                this.setPos(40, 6, new Hindernis(50, 40, 6, '%', this));
                this.setPos(41, 5, new Hindernis(50, 41, 5, '%', this));
                this.setPos(41, 6, new Hindernis(50, 41, 6, '%', this));

                this.setPos(46, 4, new Hindernis(10, 46, 4, '%', this));
                this.setPos(46, 3, new Hindernis(10, 46, 3, '%', this));
                this.setPos(46, 2, new Hindernis(10, 46, 2, '%', this));
                this.setPos(45, 2, new Hindernis(10, 45, 2, '%', this));
                this.setPos(44, 2, new Hindernis(10, 44, 2, '%', this));

                this.verifyBord();
                return panzer;
        }
        return null;
    }
    
    /**
     * Verifiziere, dass die Koordinaten der Objekte, mit den Koordinaten in objekte übereinstimmt.
     */
    public void verifyBord() {
        for (int y = 0; y < this.objekte.size(); y++) {
            for (int x = 0; x < this.objekte.get(y).size(); x++) {
                if (this.getPos(x, y) == null) continue;
                if(this.getPos(x, y).getX() != x || this.getPos(x, y).getY() != y) {
                    System.out.println("Coodinate Missmatch at " + x + ", " + y + " got " + this.getPos(x, y).getX() + ", " + this.getPos(x, y).getY() + " instead!");
                }
            }

        }
    }

    /**
     * Bekomme das Objekt an den Koordinaten xp, yp
     * @param xp Die X-Position des Objektes
     * @param yp Die Y-Position des Objektes
     * @return Das Objekt an den Koordinaten (xp, yp)
     */
    public Feldobjekt getPos(int xp, int yp) {
        return this.objekte.get(yp).get(xp);
    }

    /**
     * Setze das Objekt an den Koordinaten (xp, yp)
     * @param xp Die X-Position für das Objekt
     * @param yp Die Y-Position für das Objekt
     * @param obj Das Objekt, das eingesetzt wird
     */
    public void setPos(int xp, int yp, Feldobjekt obj) {
        this.objekte.get(yp).set(xp, obj);
    }

    /**
     * Kontrolliere, ob ein zug zu (xp, yp) legal währe
     * @param xp Die X-Position für den Zug
     * @param yp Die Y-Position für den Zug
     * @return Ist der Zug valide?
     */
    public boolean zugcheck(int xp, int yp) {
        // Falls der Wert an der Zielposition null ist, dann ist das Feld leer.
        return getPos(xp, yp) == null;
    }

    /**
     * Gebe das aktuelle Spielfeld auf die Konsole aus.
     */
    public void ausgabe() {
        for (int y = 0; y < this.objekte.size(); y++) {
            if (y % 2 == 0 && y < 10) System.out.print(" " + y);
                else if (y % 2 == 0 && y >= 10) System.out.print(y);
                else System.out.print("  ");
            for (int x = 0; x < this.objekte.get(0).size(); x++) {
                if (this.getPos(x, y) == null) {
                    System.out.print(' ');
                    continue;
                }
                System.out.print(this.getPos(x, y).getZeichen());
            }
            System.out.println();
        }
    }

    /**
     * Bewege ein Objekt von (from_xp, from_yp) nach (to_xp, to_yp).
     * @param from_xp Die X-Koordinate von der das Objekt bewegt werden soll
     * @param from_yp Die Y-Koordinate von der das Objekt bewegt werden soll
     * @param to_xp Die X-Koordinate auf die das Objekt bewegt werden soll
     * @param to_yp Die Y-Koordinate auf die das Objekt bewegt werden soll
     * @throws Exception Falls ein Invalider Zug gemacht wird, wird eine Exception geworfen
     */
    public void moveObject(int from_xp, int from_yp, int to_xp, int to_yp) throws Exception {
        Feldobjekt obj = this.getPos(from_xp, from_yp);
        if (obj == null) {
            throw new Exception("Move from an Empty Space: (" + from_xp + ", " + from_yp + ")");
        }
        if (this.getPos(to_xp, to_yp) != null) {
            throw new Exception("Move to a non Empty Space: (" + from_xp + ", " + from_yp + ")");
        }

        obj.setPos(to_xp, to_yp);
        this.setPos(to_xp, to_yp, obj);
        removeObject(from_xp, from_yp);
    }

    /**
     * Entferne das objekt bei (xp, yp)
     * @param xp Die X-Koordinate des zu löschenden Objektes
     * @param yp Die Y-Koordinate des zu löschenden Objektes
     * @throws Exception Falls ein nicht existierendes Objekt gelöscht wird, wird eine Exception geworfen
     */
    public void removeObject(int xp, int yp) throws Exception {
        if (this.getPos(xp, yp) == null) {
            throw new Exception("Trying to remove an already empty Space!");
        }
        
        this.setPos(xp, yp, null);
    }
}
