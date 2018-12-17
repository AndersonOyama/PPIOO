package colecoes;

// Cada método desta interface é responsável por uma funcionalidade do programa.
import colecoes.Entity.albumEntity;
import java.util.ArrayList;

// Os métodos declarados nesta interface devem ser implementados na classe
// LocalColecoesServico.
public interface ColecoesServico {

    public int buscaAlbum(String nomeAlbum);

    public String criarAlbum(String nomeAlbum, Integer quantFig);

    public ArrayList<albumEntity> mostraTodosAlbuns();

    public String criarColecao(String apelido, Integer idAlbum);

    public boolean addFigurinha(Integer id, String nomeColecao, Integer figurinhas);
    
    public albumEntity mostrarAlbum(Integer id);

  
}
