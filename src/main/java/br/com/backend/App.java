package br.com.backend;

import java.math.BigDecimal;

/**
 * Teste técnico para a vaga de dev jr do grupo primo
 *
 */
public final class App {
  private App() {
  }

  /**
   *
   * @param args The arguments of the program.
   */
  public static void main(String[] args) {
    double taxa = 0.0425;
    double investimento = 100.00;
    int semanas = 36;
    int tempo = 180; // tempo = 5 * 36 (numero de dias uteis na semana) = 180

    BigDecimal taxaSemanal = Calculo.calcularTaxaSemanal(taxa);
    BigDecimal renda = Calculo.calcularRenda(BigDecimal.valueOf(taxa), investimento, tempo);
    BigDecimal rendaAporte = Calculo.calcularRendaAporte(taxaSemanal, investimento, semanas);
    BigDecimal poupado = Calculo.calcularPoupado(rendaAporte, investimento, semanas);

    String texto = String.format("Renda baseada na formula da questão: R$ %.2f"+
    "\nRenda baseada na formula de juros composto com aporte: R$ %.2f"+
    "\nLucro do investimento: R$ %.2f",renda,rendaAporte,poupado);

    System.out.println(texto);

  }
}
