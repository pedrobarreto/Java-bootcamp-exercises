package com.trybe.acc.java.iocdi.sistemapagamentos.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The interface Restrito pagamento.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RestritoPagamento {
  /**
   * Verifica verificacao.
   *
   * @return the verificacao
   */
  Verificacao verifica() default Verificacao.PAGAMENTO;
}
