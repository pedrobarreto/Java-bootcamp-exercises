package com.betrybe.acc.java.bankaccount;

import org.apache.commons.lang3.StringUtils;

/**
 * AccountNumberFormatter.
 */
public class AccountNumberFormatter {

  /**
   * Formata o número da conta.
   *
   * @param literalAccountNumber número da conta
   */
  public String formatAccountNumber(int literalAccountNumber) {
    String accountNumber = String.valueOf(literalAccountNumber);
    String formattedAccount = accountNumber;
    if (accountNumber.length() > 6) {
      formattedAccount = StringUtils.right(accountNumber, 6);
    }
    if (accountNumber.length() < 6) {
      formattedAccount = StringUtils.leftPad(accountNumber, 6, "0");
    }
    return formattedAccount;


  }

}
