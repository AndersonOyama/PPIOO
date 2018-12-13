/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecoes.Entity;

import java.util.ArrayList;

/**
 *
 * @author ander
 */
public class ColecoesEntity {
    String nomeColecao;
    Integer idAlbum;
    ArrayList<Integer> figurinhas = new ArrayList<>();

    public String getNomeColecao() {
        return nomeColecao;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public ArrayList<Integer> getFigurinhas() {
        return figurinhas;
    }

    public void setNomeColecao(String nomeColecao) {
        this.nomeColecao = nomeColecao;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public void setFigurinhas(ArrayList<Integer> figurinhas) {
        this.figurinhas = figurinhas;
    }
    
    
}
