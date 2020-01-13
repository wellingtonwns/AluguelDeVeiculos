package model.services;

public class BrasilImpostoDeServico implements ImpostoDeServico {
	public double imposto (double montante) {
		if(montante <= 100.0) {
			return montante * 0.2;
			
		}else {
			return montante * 0.15 ;
		}
		
		
	}
	

}
