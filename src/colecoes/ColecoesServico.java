package colecoes;

// Cada método desta interface é responsável por uma funcionalidade do programa.

import java.util.ArrayList;

// Os métodos declarados nesta interface devem ser implementados na classe
// LocalColecoesServico.
public interface ColecoesServico {

    public int buscaAlbum(String nomeAlbum);
    public boolean criarAlbum(String nomeAlbum, Integer quantFig);
    
}
