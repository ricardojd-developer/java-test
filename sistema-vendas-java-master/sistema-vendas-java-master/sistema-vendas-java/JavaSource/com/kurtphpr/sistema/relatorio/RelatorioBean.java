package com.kurtphpr.sistema.relatorio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.kurtphpr.sistema.cliente.Cliente;
import com.kurtphpr.sistema.cliente.ClienteRN;

@ManagedBean(name = "relatorio")
@ViewScoped
public class RelatorioBean {

	private Cliente clienteSelecionado;
	private List<SelectItem> clientesSelect;
	
	public List<SelectItem> getClientesSelect() {
		if(clientesSelect == null) {
			clientesSelect = new ArrayList<SelectItem>();
			ClienteRN clienteRN = new ClienteRN();
			List<Cliente> listaClientes = clienteRN.listar();
			if(listaClientes != null && !listaClientes.isEmpty()) {
				SelectItem item;
				for (Cliente clienteLista : listaClientes) {
					item = new SelectItem(clienteLista, clienteLista.getNome());
					clientesSelect.add(item);
				}
			}
		}
		return clientesSelect;
	}

	public String geraRelatorio() {
		return null;
	}
	
	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public void setClientesSelect(List<SelectItem> clientesSelect) {
		this.clientesSelect = clientesSelect;
	}
		
}
