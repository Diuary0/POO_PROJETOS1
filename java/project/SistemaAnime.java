package project;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SistemaAnime implements gerenciadorAnimes {
    ArrayList<Animes> listaAnimes;

    public ArrayList<Animes> getListaAnimesFavoritos() {
        return listaAnimesFavoritos;
    }

    ArrayList<Animes> listaAnimesFavoritos;

    public SistemaAnime() {
        this.listaAnimes = new ArrayList<>();
        this.listaAnimesFavoritos = new ArrayList<>();
    }

    public Animes buscarAnime(String palavraChave) throws NaoExisteException {
        // o método buscaAnime pode lançar uma exceção se o anime não existir
        for (Animes anime : listaAnimes) {
            if (anime.getNome().equalsIgnoreCase(palavraChave)) {
                return anime;
            }
        }
        throw new NaoExisteException("Anime não encontrado");
    }


    public void cadastroDeAnime(Animes animeAdicionado) {
        listaAnimes.add(animeAdicionado);


        Collections.sort(listaAnimes);


    }



    public ArrayList<Animes> pesquisaAnimesPorAno(int anoAnime) {
        ArrayList<Animes> animesAnoLancamento = new ArrayList<>();
        for (Animes a : listaAnimes) {
            if (a.getAnoLancamento() == (anoAnime)) {
                animesAnoLancamento.add(a);

            }
        }
        return animesAnoLancamento;
    }

    public void favoritarAnimes(String anime) throws NaoExisteException {
        try {
            Animes animeF = buscarAnime(anime);
            listaAnimesFavoritos.add(animeF);
        } catch (NaoExisteException e) {

            throw new NaoExisteException("Não foi possivel favoritar o anime");
        }


    }

    public ArrayList<Animes> listarAnimes() {
        return this.listaAnimes;
    }



    @Override
    public String toString() {
        String a = "";
        for (Animes d: listaAnimes
             ) {
            a+= "Nome: "+d.getNome() + "genero: "+ d.getGenero() + "Ano: "+ d.getAnoLancamento() + "\n";
        }
        return "Lista de animes: " + a;
    }

}




