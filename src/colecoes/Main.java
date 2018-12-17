package colecoes;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import colecoes.LocalColecoesServico;
import colecoes.ColecoesServico;
import colecoes.ColecoesDao;
import static colecoes.ColecoesDao.mostraCol;
import colecoes.Entity.albumEntity;
import com.sun.org.apache.xpath.internal.operations.Equals;
import java.util.StringTokenizer;
import jdk.nashorn.internal.parser.Token;

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
        } else if (token[0].equals("nova") && token[1].equals("colecao")) {
            return temp = token[0] + " " + token[1];
        } else if (token[0].equals("mostrar")) {
            return token[0];
        } else if (token[0].equals("sair")) {
            return token[0];
        } else if (token[0].equals("adicionar")) {
            return token[0];
        } else if (token[0].equals("mostrar") && token[1].equals("colecao")) {
            return (token[0] + " " + token[1]);
        }
        return entrada;
    }

    public String[] pegaNomeAlbum(String entrada, String comando) {
        entrada = entrada.replace(comando, "");
        String[] temp = entrada.split("\"");

        return temp;
    }

    public String[] tokenizar(String parametros) {
        String[] tokenizado = parametros.split("//s+");
        return tokenizado;
    }

    public void executa() {
        loop:
        while (true) {
            String comando = leComand();
            String executa = formataString(comando);
            String[] tokens = tokenizar(comando);
            // Cada comando deve efetuar uma chamada de método de servico
            // ex: service.novoAlbum(parametros...)
            // Se o código dentro de um case ficar muito extenso, você deve
            // criar um novo método, ex executaComandoNovoAlbum
            switch (executa) {
                case "criar album"://OK
                    String[] nomeAlbum = pegaNomeAlbum(comando, executa);
                    LocalColecoesServico lColecoesServico = new LocalColecoesServico(null);
                    System.out.println(lColecoesServico.criarAlbum(nomeAlbum[1], Integer.parseInt((nomeAlbum[2]).replaceAll("\\s+", ""))));
                    break;

                case "buscar": //ok
                    nomeAlbum = pegaNomeAlbum(comando, executa);
                    int id = ColecoesDao.buscaAlbum(nomeAlbum[0]);
                    if (id <= 0) {
                        System.out.println("Album inexistente");
                    } else {
                        System.out.println("Album " + nomeAlbum + ", possui ID: " + id + " .");
                    }

                    break;

                case "albuns": //OK
                    ArrayList<albumEntity> albuns = new ArrayList<>();
                    LocalColecoesServico mostrar = new LocalColecoesServico(null);
                    albuns = mostrar.mostraTodosAlbuns();
                    for (int i = 0; i < albuns.size(); i++) {
                        System.out.println("\t" + i+1 + " - " + albuns.get(i).getNomeAlbum());
                    }
                    break;

                case "mostrar": //OK
                    LocalColecoesServico mostrarCompleto = new LocalColecoesServico(null);
                    albumEntity album = new albumEntity();
                    album = mostrarCompleto.mostrarAlbum(Integer.parseInt(tokens[1]));
                    System.out.println("Nome do album: " + album.getNomeAlbum() + " ID: " + album.getId());
                    break;

                case "nova colecao":
                    String[] nomeColecao = comando.split(" ");
                    LocalColecoesServico nColecao = new LocalColecoesServico(null);
                    System.out.println(nColecao.criarColecao(nomeColecao[3], Integer.parseInt(nomeColecao[2])));
                    break;

                case "adicionar":
                    mostraCol();
                    String[] colecao = comando.split(" ");
                    LocalColecoesServico addColecao = new LocalColecoesServico(null);
                    for (int i = 3; i < colecao.length; i++) {
                        addColecao.addFigurinha(Integer.parseInt(colecao[1]), colecao[2], Integer.parseInt(colecao[i]));
                    }

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

}
