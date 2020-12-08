package com.kurtphpr.sistema.produto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

public class ProdutoDAOHibernate implements ProdutoDAO {

	private Session sessao;
	
	@Override
	public void salvar(Produto produto) {
		this.sessao.save(produto);
	}

	public Session getSessao() {
		return sessao;
	}

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> listar() {
		Criteria lista = sessao.createCriteria(Produto.class);
		return lista.list();
	}

	@Override
	public void excluir(Produto produto) {
		this.sessao.delete(produto);
		
	}

	@Override
	public Produto pesquisar(String string) {
		Query consultaDescricao = this.sessao.createQuery("FROM Produto p WHERE p.descricao like :descricao");
		consultaDescricao.setString("descricao", "%"+string+"%");
		return (Produto) consultaDescricao.uniqueResult();
	}

	@Override
	public void alterar(Produto produto) {
		this.sessao.update(produto);
		
	}
	
}
