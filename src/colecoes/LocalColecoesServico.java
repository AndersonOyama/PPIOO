package colecoes;

// Uma implementação de ColecoesServico que armazena os dados e executa as
import static colecoes.ColecoesDao.bdAlbum;
import static colecoes.ColecoesDao.persisteFigurinhas;
import static colecoes.ColecoesDao.removeFigura;
import colecoes.Entity.ColecoesEntity;
import colecoes.Entity.AlbumEntity;
import java.util.ArrayList;
import java.util.Random;

// operações localmente. Todas as operações de armazenamento e recuperação de
// dados são feitas através da instância dao.
public class LocalColecoesServico implements ColecoesServico {

    private final ColecoesDao dao;

    public LocalColecoesServico(ColecoesDao dao) {
        this.dao = dao;
    }

    @Override
    public String criarAlbum(String nomeAlbum, Integer quantFig) {
        int id = buscaAlbum(nomeAlbum);
        if (id != -1) { //VERIFICA A EXISTENCIA DO ALBUM PARA NÃO PERMITIR CRIAR DOIS ALBUM IGUAIS
            return ("O álbum já existe." + " (ID: " + id + " )");
        } else if (quantFig <= 0) {
            return ("A quantidade de figurinhas é invalida");
        } else {
            id = ColecoesDao.persisteAlbum(nomeAlbum, quantFig);
            return ("Album criado com sucesso! " + "ID: " + id);
        }
    }

    @Override
    public int buscaAlbum(String nomeAlbum) {
        int id = ColecoesDao.buscaAlbum(nomeAlbum);
        if (id < 0) {
//            System.out.println("Album inexistente!");
            return -1;
        } else {
            return id;
        }

    }

    @Override
    public ArrayList<AlbumEntity> mostraTodosAlbuns() {
        ArrayList<AlbumEntity> todosAlbuns = new ArrayList<>();
        todosAlbuns = ColecoesDao.mostraAlbuns();
        ArrayList<ColecoesEntity> colecao = new ArrayList<>();

        return todosAlbuns;
    }

    public AlbumEntity mostrarAlbum(Integer id) {
        AlbumEntity dadosAlbum = new AlbumEntity();
        return dadosAlbum = ColecoesDao.buscaAlbumId(id);
    }

    @Override
    public String criarColecao(String apelido, Integer idAlbum) {
        AlbumEntity album = new AlbumEntity();
        album = ColecoesDao.buscaAlbumId(idAlbum);
        if (album == null) {
            return ("ID do album inexistente!");
        } else {
            if (ColecoesDao.criaColecao(apelido, idAlbum, album.getQuantFigura()) == false) {
                return ("Nome de Coleção já existente!");
            } else {
                return ("Coleção \"" + apelido + "\" criado.");

            }

        }
    }

    @Override
    public String addFigurinha(Integer id, String nomeColecao, Integer figurinhas) {
        if (ColecoesDao.persisteFigurinhas(nomeColecao, id, figurinhas) == true) {
            return ("Figurinha: " + figurinhas + " adicionado a coleção: " + nomeColecao + ".");

        } else {
            return ("Erro ao adicionar as figurinhas. Verifique os dados inseridos!");

        }
    }
    
    @Override
    public ArrayList<ColecoesEntity> mostraColec(){
        ArrayList<ColecoesEntity> colecoes = new ArrayList<>();
        return colecoes = ColecoesDao.mostraColecao();
    }

    

    public String removeFigura(Integer id, String nome, Integer figura){
        if(ColecoesDao.removeFigura(id, figura, nome) == true){
            return ("Figura removido com sucesso");
        }
        return ("Erro ao remover a figura");
    }
    
    @Override
     public String sorteio(Integer id, String apelido){
        Random r = new Random();
        int quantidade = bdAlbum.get(id).getQuantFigura();
        int sortido = r.nextInt(quantidade);
        int pagar = r.nextInt(quantidade);
        
        if(removeFigura(id, apelido, pagar).contains("removido") && addFigurinha(id, apelido, sortido).contains("adicionado")){
            return ("Figura ganha: " + sortido + " Figura perdida como pagamento: " + pagar);
        }
        return ("Erro ao sortear a figura");
    }
}