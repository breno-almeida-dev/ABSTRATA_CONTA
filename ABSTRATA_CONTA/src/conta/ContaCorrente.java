package conta;

/*
 * Esta sub classe da super classe "ContaBancaria" define um atributo que a torna
 * única, que é uma variável para o limite especial que a pessoa que possui está
 * conta tem como benefício, sendo esse atributo já possuindo seu valor determinado.
 */
public class ContaCorrente extends ContaBancaria {
	private double limiteEspecial = 200.00;

	/*
	 * Contrutores da classe, sendo um sem parâmetros para que seja
	 * criado o objeto sem valores inicialmente, assim sendo utilizado o
	 * setter para atribuir o valor ao atributo "saldoConta", e outro
	 * construtor com o parâmetro "saldoConta" e a chamada do construtor
	 * da super classe.
	 * 
	 * 
	 */
	public ContaCorrente() {
	}
	
	public ContaCorrente(double saldoConta) {
		super(saldoConta);
	}
	
	/*
	 * Método de saque da conta, quando chamado, primeiramente ele realiza o cálculo
	 * da taxa de saque multiplicando o valor informado pela porcentagem da taxa, armazenando o
	 * resultado na variável "taxaSaque".
	 * 
	 * Então aparece a primeira condição "if" que verifica se o saldo informado é capaz de suprir
	 * o valor de saque, caso seja realiza a subtração do saque pelo valor de saldo, e informado
	 * ao usuário uma mensagem de sucesso na operação.
	 * 
	 * Caso o saldo sozinho não seja o suficiente, uma condição "else if" verifica se o valor de saldo
	 * informado mais o valor de limite especial determinado é capaz de cobrir o valor de saque, caso
	 * a condição seja real é declarada uma variável de limite utilizado, para que assim seja
	 * realizado o cálculo de quanto foi utilizado para que o valor de limite especial seja
	 * atualizado com a subtração de quanto foi utilizado para realizar o saque. Ainda dentro
	 * da consição "else if" o valor de saldo é zerado através do setter. E por fim é informada a
	 * mensagem para o usuário de sucesso na operação.
	 * 
	 * Caso nenhuma das condições "if" seja real, através do "else" é informado ao usuário a mensagem
	 * de que a operação não foi possível, pois o valor excedeu o saldo e limite somados.
	 * 
	 * Para concluir a execução do método é informado ao usuário o saldo atual e o limite atual.
	 */
	@Override
	public void saque(double valorSaque) {
		taxaSaque = valorSaque * 0.02;
		if (getSaldoConta() >= valorSaque + taxaSaque) {
			setSaldoConta(getSaldoConta() - valorSaque - taxaSaque);
            System.out.println("Saque de R$" + df.format(valorSaque) + " realizado com sucesso. Taxa de 2% no valor de R$" + df.format(taxaSaque) + " aplicada.");
		
		} else if (getSaldoConta() + limiteEspecial >= valorSaque + taxaSaque) {
			double limiteEspecialUtilizado1 = (valorSaque + taxaSaque) - getSaldoConta();
			setSaldoConta(0);
			limiteEspecial = limiteEspecial - limiteEspecialUtilizado1;
			System.out.println("Saque de R$" + df.format(valorSaque) + " realizado com sucesso. Taxa de 2% no valor de " + df.format(taxaSaque) + " aplicada.");
            System.out.println("Limite especial utilizado: R$" + df.format(limiteEspecialUtilizado1) + "\n");
		} else {
			System.out.println("Saque de R$" + df.format(valorSaque) + " não autorizado! O valor excede o saldo e limite da conta.");
		}
		System.out.println("Saldo atual de R$" + df.format(getSaldoConta()));
		System.out.println("Limite especial atual: R$" + df.format(limiteEspecial) + "\n\n");
	}
	
	/*
	 * Este método de depósito primeiramente faz o cálculo da taxa multiplicando o valor
	 * de depósito pela taxa de porcentagem informada.
	 * 
	 * Logo em seguida é realizado o cálculo de soma do valor depositado menos a taxa
	 * calculada mais o saldo atual da conta.
	 * 
	 * E então acontece uma condição "if" para ser verificado se o limite especial da
	 * conta é menor que R$200,00, caso seja indica que foi utilizado. Assim é declarada
	 * uma variável para restaurar o limite especial, essa variável utiliza o método
	 * Math.min para realizar o cálculo, de modo que, primeiramente é feita a subtração
	 * de 200 pelo limite especial, para saber o quanto foi usado, e então esse valor usado
	 * é restaurado baseado no saldo da conta disponível.
	 * 
	 * E então é informada a mensagem de sucesso na operação.
	 */
	@Override
	public void deposito(double valorDeposito) {
		taxaDeposito = valorDeposito * 0.01;
		setSaldoConta(getSaldoConta() + valorDeposito - taxaDeposito);
        if (limiteEspecial < 200.00) {
            double limiteRestaurado = Math.min(200.00 - limiteEspecial, getSaldoConta());
            limiteEspecial += limiteRestaurado;
            setSaldoConta(getSaldoConta() - limiteRestaurado);
        }
		System.out.println("Depósito de R$" + df.format(valorDeposito) + " realizado com sucesso. Taxa de 1% no valor " + df.format(taxaDeposito) + " aplicada.");
		System.out.println("Saldo atual de R$" + df.format(getSaldoConta()));
		System.out.println("Limite Especial atual: R$" + df.format(limiteEspecial) + "\n\n");
	}
	
	/*
	 * Este método de consulta primeiramente verifica se o saldo da conta
	 * é superior a 0 para poder ser calculada a taxa de consulta, caso não seja
	 * é utilizado o limite especial disponível para cálculo da taxa no "else".
	 * 
	 * Após o cálculo da taxa outra condição "if" aparece, mas nessa é verificado se
	 * o saldo disponível é superior ao valor da taxa para poder ser cobrada.
	 * caso não seja é cobrada sobre o valor do limite especial.
	 * Mas se nenhuma dessas condições "if" sejam reais é retornado a mensagem de que
	 * o saldo é insuficiente e então por fim é retornado o status atual da conta.
	 * 
	 * 
	 */
	@Override
	public void consulta() {
	    if (getSaldoConta() > 0) {
	        taxaConsulta = getSaldoConta() * 0.002;
	    } else {
	        taxaConsulta = limiteEspecial * 0.002;
	    }		
		if (getSaldoConta() >= taxaConsulta) {
			setSaldoConta(getSaldoConta() - taxaConsulta);
			System.out.println("Consulta realizada com sucesso! Taxa de 0,2% aplicada, no valor de R$" + df.format(taxaConsulta));
		} else if (getSaldoConta() + limiteEspecial >= taxaConsulta) {
			double limiteEspecialUtilizado2 = taxaConsulta - getSaldoConta();
			setSaldoConta(0);
			limiteEspecial -= limiteEspecialUtilizado2;
			System.out.println("Consulta realizada com sucesso! Taxa de 0,2% aplicada, no valor de R$" + df.format(taxaConsulta));
            System.out.println("Limite especial utilizado: R$" + df.format(limiteEspecialUtilizado2) + "\n");
		} else {
			System.out.println("A Taxa de consulta ultrapassa o saldo e limite da conta!\n Regularize a atual situação da sua conta!");
		}
		System.out.println("Saldo atual: R$" + df.format(getSaldoConta()));
		System.out.println("Limite Especial atual: R$" + df.format(limiteEspecial) + "\n\n");
	}
	
}
