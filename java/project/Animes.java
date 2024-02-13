package project;

import java.util.Objects;
import java.io.Serializable;
// abaixo estou usando a interface Comparable para comparar os animes
public class Animes implements Comparable<Animes>, Serializable {
    private String nome;
    private String genero;
    private int anoLancamento;

public Animes(String nome, String genero, int anoLancamento){
        this.nome = nome;
        this.genero = genero;
        this.anoLancamento = anoLancamento;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animes animes = (Animes) o;
        return anoLancamento == animes.anoLancamento && nome.equals(animes.nome) && genero.equals(animes.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, anoLancamento);
    }

    public Animes(){
    this("","",0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int compareTo(Animes outroAnime) {
        return this.nome.compareTo(outroAnime.getNome());
    }

    @Override
    public String toString() {
        return " Anime: " + nome + "\n" +
                " gênero: " + genero + "\n" +
                " ano de Lançamento : " + anoLancamento+ "\n" ;
    }
}