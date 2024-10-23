package conta;

/*
 * Primeiramente foi realizada a importação do método que
 * transforma o formato dos valores armazenados em variaveis
 * double, para que seja retornado apenas dois dígitos após a
 * vírgula.
 */
import java.text.DecimalFormat;

/*
 * Essa super classe é definida como abstrata para que suas sub classes
 * possam herdar seus atributos e métodos a serem sobrescritos, de modo que
 * uma intância direta dela não possam acontecer.
 */
public abstract class ContaBancaria {
	private double saldoConta;
	double taxaSaque;
	double taxaDeposito;
	double taxaConsulta;
	DecimalFormat df = new DecimalFormat("#0.00");
	
	/*
	 * Construtores da classe, sendo um vazio para que possa ser criado um objeto
	 * sem parâmetros, para que o valor seja atribuído através do setter, e outro 
	 * com o saldoConta como parâmetro para inicialização do atributo.
	 */
	public ContaBancaria() {
	}
	
	public ContaBancaria(double saldoConta) {
		this.saldoConta = saldoConta;
	}
	 /*
	  * Métodos de saque, depósito e consulta que o projeto irá poder executar.
	  * Sendo declarados como abstratos para que sejam sobrescritos nas sub classes.
	  */
    public abstract void saque(double valorSaque);
    public abstract void deposito(double valorDeposito);
    public abstract void consulta();
    
    /*
     * Setter e getter do atributo saldoConta, para encapsulamento.
     */
    public void setSaldoConta(double saldoConta) {
    	this.saldoConta = saldoConta;
    }
    
    public double getSaldoConta() {
    	return saldoConta;
    }
    
}
