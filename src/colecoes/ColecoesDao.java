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

    HashMap<String, Integer> bdAlbum = new HashMap<String, Integer>();
    HashMap<String, List<Integer>> conjColecoes = new HashMap<String, List<Integer>>();
    
    static public boolean persisteAlbum(String nome, Integer quantFig) {
        bdAlbum.put(nome, quantFig);
        return false;
    }

    static public boolean buscaAlbum(String nome) {
        if(bdAlbum.containsKey(nome)){
            
            return true;
        }
        return false;
    }

}
