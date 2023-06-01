package brian.Practico4;

public class PosicionMatriz {
    
    private int valorNatural;
    private boolean norte;
    private boolean sur;
    private boolean este;
    private boolean oeste;

    public PosicionMatriz(int valorNatural,boolean n,boolean s,boolean e,boolean o) {
        this.valorNatural=valorNatural;
        this.norte=n;
        this.sur=s;
        this.este=e;
        this.oeste=o;
    }
}
