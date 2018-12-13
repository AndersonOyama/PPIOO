package colecoes;

// Uma implementação de ColecoesServico que armazena os dados e executa as
import java.util.ArrayList;

// operações localmente. Todas as operações de armazenamento e recuperação de
// dados são feitas através da instância dao.
public class LocalColecoesServico implements ColecoesServico {

    private final ColecoesDao dao;

    public LocalColecoesServico(ColecoesDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean criarAlbum(String nomeAlbum, Integer quantFig) {
        int id = buscaAlbum(nomeAlbum);
        if (id != -1) { //VERIFICA A EXISTENCIA DO ALBUM PARA NÃO PERMITIR CRIAR DOIS ALBUM IGUAIS
            System.out.println("O álbum já existe." + " (ID: " + id + " )");
            return false;
        } else if (quantFig <= 0) {
            System.out.println("A quantidade de figurinhas é invalida");
            return false;
        } else {
            id = ColecoesDao.persisteAlbum(nomeAlbum, quantFig);
            System.out.println("Album criado com sucesso! " + "ID: " + id);
        }
        return true;
    }

    @Override
    public int buscaAlbum(String nomeAlbum) {
        int id = ColecoesDao.buscaAlbum(nomeAlbum);
        if(id < 0){
//            System.out.println("Album inexistente!");
            return -1;
        } else {
            return id;
        }
        
    }
    
    public void mostraTodosAlbuns(){
        System.out.println("Albuns:");
        ColecoesDao.mostraAlbuns();
    }
    
    public void mostrarAlbum(Integer id){
        Integer quantidade = ColecoesDao.buscaAlbumId(id, 1);
        
    }
    
    @Override
    public boolean criarColecao(String apelido, Integer idAlbum){
        Integer quantidade = ColecoesDao.buscaAlbumId(idAlbum, 0);
        if(quantidade == -1){
            System.out.println("ID inexistente!");
            return false;
        } else {
            ColecoesDao.criaColecao(apelido, idAlbum, quantidade);

        }
        return true;
    }
}
