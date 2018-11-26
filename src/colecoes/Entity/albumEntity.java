/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecoes.Entity;

/**
 *
 * @author ander
 */
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
