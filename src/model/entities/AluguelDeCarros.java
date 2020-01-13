package model.entities;

import java.util.Date;

public class AluguelDeCarros {
	private Date inicial;
	private Date finall;

	private Veiculo veiculo;
	private Invoice invoice;

	public AluguelDeCarros() {
		// TODO Auto-generated constructor stub
	}

	public AluguelDeCarros(Date inicial, Date finall, Veiculo veiculo) {
		this.inicial = inicial;
		this.finall = finall;
		this.veiculo = veiculo;
	}

	public Date getInicial() {
		return inicial;
	}

	public void setInicial(Date inicial) {
		this.inicial = inicial;
	}

	public Date getFinall() {
		return finall;
	}

	public void setFinall(Date finall) {
		this.finall = finall;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}
