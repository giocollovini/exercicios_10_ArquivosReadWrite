package Entidade;

public class Produto { 
	
	private String produto;
	private Double valor;
	private Integer quantidade; 
	private Double total;
	
	public Produto() {
		
	}
	
	public Produto(String produto, Double valor, Integer quantidade) {
		this.produto = produto;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Double ValorTotal() {
		return quantidade * valor;
	}

}
