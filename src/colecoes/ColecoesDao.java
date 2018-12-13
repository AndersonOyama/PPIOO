package colecoes;

import colecoes.Entity.albumEntity;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    HashMap<String, List<Integer>> conjColecoes = new HashMap<String, List<Integer>>();

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

    static public void mostraAlbuns() {

        for (int i = 0; i < bdAlbum.size(); i++) {
            System.out.println("\t-" + bdAlbum.get(i).getNomeAlbum() + " ID: " + i);
        }
    }

}
