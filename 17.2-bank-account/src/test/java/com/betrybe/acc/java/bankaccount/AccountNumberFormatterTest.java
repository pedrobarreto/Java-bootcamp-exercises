package com.betrybe.acc.java.bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountNumberFormatterTest {
  private static AccountNumberFormatter formatter;

  @BeforeAll
  public static void setUp() {
    formatter = new AccountNumberFormatter();
  }

  @Test
  @DisplayName("3 - Formata número de conta MENOR que 6 digitos.")
  public void formatAccountNumberLessThan6Digits() {
    assertEquals("000448", formatter.formatAccountNumber(448));
  }

  @Test
  @DisplayName("4 - Formata número de conta MAIOR que 6 digitos.")
  public void formatAccountNumberMoreThan6Digits() {
    assertEquals("567890", formatter.formatAccountNumber(1234567890));
  }

  @Test
  @DisplayName("5 - Formata número de conta IGUAL a 6 digitos.")
  public void formatAccountNumberEquals6Digits() {
    assertEquals("112344", formatter.formatAccountNumber(112344));
  }
}
