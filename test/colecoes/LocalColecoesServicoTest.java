package colecoes;

import org.junit.Test;
import static org.junit.Assert.*;
import colecoes.LocalColecoesServico;
import colecoes.ColecoesServico;
import colecoes.ColecoesDao;
import colecoes.Entity.albumEntity;
import java.util.ArrayList;

// Cada funcionalidade da classe LocalColecoesService deve ter pelo menos um
// método de teste nesta classe.
public class LocalColecoesServicoTest {

    @Test
    public void testCriarAlbum() {
        LocalColecoesServico localService = new LocalColecoesServico(null);
        assertTrue(localService.criarAlbum("Album Teste", 60).contains("Album criado com sucesso! "));
        assertTrue(localService.criarAlbum("Album Teste", 60).contains("O álbum já existe")); //CRIAÇÃO DE 2 ALBUNS IGUAIS
        localService = new LocalColecoesServico(null);
        LocalColecoesServico localService2 = new LocalColecoesServico(null); //CRIAÇÃO COM QUANTIDADE NEGATIVO OU 0;
        assertTrue(localService2.criarAlbum("Album Quantidade", 0).contains("A quantidade de figurinhas é invalida"));
    }


    @Test
    public void testAlbuns() {
        ArrayList<albumEntity> albuns = new ArrayList<>();
        LocalColecoesServico mostra = new LocalColecoesServico(null);
        albuns = mostra.mostraTodosAlbuns();
        assertTrue(albuns.size() == 1);
        assertTrue(albuns.get(0).getNomeAlbum().equals("Album Teste"));
    }
    
    @Test
    public void testMostrar(){
        LocalColecoesServico mostrar = new LocalColecoesServico(null);
        mostrar.mostrarAlbum(0);
    }
    
    @Test
    public void testCriarColecao(){
        LocalColecoesServico criaCol = new LocalColecoesServico(null);
        assertTrue(criaCol.criarColecao("Teste", 0).contains("criado"));
        assertTrue(criaCol.criarColecao("Teste", 0).contains("já"));
    }

//    @Test
//    public void testInsereFig(){
//        LocalColecoesServico insereFig = new LocalColecoesServico(null);
//        assertTrue(insereFig.addFigurinha(0, "Teste", 5));
//    }



}
