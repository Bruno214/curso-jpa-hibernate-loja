package br.com.alura.loja.modelo;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDateTime;


// ela é uma entidade, existe uma tabela associada a ela
@Entity
@Table(name = "produtos")  // trocando o nome da tabela para produtos
public class Produto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // dizer para o java que esse atributo é a chave primaria e a como vai ser gerada
  private Long id;
  private String nome;
  private String descricao;
  private double preco;
  private final LocalDateTime dataCadastro = LocalDateTime.now();

//  @Enumerated(EnumType.STRING)
//  private Categoria categoria;

  @ManyToOne // muitos produtos para uma categoria
  private CategoriaJpa categoria;

  public Produto(){}
  public Produto(String nome, String descricao, double preco, CategoriaJpa categoria){
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.categoria = categoria;
  }

  public LocalDateTime getDataCadastro() {
    return dataCadastro;
  }

  public CategoriaJpa getCategoria() {
    return categoria;
  }

  public void setCategoria(CategoriaJpa categoria) {
    this.categoria = categoria;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }
}
