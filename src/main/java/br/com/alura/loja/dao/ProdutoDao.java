package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDao {
  private final EntityManager entityManager;

  public ProdutoDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void save(Produto produto) {
    entityManager.persist(produto);
  }

  public void update(Produto produto) {
    // mudando o estado da estidade e com isso ele realiza o update
    this.entityManager.merge(produto);
  }

  public void delete(Produto produto) {
    produto = entityManager.merge(produto);
    this.entityManager.remove(produto);
  }

  public Produto findById(long id) {
    return entityManager.find(Produto.class, id);
  }

  public List<Produto> findAll() {
    String jpql = "SELECT p FROM Produto p";
    return entityManager.createQuery(jpql, Produto.class).getResultList();
  }

  public List<Produto> findAllName(String name) {
    String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
    return entityManager.createQuery(jpql, Produto.class)
            .setParameter("nome", name)
            .getResultList();
  }

  public List<Produto> findAllNameCategory(String name) {
    String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
    return entityManager.createQuery(jpql, Produto.class)
            .setParameter("nome", name)
            .getResultList();
  }

  public double findPrecoProdutoName(String name) {
    String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
    return entityManager.createQuery(jpql, Double.class)
            .setParameter("nome", name)
            .getSingleResult();

  }
}
