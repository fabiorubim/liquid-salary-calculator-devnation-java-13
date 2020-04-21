package br.com.codenation.calculadora;

public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		// Use o Math.round apenas no final do método para arredondar o valor final.
		// Documentação do método:
		// https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		final double SALARIO_MINIMO = 1039.00;
		double valorInss;
		double valorSalarioMenosInss;
		double valorSalarioMenosIrrf;
		double valorSalarioComDescontos;

		if (salarioBase < SALARIO_MINIMO) {
			return 0;
		} else {

			valorInss = calcularInss(salarioBase);
			valorSalarioMenosInss = salarioBase - valorInss;
			valorSalarioMenosIrrf = calcularIRRF(salarioBase, valorSalarioMenosInss);
			valorSalarioComDescontos = valorSalarioMenosInss - valorSalarioMenosIrrf;
		}
		return Math.round(valorSalarioComDescontos);
	}

	// Exemplo de método que pode ser criado para separar melhor as
	// responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {

		double porcentagemDesconto;
		double valorInss;
		if (salarioBase <= 1500.00) {
			porcentagemDesconto = 0.08;
		} else if (salarioBase > 1500.00 & salarioBase <= 4000.00) {
			porcentagemDesconto = 0.09;
		} else {
			porcentagemDesconto = 0.11;
		}

		valorInss = salarioBase * porcentagemDesconto;

		return valorInss;
	}

	private double calcularIRRF(double salarioBase, double valorSalarioMenosInss) {
		double porcentagemIRRF;
		double valorIRRF;

		if (valorSalarioMenosInss <= 3000.00) {
			porcentagemIRRF = 0.00;
		} else if (valorSalarioMenosInss > 3000.00 & valorSalarioMenosInss <= 6000.00) {
			porcentagemIRRF = 0.075;
		} else {
			porcentagemIRRF = 0.15;
		}

		valorIRRF = valorSalarioMenosInss * porcentagemIRRF;

		return valorIRRF;
	}
}

/*
 * Dúvidas ou Problemas? Manda e-mail para o meajuda@codenation.dev que iremos
 * te ajudar!
 */