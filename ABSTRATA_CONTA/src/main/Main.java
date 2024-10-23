package main;

/*
 * Aqui foi realizado o import do pacote "conta" e suas classes
 * para serem utilizados.
 */
import conta.*;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Aqui é criado um objeto da classe "ContaCorrente", na instância é
		 * informado o saldo da conta no valor de R$750,00 para ser
		 * usado nos testes, utilizando o setter de saldo.
		 */
		ContaCorrente contaCorrente1 = new ContaCorrente();
		contaCorrente1.setSaldoConta(750.00);
		
		/*
		 * Laço "for" para executar alguns método de consulta,
		 * para verificar se o cálculo está correto.
		 */
		for (int i = 0; i < 5; i++) {
			contaCorrente1.consulta();
		}
		
		/*
		 * Execução dos métodos da classe para testes, informando o valor para
		 * os métodos de saque e depósito.
		 */
		contaCorrente1.saque(253.00);
		contaCorrente1.saque(51.50);
		contaCorrente1.saque(101.20);
		
		contaCorrente1.consulta();
		
		contaCorrente1.deposito(500.05);
		
		contaCorrente1.consulta();
		
		contaCorrente1.saque(900.00);		
		contaCorrente1.saque(101.00);
		
		contaCorrente1.deposito(100.00);		
		contaCorrente1.deposito(105.00);
		
		contaCorrente1.consulta();
		
		
		//Quebra de linha para melhorar a legibilidade no terminal.
		System.out.println("\n\n\n\n");
		
		/*
		 * Aqui foi criado um objeto da classe "ContaPoupanca", sendo informado,
		 * através do setter, o valor de saldo da conta no valor de R$500,00 para
		 * ser testado os métodos.
		 */
		ContaPoupanca contaPoupanca1 = new ContaPoupanca();
		contaPoupanca1.setSaldoConta(500.00);
		
		/*
		 * Foi executado alguns métodos da classe para testes.
		 * Sendo que na chamada  dos métodos de saque e depósito foi informdado
		 * os valores para serem trabalhados.
		 */
		contaPoupanca1.consulta();
		contaPoupanca1.consulta();
		
		contaPoupanca1.deposito(120.23);
		
		contaPoupanca1.saque(30.45);
		contaPoupanca1.saque(56.87);
		
		contaPoupanca1.consulta();
		
		contaPoupanca1.deposito(400.00);
		
		contaPoupanca1.saque(1000.00);
		

	}

}