package colecoes;

// Cada método desta interface é responsável por uma funcionalidade do programa.
import colecoes.Entity.ColecoesEntity;
import colecoes.Entity.AlbumEntity;
import java.util.ArrayList;

// Os métodos declarados nesta interface devem ser implementados na classe
// LocalColecoesServico.
public interface ColecoesServico {

    public int buscaAlbum(String nomeAlbum);

    public String criarAlbum(String nomeAlbum, Integer quantFig);

    public ArrayList<AlbumEntity> mostraTodosAlbuns();

    public String criarColecao(String apelido, Integer idAlbum);

    public String addFigurinha(Integer id, String nomeColecao, Integer figurinhas);
    
    public AlbumEntity mostrarAlbum(Integer id);

    public ArrayList<ColecoesEntity> mostraColec();
    
    public String removeFigura(Integer id, String nome, Integer figura);
    
    public String sorteio(Integer id, String apelido);
  
}
