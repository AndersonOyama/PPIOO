package colecoes;

// Uma implementação de ColecoesServico que armazena os dados e executa as
// operações localmente. Todas as operações de armazenamento e recuperação de
// dados são feitas através da instância dao.
public class LocalColecoesServico implements ColecoesServico {

    private final ColecoesDao dao;

    public LocalColecoesServico(ColecoesDao dao) {
        this.dao = dao;
    }

    public boolean criarAlbum(String parametros) {
        if (parametros.length() < 3) { //VERIFICA SE TEM PELO MENOS 1 LETRA E 1 NÚMERO PARA DECLARAR O NOME AO ALBUM E A QUANTIDADE DE FIGURINHAS
            System.out.println("Parâmetros insuficientes para criar um album. Verifique os dados informado.");
            return false;
        }

        String[] dados = parametros.split("\" ");
        String nomeAlbum = dados[0].replace("\"", "");
        //System.out.println(nomeAlbum);

        if (ColecoesDao.buscaAlbum(nomeAlbum) == true) { //VERIFICA A EXISTENCIA DO ALBUM PARA NÃO PERMITIR CRIAR DOIS ALBUM IGUAIS
            System.out.println("O álbum já existe");
            return false;

        } else {

        }

        return true;
    }

    @Override
    public int buscaAlbum(String nomeAlbum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


