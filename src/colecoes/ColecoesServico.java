package colecoes;

// Cada método desta interface é responsável por uma funcionalidade do programa.
// Os métodos declarados nesta interface devem ser implementados na classe
// LocalColecoesServico.
public interface ColecoesServico {

    public static void criarAlbum(String parametros){
        if(parametros.length() < 3){ //VERIFICA SE TEM PELO MENOS 1 LETRA E 1 NÚMERO
              System.out.println("Parâmetros insuficientes para criar um album. Verifique os dados informado.");
              return;
        }
        
        String[] dados = parametros.split("\" ");
        String nomeAlbum = dados[0].replace("\"", "");
        //System.out.println(nomeAlbum);
        if(ColecoesDao.encontraAlbum(nomeAlbum) == true){
            System.out.println("O álbum já existe");
        } else {
            
        }
        
        
         
   }


}

