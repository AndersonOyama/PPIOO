package colecoes;

// Uma implementação de ColecoesServico que armazena os dados e executa as
import static colecoes.ColecoesDao.conjColecoes;
import static colecoes.ColecoesDao.tamanhoAlbum;
import colecoes.Entity.albumEntity;
import java.util.ArrayList;

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
    public ArrayList<albumEntity> mostraTodosAlbuns() {
        ArrayList<albumEntity> todosAlbuns = new ArrayList<>();
        todosAlbuns = ColecoesDao.mostraAlbuns();
        return todosAlbuns;
    }

    public albumEntity mostrarAlbum(Integer id) {
        albumEntity dadosAlbum = new albumEntity();
        return dadosAlbum = ColecoesDao.buscaAlbumId(id);
    }

    @Override
    public String criarColecao(String apelido, Integer idAlbum) {
        albumEntity album = new albumEntity();
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
    public boolean addFigurinha(Integer id, String nomeColecao, Integer figurinhas) {
        if (ColecoesDao.persisteFigurinhas(nomeColecao, id, figurinhas) == true) {
            System.out.println("Figurinha: " + figurinhas + " adicionado a coleção: " + nomeColecao + ".");
            return true;
        } else {
            System.out.println("Erro ao adicionar as figurinhas. Verifique os dados inseridos!");
            return false;
        }
    }
}
