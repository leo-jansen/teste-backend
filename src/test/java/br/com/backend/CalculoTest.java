package br.com.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

/**
 * Classe de teste do Calculo.java.
 */
public class CalculoTest {
  /**
   * Teste da função calcularRenda()
   */
  @Test
  public void testCalcularRenda() {
    BigDecimal taxa = new BigDecimal("0.0425");
    double investimento = 100.00;
    int tempo = 128; // 128 dias = 5 * 36 {só dias uteis}

    BigDecimal resultado = Calculo.calcularRenda(taxa, investimento, tempo);

    assertEquals(resultado, new BigDecimal("102.13"));
  }

  /**
   * Teste da função calcularPoupado()
   */
  @Test
  public void testCalcularPoupado() {
    BigDecimal rendido = new BigDecimal("13472.64");
    double investimento = 100.00;
    int semanas = 36;

    BigDecimal resultado = Calculo.calcularPoupado(rendido, investimento, semanas);

    assertEquals(resultado, new BigDecimal("9872.64"));
  }

  /**
   * Teste da função calcularTaxaMensal()
   */
  @Test
  public void testCalcularTaxaSemanal() {
    double taxa = 0.24;

    BigDecimal taxaSemanal = Calculo.calcularTaxaSemanal(taxa);

    assertEquals(taxaSemanal, new BigDecimal("0.004145"));
  }

  /**
   * Teste da função calcularRendaAporte()
   */
  @Test
  public void testCalcularRendaAporte() {
    double investimento = 100.00;
    int semanas = 36;
    BigDecimal taxaSemanal = new BigDecimal("0.0008");

    BigDecimal valor = Calculo.calcularRendaAporte(taxaSemanal, investimento, semanas);

    assertEquals(valor, new BigDecimal("3650.85"));
  }
}
