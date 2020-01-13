package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.AluguelDeCarros;
import model.entities.Veiculo;
import model.services.BrasilImpostoDeServico;
import model.services.ServicoDeAluguel;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Insira os dados do Aluguel: ");
		System.out.println("Modelo do Carro: ");
		String modeloDoCarro = sc.nextLine();
		System.out.println("Pickup (dd/MM/yyyy  hh:ss): ");
		Date inicial = sdf.parse(sc.nextLine());
		System.out.println("return (dd/MM/yyyy hh:ss): ");
		Date finall = sdf.parse(sc.nextLine());
		
		AluguelDeCarros ac =new AluguelDeCarros(inicial, finall, new Veiculo(modeloDoCarro));
		
		System.out.println("Insira o preço por hora: ");
		double precoPorHora = sc.nextDouble();
		System.out.println("Insira o preço por dia: ");
		double precoPorDia = sc.nextDouble();
		
		ServicoDeAluguel servicoDeAluguel = new  ServicoDeAluguel(precoPorDia, precoPorHora, new BrasilImpostoDeServico());
		
		servicoDeAluguel.processarFatura(ac);
		
		System.out.println("Invoice: ");
		System.out.println("Pagamento basico: " + String.format("%.2f",ac.getInvoice().getPagamentoBasico()));
		System.out.println("Imposto: " + String.format("%.2f",ac.getInvoice().getImposto()));
		System.out.println("Pagamento Total: " + String.format("%.2f",ac.getInvoice().getPagamentoTotal()));
		
		sc.close();
		
		
		
	}

}
