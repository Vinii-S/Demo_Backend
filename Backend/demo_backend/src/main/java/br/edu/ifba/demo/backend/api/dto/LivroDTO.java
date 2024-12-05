package br.edu.ifba.demo.backend.api.dto;

import java.io.Serializable;
import java.sql.Date;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.demo.backend.api.model.LivroModel;

public class LivroDTO implements Serializable {

    private Long id_Livro;
    private String titulo;
    private String autor;
    private String editora;
    private Year ano_Publicacao;
    private String genero;
    private String isbn;
    private Integer num_Paginas;
    private String sinopse;
    private String idioma;
    private Date data_Cadastro;
    private Double preco;

    // Construtores
    public LivroDTO() {
        super();
    }

    public LivroDTO(Long id_Livro, String titulo, String autor, String editora, Year ano_Publicacao, String genero,
                    String isbn, Integer num_Paginas, String sinopse, String idioma, Date data_Cadastro, Double preco) {
        this.id_Livro = id_Livro;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano_Publicacao = ano_Publicacao;
        this.genero = genero;
        this.isbn = isbn;
        this.num_Paginas = num_Paginas;
        this.sinopse = sinopse;
        this.idioma = idioma;
        this.data_Cadastro = data_Cadastro;
        this.preco = preco;
    }

    // Getters e Setters
    public Long getId_Livro() {
        return id_Livro;
    }

    public void setId_Livro(Long id_Livro) {
        this.id_Livro = id_Livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Year getAno_Publicacao() {
        return ano_Publicacao;
    }

    public void setAno_Publicacao(Year ano_Publicacao) {
        this.ano_Publicacao = ano_Publicacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNum_Paginas() {
        return num_Paginas;
    }

    public void setNum_Paginas(Integer num_Paginas) {
        this.num_Paginas = num_Paginas;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Date getData_Cadastro() {
        return data_Cadastro;
    }

    public void setData_Cadastro(Date data_Cadastro) {
        this.data_Cadastro = data_Cadastro;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    // Método estático para converter LivroModel em LivroDTO
    public static LivroDTO converter(LivroModel model) {
        var livro = new LivroDTO();
        livro.setId_Livro(model.getId_livro());
        livro.setTitulo(model.getTitulo());
        livro.setAutor(model.getAutor());
        livro.setEditora(model.getEditora());
        livro.setAno_Publicacao(model.getAno_publicacao());
        livro.setGenero(model.getGenero());
        livro.setIsbn(model.getIsbn());
        livro.setNum_Paginas(model.getNum_paginas());
        livro.setSinopse(model.getSinopse());
        livro.setIdioma(model.getIdioma());
        livro.setData_Cadastro(model.getData_cadastro());
        livro.setPreco(model.getPreco());
        return livro;
    }

    // Método estático para converter uma lista de LivroModel em uma lista de LivroDTO
    public static List<LivroDTO> converter(List<LivroModel> livros) {
        List<LivroDTO> list = new ArrayList<>();
        for (LivroModel model : livros) {
            list.add(LivroDTO.converter(model));
        }
        return list;
    }
}