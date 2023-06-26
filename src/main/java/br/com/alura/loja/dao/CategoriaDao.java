package br.com.alura.loja.dao;


import br.com.alura.loja.modelo.CategoriaJpa;

import javax.persistence.EntityManager;

public class CategoriaDao {
  private  final EntityManager entityManeger;

  public CategoriaDao(EntityManager em) {
    this.entityManeger = em;
  }

  public  void save(CategoriaJpa categoriaJpa) {
    entityManeger.persist(categoriaJpa);
  }

}
