package colecoes.Entity;

import colecoes.ColecoesServico;
import sun.util.locale.provider.LocaleServiceProviderPool;

public class albumEntity {
    
    
    String nomeAlbum;
    int quantFigura = 0;

    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }

    public void setQuantFigura(int quantFigura) {
        this.quantFigura = quantFigura;
    }
    
    

    public String getNomeAlbum() {
        return nomeAlbum;
    }

    public int getQuantFigura() {
        return quantFigura;
    }


    
}
