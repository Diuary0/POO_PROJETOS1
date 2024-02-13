package project;

import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class programaAnimeMenu {
    public static void main(String[] args) throws NaoExisteException, IOException {
        SistemaAnime sistema  = new SistemaAnime();

        while (true) {
           int escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:\n" +
                   "1. Adicionar anime\n" +
                   "2. Favoritar anime\n" +
                   "3. Buscar Animes por ano de lançamento\n" +
                   "4. Listar animes \n" +
                   "5. Sair"));


            switch (escolha) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Digite o nome do anime que deseja adicionar: ");
                    String genero = JOptionPane.showInputDialog("Digite o gênero do anime que deseja adicionar: ");
                    int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de lançamento do anime que deseja adicionar: "));
                    Animes anime = new Animes(nome, genero,ano);
                    sistema.cadastroDeAnime(anime);


                    JOptionPane.showMessageDialog(null, " O anime adicionado foi " + anime);


                    break;

                case 2:
                    String nome1 = JOptionPane.showInputDialog("Digite o nome do anime que deseja favoritar: ");
                    try {
                        sistema.favoritarAnimes(nome1);
                    }catch(NaoExisteException erro)    {

                        throw new NaoExisteException("erro"+erro);
                    }

                    JOptionPane.showMessageDialog(null, " O anime favoritado foi " + nome1);

                    break;

                case 3:
                    int anoAnime = Integer.parseInt(JOptionPane.showInputDialog(" Digite o ano do anime que deseja buscar: "));
                     ArrayList<Animes> animeAno = sistema.pesquisaAnimesPorAno(anoAnime);
                    String ani = "";
                     for (Animes a: animeAno) {
                         ani += a.toString();
                         // para cada anime que vai ser listado ao for each, vai adicionar um toString nessa váriavel "ani" string vazia


                     }
                     JOptionPane.showMessageDialog(null, ani);
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "Os animes listados foram: " + sistema.listarAnimes() );

                    break;
                case 5:
                    JOptionPane.showMessageDialog(null,"Saindo do programa.");
                  ;
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}



