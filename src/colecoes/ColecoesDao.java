package colecoes;

import colecoes.Entity.ColecoesEntity;
import colecoes.Entity.albumEntity;
import java.util.ArrayList;

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

    ArrayList<albumEntity> bdAlbum = new ArrayList<>();
    ArrayList<ColecoesEntity> conjColecoes = new ArrayList<>();

    static public int persisteAlbum(String nome, Integer quantFig) {
        albumEntity aEnt = new albumEntity();
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

    static public int buscaAlbumId(Integer id, Integer dadosCompleto) {
        if (bdAlbum.get(id) != null && dadosCompleto == 0) {
            return bdAlbum.get(id).getQuantFigura();
        } else if (bdAlbum.get(id) != null && dadosCompleto == 1) {
            System.out.println("Título: " + bdAlbum.get(id).getNomeAlbum());
            System.out.println("Quantidade de figurinha: " + bdAlbum.get(id).getQuantFigura());
        }
        return -1;
    }

    static public void mostraAlbuns() {

        for (int i = 0; i < bdAlbum.size(); i++) {
            System.out.println("\t-" + bdAlbum.get(i).getNomeAlbum() + " ID: " + i);
        }
    }

    static public boolean criaColecao(String nome, Integer id, Integer quantFigurinha) {
        for (int i = 0; i < conjColecoes.size(); i++) {
            if ((conjColecoes.get(i).getNomeColecao()).equals(nome) && (conjColecoes.get(i).getIdAlbum()).equals(id)) {
                return false;
            }
        }
        ColecoesEntity colecao = new ColecoesEntity();
        colecao.setIdAlbum(id);
        colecao.setNomeColecao(nome);
        ArrayList<Integer> figuras = new ArrayList<>(quantFigurinha);
        for (int i = 0; i < quantFigurinha; i++) {
            figuras.add(0);
        }
        return true;
    }

    static public boolean persisteFigurinhas(String nome, Integer idALbum, Integer figurinha) {
        for (int i = 0; i < conjColecoes.size(); i++) {
            if (conjColecoes.get(i).getNomeColecao().equals(nome) && conjColecoes.get(i).getIdAlbum().equals(idALbum)) {
                ArrayList temp = conjColecoes.get(i).getFigurinhas();
                System.out.println(temp.get(figurinha));
                return true;
            }
        }
        return false;
    }

    static public boolean mostraColecao(Integer idAlbum, String nomeColecao) {
        for (int i = 0; i < conjColecoes.size(); i++) {
            if(conjColecoes.get(i).getNomeColecao().equals(nomeColecao) && conjColecoes.get(i).getIdAlbum().equals(idAlbum)){
                System.out.println(conjColecoes.get(i).getNomeColecao());
            }
        }
        return false;
    }

}
