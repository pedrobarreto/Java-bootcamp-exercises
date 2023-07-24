package com.trybe.acc.java.programamilhas.dominio;

/*
 * INSERT INTO milhas.TIPOLANCAMENTO (IDTIPOLANCAMENTO, DESCRICAO) VALUES (1, 'Bônus'); INSERT INTO
 * milhas.TIPOLANCAMENTO (IDTIPOLANCAMENTO, DESCRICAO) VALUES (2, 'Transferência'); INSERT INTO
 * milhas.TIPOLANCAMENTO (IDTIPOLANCAMENTO, DESCRICAO) VALUES (3, 'Acúmulo'); INSERT INTO
 * milhas.TIPOLANCAMENTO (IDTIPOLANCAMENTO, DESCRICAO) VALUES (4, 'Resgate');
 */
public enum TipoLancamentoEnum {

  BONUS(1),

  TRANSFERENCIA(2),

  ACUMULO(3),

  RESGATE(4);

  private Integer id;

  private TipoLancamentoEnum(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }


}
