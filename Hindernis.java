 

/**
 * Ein Hindernis auf dem Spielfeld
 *
 * @author Lina & Strawberry
 * @version 0.0.1
 */
public class Hindernis extends Feldobjekt
{
    /**
     * Die Anzahl an Leben, die das Hindernis noch hat.
     * Eine -1 stellt unsterblich dar.
     */
    private int sp;

    /**
     * Konstruiere ein Hindernis
     * @param sp Die Initiale Anzahl an leben des Hindernisses, -1 stellt unsterblich dar.
     * @param xp Die X-Position des Hinternisses
     * @param yp Die Y-Position des Hinternisses
     * @param zeichen Das zeichen, mit dem das Hindernis auf dem Spielfeld angezeigt wird
     * @param karte Die Karte, auf der das Hindernis existiert
     */
    public Hindernis(int sp, int xp, int yp, char zeichen, Karte karte)
    {
        super(xp, yp, zeichen, karte);
        this.sp = sp;
    }

    /**
     * Das Hindernis wird getroffen.
     * @param schaden Wie viel Schaden macht der Schuss
     */
    public void treffer(int schaden) throws Exception {
        // Falls das Objekt -1 Leben hat, ist es unsterblich
        if (sp == -1) return;

        this.sp -= schaden;
        System.out.println("Du hast das Hindernis bei den Koordinaten (" + this.xp + "|" + this.yp + ") getroffen!");
        if (this.sp <= 0) {
            this.karte.removeObject(this.xp, this.yp);
            System.out.println("Du hast das Hindernis bei den Koordinaten (" + this.xp + "|" + this.yp + ") zerstört!");
        }
    }
}
