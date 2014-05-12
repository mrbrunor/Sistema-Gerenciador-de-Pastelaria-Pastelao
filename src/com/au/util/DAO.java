package com.au.util;

import com.au.modelo.Caixa;
import com.au.modelo.Fornecedor;
import com.au.modelo.Funcionario;
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
        EntityManager em = new JPAUtil().getEntityManager();

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
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.remove(em.merge(t));

        em.getTransaction().commit();
        em.close();
    }

    public void atualiza(T t) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.merge(t);

        em.getTransaction().commit();
        em.close();
    }

    public List<T> listaTodos() {
        EntityManager em = new JPAUtil().getEntityManager();
        CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));

        List<T> lista = em.createQuery(query).getResultList();

        em.close();
        return lista;
    }

    public T buscaPorId(Integer id) {
        EntityManager em = new JPAUtil().getEntityManager();
        T instancia = em.find(classe, id);
        em.close();
        return instancia;
    }

    public int contaTodos() {
        EntityManager em = new JPAUtil().getEntityManager();
        long result = (Long) em.createQuery("select count(n) from livro n")
                .getSingleResult();
        em.close();
        return (int) result;
    }

    public Funcionario buscarLogin(String usuario, String senha) {
        EntityManager em = new JPAUtil().getEntityManager();
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

    public List<Produto> buscaProduto(String pesquisa) {
        EntityManager em = new JPAUtil().getEntityManager();

        Query q = em.createQuery("from Produto p where p.descProd like '%" + pesquisa + "%'  or p.idProd like '" + pesquisa + "'");

        List<Produto> produtos = q.getResultList();

        return produtos;
    }
    
    public List<Fornecedor> buscaFornecedor(String pesquisa) {
        EntityManager em = new JPAUtil().getEntityManager();

        Query q = em.createQuery("from Fornecedor f where f.nomeForn like '%" + pesquisa + "%'");

        List<Fornecedor> fornecedores = q.getResultList();

        return fornecedores;
    }
}
