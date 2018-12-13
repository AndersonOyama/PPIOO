package colecoes.Entity;

import colecoes.ColecoesServico;
import sun.util.locale.provider.LocaleServiceProviderPool;

public class albumEntity {

    String nomeAlbum;
    int quantFigura = 0;
    
    private static int count = 0;
    public int id = 0;

    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }

    public void setQuantFigura(int quantFigura) {
        this.quantFigura = quantFigura;
    }

    public static void setCount(int count) {
        albumEntity.count = count;
    }
    
    

    public String getNomeAlbum() {
        return nomeAlbum;
    }

    public int getQuantFigura() {
        return quantFigura;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }
    
   

    

    
}
