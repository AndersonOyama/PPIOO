package colecoes;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import colecoes.LocalColecoesServico;
import colecoes.ColecoesServico;

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

    public void executa() {
        loop:
        while (true) {
            String comando = leComand();
            //System.out.println(comando);
            String[] subString = comando.split(" album");

            // Cada comando deve efetuar uma chamada de método de servico
            // ex: service.novoAlbum(parametros...)
            // Se o código dentro de um case ficar muito extenso, você deve
            // criar um novo método, ex executaComandoNovoAlbum
            switch (subString[0]) {
                case "criar":
                    String[] dados = subString[1].split("\" ");
                    String nomeAlbum = dados[0].replace("\"", "").trim();
                    ArrayList<Integer> arrayFig = parametroFig(dados[0]);
                    System.out.println("Nome: " + nomeAlbum + " Quant: " + arrayFig.get(0));
                    //LocalColecoesServico.criarAlbum(nomeAlbum, Integer.parseInt(dados[1]), conjFig);
                    break;

                case "editar":
                    System.out.println("Editar ok" + subString[1]);
                    break;

                case "albums":

                    break;

                case "novac":

                    break;

                case "sair":
                    break loop;
                default:
                    saida.println("Comando inválido: " + subString[0]);
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
    
    
    ArrayList<Integer> parametroFig(String dados){
        ArrayList<Integer> fig = new ArrayList<>();
        String[] dividido = dados.split(" ");
        for(int i = 0; i < dividido.length; i++){
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
}
