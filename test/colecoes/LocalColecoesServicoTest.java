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
        LocalColecoesServico localService = new LocalColecoesServico();
        ArrayList<Integer> conjFig = new ArrayList<>();
        localService.criarAlbum("Album Teste", 60, conjFig);
        
    }
    
}
