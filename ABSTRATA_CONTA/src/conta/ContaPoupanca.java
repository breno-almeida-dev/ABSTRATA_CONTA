package conta;

/*
 * Esta sub classe herda os atributos e métodos da super classe.
 */
public class ContaPoupanca extends ContaBancaria {

	/*
	 * Contrutores da classe, sendo um sem parâmetros para que seja
	 * criado o objeto sem valores inicialmente, assim sendo utilizado o
	 * setter para atribuir o valor ao atributo "saldoConta", e outro
	 * construtor com o parâmetro "saldoConta" e a chamada do construtor
	 * da super classe.
	 */
	public ContaPoupanca() {
	}
	
	public ContaPoupanca(double saldoConta) {
		super(saldoConta);
	}
	
	/*
	 * Método de saque da conta, quando chamado, primeiramente ele realiza o cálculo
	 * da taxa de saque multiplicando o valor informado pela porcentagem da taxa, armazenando o
	 * resultado na variável "taxaSaque".
	 * 
	 * Então acontece uma condição "if" para que seja verificado se o valor de saque mais
	 * a taxa de saque é menor ou igual ao valor disponível na conta, caso seja o saque é
	 * realizado e informado ao usuário, caso não seja é informada uma mensagem de saldo
	 * indisponível para o usuário no "else".
	 * 
	 * Por fim é informado o saldo atual da conta.
	 */
	@Override
	public void saque(double valorSaque) {
		taxaSaque = valorSaque * 0.01;
		if (getSaldoConta() >= valorSaque + taxaSaque) {
			setSaldoConta(getSaldoConta() - valorSaque - taxaSaque);
			System.out.println("Saque de R$" + df.format(valorSaque) + " realizado com sucesso. Taxa de 1 % no valor de " + df.format(taxaSaque) + " aplicada.");
		} else {
			System.out.println("Saque de R$" + df.format(valorSaque) + " não autorizado! O valor excede o saldo e limite da conta.");
		}
		System.out.println("Saldo atual de R$" + df.format(getSaldoConta()) + "\n\n");
	}
	
	/*
	 * Este método de depósito recebe o valor informado a ser depositado, e
	 * primeiramente realiza o cálculo da taxa de depósito, multiplicando o
	 * valor a ser depositado pela porcentagem da taxa.
	 * 
	 * Logo em seguida é atualizado o valor do saldo da conta somando o saldo atual
	 * mais o valor depositado menos a taxa.
	 * 
	 * Por fim é informado ao usuário o status da conta.
	 */
	@Override
	public void deposito(double valorDeposito) {
		taxaDeposito = valorDeposito * 0.005;
		setSaldoConta(getSaldoConta() + valorDeposito - taxaDeposito);
		System.out.println("Depósito de R$" + df.format(valorDeposito) + " realizado com sucesso. Taxa de 0,5% no valor " + df.format(taxaDeposito) + " aplicada.");
		System.out.println("Saldo atual de R$" + df.format(getSaldoConta()) + "\n\n");
	}
	
	/*
	 * Este método de consulta primeiramente realiza o cálculo da taxa de
	 * consulta, multiplicando o saldo da conta pela porcentagem da taxa.
	 * E utiliza a taxa calculada para atualizar o valor do saldo utilizando o
	 * setter e realizando a subtração do saldo atual pela taxa.
	 * 
	 * E por fim é informado o status da conta ao usuário.
	 */
	@Override
	public void consulta() {
		taxaConsulta = getSaldoConta() * 0.001;
		setSaldoConta(getSaldoConta() - taxaConsulta);
		System.out.println("Consulta realizada com sucesso! Taxa de 0,1% aplicada, no valor de R$" + df.format(taxaConsulta));
		System.out.println("Saldo atual: R$"+ df.format(getSaldoConta()) +"\n\n");
	}
	
}
