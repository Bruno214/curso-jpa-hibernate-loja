package br.com.alura.loja.modelo;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class CategoriaJpa {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  public Long getId() {
    return id;
  }

  public CategoriaJpa (String nome) {
    this.nome = nome;
  }

  public CategoriaJpa () {
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
}
