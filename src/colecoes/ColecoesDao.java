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

    static public albumEntity buscaAlbumId(Integer id) {
        if (bdAlbum.get(id) == null) {
            return null;
        } else {
            return bdAlbum.get(id);
        }
    }

    static public int tamanhoAlbum() {
        return (bdAlbum.size());
    }

    static public ArrayList<albumEntity> mostraAlbuns() {
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
        System.out.println("Album de id: " + id + " indexistente!");
        return false;
    }

    static public boolean persisteFigurinhas(String nome, Integer idALbum, Integer figurinha) {
        for (int i = 0; i < conjColecoes.size(); i++) {
            if (conjColecoes.get(i).getNomeColecao().equals(nome) && conjColecoes.get(i).getIdAlbum().equals(idALbum)) {
                ArrayList<Integer> temp = conjColecoes.get(i).getListaFigurinhas();
                int fig = temp.get(figurinha);
                temp.add(figurinha, fig = fig + 1);
                return true;
            }
        }
        return false;
    }

    static public boolean mostraColecao(Integer idAlbum, String nomeColecao) {
        for (int i = 0; i < conjColecoes.size(); i++) {
            if (conjColecoes.get(i).getNomeColecao().equals(nomeColecao) && conjColecoes.get(i).getIdAlbum().equals(idAlbum)) {
                System.out.println(conjColecoes.get(i).getNomeColecao());
            }
        }
        return false;
    }

    static public void mostraCol() {
        for (int i = 0; i < conjColecoes.size(); i++) {
            System.out.println("Nome: " + conjColecoes.get(i).getNomeColecao() + " Id Colec: " + conjColecoes.get(i).getIdAlbum());
        }
    }

    static void mostraColecao() {
        for (int i = 0; i < bdAlbum.size(); i++) {
            System.out.println("\t-" + bdAlbum.get(i).getNomeAlbum() + " ID: " + i);
            for (int j = 0; j < conjColecoes.size(); i++) {
                System.out.println("* " + conjColecoes.get(j).getNomeColecao()); //TERMINAR PORCENTAGEM.
            }
        }
    }

}
