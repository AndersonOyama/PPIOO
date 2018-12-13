package colecoes;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import colecoes.LocalColecoesServico;
import colecoes.ColecoesServico;
import colecoes.ColecoesDao;
import java.util.StringTokenizer;

// Classe principal que implementa uma interface orientada a comandos com o
// usuário.
//
// Para executar este programa pressione F6 no netbeans.
//
// Para executar este programa no terminal construa o projeto (F11 no
// netbeans), abra o terminal e mude para o diretório do projeto e execute:
// java -jar dist/Colecoes.jar
public class Main {

    final static String PROMPT = "> ";
    final PrintStream saida;
    final Scanner entrada;
    final ColecoesServico servico;

    public Main(Scanner entrada, ColecoesServico servico, PrintStream saida) {
        this.entrada = entrada;
        this.servico = servico;
        this.saida = saida;
    }

    public String formataString(String entrada) {
        String temp;
        String[] token = entrada.split("\\s+");
        if (token[0].equals("criar") && token[1].equals("album")) {
            return temp = token[0] + " " + token[1];
        } else if (token[0].equals("albuns")) {
            return token[0];
        } else if (token[0].equals("nova") && token[1].equals("colecao")){
            return temp = token[0] + " " + token[1];
        }
        return null;
    }

    
   public String[] pegaNomeAlbum(String entrada, String comando){
       entrada = entrada.replace(comando, "");
       String[] temp = entrada.split("\"");
       
       return temp;
   }
    
    public void executa() {
        loop:
        while (true) {
            String comando = leComand();
            String executa = formataString(comando);

            // Cada comando deve efetuar uma chamada de método de servico
            // ex: service.novoAlbum(parametros...)
            // Se o código dentro de um case ficar muito extenso, você deve
            // criar um novo método, ex executaComandoNovoAlbum
            switch (executa) {
                case "criar album":
                    String[] nomeAlbum = pegaNomeAlbum(comando, executa);
                    LocalColecoesServico lColecoesServico = new LocalColecoesServico(null);
                    lColecoesServico.criarAlbum(nomeAlbum[1], Integer.parseInt((nomeAlbum[2]).replaceAll("\\s+", "")));
                    break;

                case "buscar":
                    nomeAlbum = pegaNomeAlbum(comando, executa);
                    int id = ColecoesDao.buscaAlbum(nomeAlbum[0]);
                    if (id <= 0) {
                        System.out.println("Album inexistente");
                    } else {
                        System.out.println("Album " + nomeAlbum + ", possui ID: " + id + " .");
                    }

                    break;

                case "albuns":
                    LocalColecoesServico mostrar = new LocalColecoesServico(null);
                    mostrar.mostraTodosAlbuns();
                    break;

                case "editar":
                    System.out.println("Editar ok");
                    break;

                case "albums":

                    break;

                case "novac":

                    break;

                case "sair":
                    break loop;
                default:
                    saida.println("Comando inválido: " + comando);
            }
        }
    }

    String leComand() {
        while (true) {
            saida.print(PROMPT);
            String comando = entrada.nextLine().trim();
            if (!comando.isEmpty()) {
                return comando;
            }
        }
    }

    ArrayList<Integer> parametroFig(String dados) {
        ArrayList<Integer> fig = new ArrayList<>();
        String[] dividido = dados.split(" ");
        for (int i = 0; i < dividido.length; i++) {
            fig.set(i, Integer.parseInt(dividido[i]));
            System.out.println(fig.get(i));
        }
        return fig;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        // Outra implementação de ColecoesService, como por exemplo uma que
        // executa remotamente, pode ser usada sem que o código de interface do
        // usuário tenha que ser alterado.
        //
        // Uma instância de classe que implementa ColecoesDao deve ser passada
        // como parâmetro ao invés de null.
        ColecoesServico servico = new LocalColecoesServico(null);
        Main main = new Main(entrada, servico, System.out);
        main.executa();
    }

    public static String trataEntradaAlbum(String entrada) {

        return null;
    }

}
