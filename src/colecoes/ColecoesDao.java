package colecoes;

import colecoes.Entity.ColecoesEntity;
import colecoes.Entity.AlbumEntity;
import java.util.ArrayList;
import java.util.Random;

// Esta interface deve conter métodos que armazenam e recuperam os dados
// inseridos no programa. Alguns possíveis métodos
// - salvaAlbum, armazena um álbum que pode ser recuperado posteriormente;
// - encontraAlbumPorId, recebe um id e devolve um álbum com este id (se
//   existir)
// - todosAlbuns, devolve uma lista com todos os álbuns
//
// Você deve criar uma implementação desta interface que armazena os dados em
// memória. Da mesma forma que a classe LocalColecoesServico tem uma classe de
// testes LocalColecoesServicoTest associada, a classe que você criar para
// implementar a interface ColecoesDao também deve ter uma classe de testes.
public interface ColecoesDao {

    ArrayList<AlbumEntity> bdAlbum = new ArrayList<>();
    ArrayList<ColecoesEntity> conjColecoes = new ArrayList<>();

    static public int persisteAlbum(String nome, Integer quantFig) {
        AlbumEntity aEnt = new AlbumEntity();
        aEnt.setNomeAlbum(nome);
        aEnt.setQuantFigura(quantFig);
        aEnt.id = bdAlbum.size();
        bdAlbum.add(aEnt);
        return aEnt.getId();
    }

    static public int buscaAlbum(String nome) {
        for (int i = 0; i < bdAlbum.size(); i++) {
            if (bdAlbum.get(i).getNomeAlbum().equals(nome)) {
                return i;
            }
        }
        return -1;
    }

    static public AlbumEntity buscaAlbumId(Integer id) {
        if (bdAlbum.get(id) == null) {
            return null;
        } else {
            return bdAlbum.get(id);
        }
    }

    static public int tamanhoAlbum() {
        return (bdAlbum.size());
    }

    static public ArrayList<AlbumEntity> mostraAlbuns() {
        return bdAlbum;
    }

    static public boolean criaColecao(String nome, Integer id, Integer quantFigurinha) {
        for (int i = 0; i < conjColecoes.size(); i++) {
            if ((conjColecoes.get(i).getNomeColecao()).equals(nome) && (conjColecoes.get(i).getIdAlbum()).equals(id)) {
                return false;
            }

        }
        if (bdAlbum.get(id) != null) {
            ColecoesEntity colecao = new ColecoesEntity();
            colecao.setIdAlbum(id);
            colecao.setNomeColecao(nome);
            ArrayList<Integer> figuras = new ArrayList<>();
            for (int i = 0; i < quantFigurinha; i++) {
                figuras.add(0);
            }
            colecao.setListaFigurinhas(figuras);
            conjColecoes.add(colecao);
            return true;
        }
        return false;
    }

    static public boolean persisteFigurinhas(String nome, Integer idALbum, Integer figurinha) {
        for (int i = 0; i < conjColecoes.size(); i++) {
            if (conjColecoes.get(i).getNomeColecao().equals(nome) && conjColecoes.get(i).getIdAlbum().equals(idALbum)) {
                conjColecoes.get(i).getListaFigurinhas().add(figurinha);
                return true;
            }
        }
        return false;
    }


    static ArrayList<ColecoesEntity> mostraColecao() {
        return conjColecoes;
    }
    

    static boolean removeFigura(Integer id, Integer figura, String apelido){
        if(conjColecoes.get(id) != null){
            conjColecoes.get(id).getListaFigurinhas().remove(figura);
            return true;
        }
        return false;
    }
    
    static public String sorteio(Integer id, String apelido){
        Random r = new Random();
        int quantidade = bdAlbum.get(id).getQuantFigura();
        int sortido = r.nextInt(quantidade);
        int pagar = r.nextInt(quantidade);
        
        if(removeFigura(id, pagar, apelido) && persisteFigurinhas(apelido, id, sortido)){
            return ("Figura ganha: " + sortido + " Figura perdida como pagamento: " + pagar);
        }
        return ("Erro ao sortear a figura");
    }
}
