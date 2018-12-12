package colecoes;

import org.junit.Test;
import static org.junit.Assert.*;
import colecoes.LocalColecoesServico;
import colecoes.ColecoesServico;
import colecoes.ColecoesDao;
import java.util.ArrayList;

// Cada funcionalidade da classe LocalColecoesService deve ter pelo menos um
// método de teste nesta classe.
public class LocalColecoesServicoTest {
    
    @Test
    public void testCriarAlbum() {
        LocalColecoesServico localService = new LocalColecoesServico(null);
        assertTrue(localService.criarAlbum("Album Teste", 60));
        assertFalse(localService.criarAlbum("Album Teste", 60)); //CRIAÇÃO DE 2 ALBUNS IGUAIS
        localService = new LocalColecoesServico(null);
        LocalColecoesServico localService2 = new LocalColecoesServico(null); //CRIAÇÃO COM QUANTIDADE NEGATIVO OU 0;
        assertFalse(localService2.criarAlbum("Album Quantidade", 0)); 
    }
    
    @Test
    public void testConsultarAlbum(){
        LocalColecoesServico busca = new LocalColecoesServico(null);
        assertEquals(busca.buscaAlbum("Album Teste"), 1);
    }
    
    
    @Test
    public void testMostraAlbum(){
        LocalColecoesServico mostra = new LocalColecoesServico(null);
        
    }
}
