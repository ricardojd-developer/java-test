package com.kurtphpr.sistema.produto;

import java.util.List;

public interface ProdutoDAO {

	public void salvar(Produto produto);

	public List<Produto> listar();

	public void excluir(Produto produto);

	public Produto pesquisar(String produto);

	public void alterar(Produto produto);
	
}
