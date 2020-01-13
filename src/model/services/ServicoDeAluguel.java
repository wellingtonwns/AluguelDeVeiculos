package model.services;

import model.entities.AluguelDeCarros;
import model.entities.Invoice;

public class ServicoDeAluguel {
	
	private Double precoPorDia;
	private Double precoPorHora;
	
	private ImpostoDeServico impostoDeServico;

	public ServicoDeAluguel(Double precoPorDia, Double precoPorHora, ImpostoDeServico impostoDeServico) {
		super();
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.impostoDeServico = impostoDeServico;
	}
	
	public void processarFatura(AluguelDeCarros aluguelDeCarros) {
		long t1 = aluguelDeCarros.getInicial().getTime();
		long t2 = aluguelDeCarros.getFinall().getTime();
		double horas = (double) (t2-t1) / 1000 / 60 / 60;
		
		double pagamentoBasico;
		if(horas <= 12.0) {
			pagamentoBasico = Math.ceil(horas) * precoPorHora;
		}
		
		else {
			pagamentoBasico = Math.ceil(horas /24 ) * precoPorDia;
			
		}
		
		double imposto = impostoDeServico.imposto(pagamentoBasico);
		
		aluguelDeCarros.setInvoice(new Invoice(pagamentoBasico, imposto));
		
	}
	
	
	

}
