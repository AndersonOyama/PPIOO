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

    LocalColecoesServico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public void criarAlbum(String nomeAlbum, Integer quantFig, ArrayList<Integer> figuras) {
        if (ColecoesDao.buscaAlbum(nomeAlbum) == true) { //VERIFICA A EXISTENCIA DO ALBUM PARA NÃO PERMITIR CRIAR DOIS ALBUM IGUAIS
            System.out.println("O álbum já existe");
            return;
        } else {
            ColecoesDao.persisteAlbum(nomeAlbum, quantFig);
            if(figuras.size() > 0){
                //GUARDAR FIGURAS 
            }
            System.out.println("Album criado com sucesso!");
        }
        return;
    }

    @Override
    public int buscaAlbum(String nomeAlbum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
