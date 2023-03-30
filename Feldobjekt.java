 

/**
 * Diese Klasse beschreibt ein Objekt auf dem Spielfeld
 *
 * @author Lina & Strawberry
 * @version 0.0.1
 */
public abstract class Feldobjekt
{
    /**
     * Die X-Position dieses Objektes
     */
    protected int xp;

    /**
     * Die Y-Position dieses Objektes
     */
    protected int yp;


    /**
     * Das zeichen mit dem dieses Objekt dargestellt wird.
     */
    private final char zeichen;

    /**
     * Die Karte, auf der sich dieses Objekt befindet.
     */
    protected final Karte karte;

    /**
     * @param xp Die Initiale X-Koordinate des Objektes
     * @param yp Die Initiale Y-Koordinate des Objektes
     * @param zeichen Das zeichen mit dem dieses Objekt dargestellt wird.
     * @param karte Die Karte, auf der sich dieses Objekt befindet.
     */
    public Feldobjekt(int xp, int yp, char zeichen, Karte karte)
    {
        this.xp = xp;
        this.yp = yp;
        this.zeichen = zeichen;
        this.karte = karte;
    }

    /**
     *  Was soll Passieren, wenn das Objekt getroffen wird?
     * @param schaden Wie viel Schaden macht der Schuss
     */
    public abstract void treffer(int schaden) throws Exception;

    /**
     * Bekomme das Zeichen, mit dem dieses Feldobjekt angezeigt werden soll.
     * @return Das zeichen, für die Anzeige auf dem Spielfeld
     */
    public char getZeichen() {
        return this.zeichen;
    };

    /**
     * Setze die Position des Objektes
     * @param xp Die neue X-Position des Objektes
     * @param yp Die neue Y-Position des Objektes
     */
    public void setPos(int xp, int yp) {
        this.xp = xp;
        this.yp = yp;
    }

    /**
     * Bekomme die X-Position des Objektes
     * @return die X-Position des Objektes
     */
    public int getX() {
        return this.xp;
    }

    /**
     * Bekomme die Y-Position des Objektes
     * @return die Y-Position des Objektes
     */
    public int getY() {
        return this.yp;
    }
}
