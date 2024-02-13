package project;

import java.io.IOException;
import java.util.ArrayList;

public interface gerenciadorAnimes {


    public Animes buscarAnime(String palavraChave) throws NaoExisteException;

    public void favoritarAnimes(String anime) throws NaoExisteException;

    public void cadastroDeAnime(Animes animeAdicionado) throws IOException;

    public ArrayList<Animes> pesquisaAnimesPorAno(int anoAnime);

    public ArrayList<Animes> listarAnimes();

    public String toString();




}
