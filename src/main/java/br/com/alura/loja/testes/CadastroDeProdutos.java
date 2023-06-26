package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.CategoriaJpa;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JpaUtil;
import javax.persistence.EntityManager;
import java.util.List;


public class CadastroDeProdutos {

  public static void main(String[] args) {
    EntityManager entityManager = JpaUtil.getEntityManager();
    ProdutoDao produtoDao = new ProdutoDao(entityManager);

    cadastrarProduto();

    // pegando um produto especifico no banco
    var produto = produtoDao.findById(1L);
    String msg = produto != null ?  "O preço do produto é: " + produto.getPreco() : "Produto não encontrado";
    System.out.println(msg);

    // carregar todos os produtos do banco
    List<Produto> produtos = produtoDao.findAll();

    for (Produto p : produtos) {
      System.out.println(p.getNome());
    }




  }

  private static void cadastrarProduto() {
    EntityManager entityManager = JpaUtil.getEntityManager();

    // criando uma instancia para a tabela
    CategoriaJpa celulares = new CategoriaJpa("Celulares");

    // criando um acesso aos metodos do banco de dados
    CategoriaDao categoriaDao = new CategoriaDao(entityManager);


    // criando uma instancia para a tabela
    Produto celular = new Produto("Xiami Readmi", "Muito legal", 800, celulares);
    Produto celular2 = new Produto("Xiami Readmi2", "Muito legal2", 300, celulares);

    // criando um acesso aos metodos do banco de dados
    ProdutoDao produtoDao = new ProdutoDao(entityManager);

    // inserir no banco de dados persistir colocar
    entityManager.getTransaction().begin();

    // salvando no banco a categoria celulares no banco
    categoriaDao.save(celulares);

    // salvando no banco o objeto celular que tem uma categoria associado a ele
    produtoDao.save(celular);
    produtoDao.save(celular2);

    entityManager.getTransaction().commit();
    entityManager.close();
  }
}
