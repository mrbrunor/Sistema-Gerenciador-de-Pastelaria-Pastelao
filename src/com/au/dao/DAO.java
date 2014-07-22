package com.au.dao;

import com.au.conexao.FabricaConexaoJPA;
import com.au.modelo.Caixa;
import com.au.modelo.FormaPagamento;
import com.au.modelo.Funcionario;
import com.au.modelo.Ingrediente;
import com.au.modelo.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public class DAO<T> {

    private final Class<T> classe;

    public DAO(Class<T> classe) {
        this.classe = classe;
    }

    public void adiciona(T t) {

        // consegue a entity manager
        EntityManager em = new FabricaConexaoJPA().getEntityManager();

        // abre transacao
        em.getTransaction().begin();

        // persiste o objeto
        em.persist(t);

        // commita a transacao
        em.getTransaction().commit();

        // fecha a entity manager
        em.close();
    }

    public void remove(T t) {
        EntityManager em = new FabricaConexaoJPA().getEntityManager();
        em.getTransaction().begin();

        em.remove(em.merge(t));

        em.getTransaction().commit();
        em.close();
    }

    public void atualiza(T t) {
        EntityManager em = new FabricaConexaoJPA().getEntityManager();
        em.getTransaction().begin();

        em.merge(t);

        em.getTransaction().commit();
        em.close();
    }

    public List<T> listaTodos() {
        EntityManager em = new FabricaConexaoJPA().getEntityManager();
        CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));

        List<T> lista = em.createQuery(query).getResultList();

        em.close();
        return lista;
    }

    public T buscaPorId(Integer id) {
        EntityManager em = new FabricaConexaoJPA().getEntityManager();
        T instancia = em.find(classe, id);
        em.close();
        return instancia;
    }

    public int contaTodos() {
        EntityManager em = new FabricaConexaoJPA().getEntityManager();
        long result = (Long) em.createQuery("select count(n) from livro n")
                .getSingleResult();
        em.close();
        return (int) result;
    }
    
    public Produto buscaCodigo (int numProd){
        EntityManager em = new FabricaConexaoJPA().getEntityManager();
        Produto produto = new Produto();
        
        Query q = em.createQuery("from Produto p where p.numProd='" + numProd + "'");
        
        List<Produto> produtos = q.getResultList();
        
        if (produtos.isEmpty()) {
            return null;
        }
        for (Produto produto1 : produtos) {
            produto = produto1;
        }
        return produto;
    }

    public Funcionario buscarLogin(String usuario, String senha) {
        EntityManager em = new FabricaConexaoJPA().getEntityManager();
        Funcionario funcionario = new Funcionario();

        Query q = em.createQuery("from Funcionario f where f.userFunc='" + usuario + "'  and f.passFunc='" + senha + "'");

        List<Funcionario> funcionarios = q.getResultList();

        if (funcionarios.isEmpty()) {
            return null;
        }
        for (Funcionario funcionario1 : funcionarios) {
            funcionario = funcionario1;
        }
        return funcionario;
    }

    public List<Produto> buscaProdutos(String pesquisa) {
        EntityManager em = new FabricaConexaoJPA().getEntityManager();

        Query q = em.createQuery("from Produto p where p.descProd like '%" + pesquisa + "%'  or p.idProd like '" + pesquisa + "'");

        List<Produto> produtos = q.getResultList();

        return produtos;
    }

    public List<Funcionario> buscaFuncionarios(String pesquisa) {
        EntityManager em = new FabricaConexaoJPA().getEntityManager();

        Query q = em.createQuery("from Funcionario f where f.nomeFunc like '%" + pesquisa + "%'");

        List<Funcionario> funcionarios = q.getResultList();

        return funcionarios;
    }

    public List<Ingrediente> buscaIngredientes(String pesquisa) {
        EntityManager em = new FabricaConexaoJPA().getEntityManager();

        Query q = em.createQuery("from Ingrediente i where i.descIng like '%" + pesquisa + "%'");

        List<Ingrediente> ingredientes = q.getResultList();

        return ingredientes;
    }

    public List<Caixa> buscaCaixas(String data, boolean estaAberto) {
        EntityManager em = new FabricaConexaoJPA().getEntityManager();
        Query q;

        if (estaAberto == true) {
            q = em.createQuery("from Caixa i where i.dataAberturaCaixa like '%" + data + "%'");
        } else {
            q = em.createQuery("from Caixa i where i.dataAberturaCaixa like '%" + data + "%' and i.estaAberto like 0");
        }

        List<Caixa> caixas = q.getResultList();

        return caixas;
    }

    public List<FormaPagamento> buscaFormasPagamento(String pesquisa) {
        EntityManager em = new FabricaConexaoJPA().getEntityManager();

        Query q = em.createQuery("from FormaPagamento fp where fp.nomeFormaPgto like '%" + pesquisa + "%'");

        List<FormaPagamento> formaPagamentos = q.getResultList();

        return formaPagamentos;
    }

    public boolean validaUser(Funcionario funcionario) {
        EntityManager em = new FabricaConexaoJPA().getEntityManager();

        Query q = em.createQuery("from Funcionario f where f.userFunc like '" + funcionario.getUserFunc() + "'");

        List<Funcionario> funcionarios = q.getResultList();

        return funcionarios == null || funcionarios.isEmpty();
    }

    public boolean validaCPF(Funcionario funcionario) {
        EntityManager em = new FabricaConexaoJPA().getEntityManager();

        Query q = em.createQuery("from Funcionario f where f.cpfFunc like '" + funcionario.getCpfFunc() + "'");

        List<Funcionario> funcionarios = q.getResultList();

        return funcionarios == null || funcionarios.isEmpty();
    }

    public void alterarSenha(Funcionario funcionario) {
        EntityManager em = new FabricaConexaoJPA().getEntityManager();

        Funcionario funcionarioNovo = new Funcionario();
        //Query q = em.createQuery("update Funcionario f set f.passFunc = '" + funcionario.getPassFunc() + "' where f.cpfFunc like '" + funcionario.getCpfFunc() + "'");

        Query q = em.createQuery("from Funcionario f where f.cpfFunc like '" + funcionario.getCpfFunc() + "'");

        List<Funcionario> funcionarios = q.getResultList();

        for (Funcionario funcionario1 : funcionarios) {
            funcionarioNovo = funcionario1;
        }

        funcionarioNovo.setPassFunc(funcionario.getPassFunc());
        System.out.println("");
        new DAO<>(Funcionario.class).atualiza(funcionarioNovo);
    }

    public boolean validaDescProduto(Produto produto) {
        EntityManager em = new FabricaConexaoJPA().getEntityManager();

        Query q = em.createQuery("from Produto p where p.descProd like '" + produto.getDescProd() + "' or p.numProd = '" + produto.getNumProd() + "'");

        List<Produto> produtos = q.getResultList();

        return produtos == null || produtos.isEmpty();
    }
    
    public boolean validaCodProduto(Produto produto) {
        EntityManager em = new FabricaConexaoJPA().getEntityManager();

        Query q = em.createQuery("from Produto p where p.numProd = '" + produto.getNumProd() + "'");

        List<Produto> produtos = q.getResultList();

        return produtos == null || produtos.isEmpty();
    }

    public boolean validaIngrediente(Ingrediente ingrediente) {
        EntityManager em = new FabricaConexaoJPA().getEntityManager();

        Query q = em.createQuery("from Ingrediente i where i.descIng like '" + ingrediente.getDescIng() + "'");

        List<Ingrediente> ingredientes = q.getResultList();

        return ingredientes == null || ingredientes.isEmpty();
    }
}
