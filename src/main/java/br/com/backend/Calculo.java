package br.com.backend;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Classe que faz as operações de calculo
 */
public class Calculo {
  /**
   * calcula a renda com a formula passada na questão M=p*(1+i)t
   * formula de juros composto, não é a formulada usada para calcular aportes mensais
   */
  public static BigDecimal calcularRenda(BigDecimal taxa, double investimento, int tempo) {
    double valor = investimento*Math.pow((1+taxa.doubleValue()), (tempo/252.00));
    return BigDecimal.valueOf(valor).setScale(2, RoundingMode.DOWN);
  }

  /**
   * Calcula a diferença do montate pelo valor investido com aportes
   */
  public static BigDecimal calcularPoupado(BigDecimal rendido, double investimento, int semanas) {
    BigDecimal valor = rendido.subtract(new BigDecimal(investimento).multiply(new BigDecimal(semanas)));
    return valor.setScale(2, RoundingMode.DOWN);
  }

  /**
   * [taxa efetivas ou taxa equivalentes]
   * converte taxa anual para taxa semanal em juros composto
   */
  public static BigDecimal calcularTaxaSemanal(double taxa) {
    double variavel1 = 1 + taxa;
    double variavel2 = 1/52.00;
    double valor = Math.pow(variavel1, variavel2)-1;

    return BigDecimal.valueOf(valor).setScale(6, RoundingMode.DOWN);
  }

  /**
   * calcula a renda com a formula de juros composto com aporte
   * formula -> FV = (P*(((1+i)^n)-1))/i
   * fv = valor futuro | P = aportes samanais | i = taxa de juros semanal | n = semanas
   */
  public static BigDecimal calcularRendaAporte(BigDecimal taxa, double investimento, int semanas) {
    double variavel1 = 1 + taxa.doubleValue();
    double valor = (investimento*(Math.pow(variavel1, Double.valueOf(Integer.toString(semanas)))-1))/taxa.doubleValue();
    return BigDecimal.valueOf(valor).setScale(2, RoundingMode.DOWN);
  }
}
