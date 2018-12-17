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
    ArrayList<Integer> listaFigurinhas = new ArrayList<>();

    public String getNomeColecao() {
        return nomeColecao;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public ArrayList<Integer> getListaFigurinhas() {
        return listaFigurinhas;
    }


    public void setNomeColecao(String nomeColecao) {
        this.nomeColecao = nomeColecao;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public void setListaFigurinhas(ArrayList<Integer> listaFigurinhas) {
        this.listaFigurinhas = listaFigurinhas;
    }


    
    
}
