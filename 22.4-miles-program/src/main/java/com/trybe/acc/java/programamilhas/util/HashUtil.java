package com.trybe.acc.java.programamilhas.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HashUtil {

  /**
   * Cria uma versão com hash para uma determinada String.
   */
  public String hash(String entrada) throws InvalidKeySpecException, NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(entrada.getBytes());
    byte[] bytes = md.digest();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < bytes.length; i++) {
      sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
    }
    return sb.toString();
  }

}
