package com.trybe.acc.java.programamilhas.util;

import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class TokenUtil {

  @ConfigProperty(name = "app.adm.token")
  String admToken;

  SecretKey chave;

  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

  /**
   * Construtor para a classe TokenUtil.
   */
  public String criarToken(Integer idUsuario) {
    LocalDateTime agora = LocalDateTime.now();
    String conteudo = idUsuario + "=" + agora.format(formatter);
    return encriptar(conteudo);
  }

  /**
   * Obtem o id da pessoa usuária, dado um token.
   * @param token o token a ser validado
   * @return o id da pessoa.
   * @throws AcessoNaoAutorizadoException caso o token seja invalido.
   */
  public Integer obterIdUsuario(String token) throws AcessoNaoAutorizadoException {
    try {
      String conteudo = decriptar(token);
      String[] valores = conteudo.split("=");
      return Integer.valueOf(valores[0]);
    } catch (Exception e) {
      throw new AcessoNaoAutorizadoException();
    }

  }

  /**
   * Valida token caso seja pessoa usuaria administrativo.
   */
  public void validarAdmToken(String token) throws AcessoNaoAutorizadoException {
    if (!isAdmToken(token)) {
      throw new AcessoNaoAutorizadoException();
    }
  }

  private boolean isAdmToken(String token) {
    return admToken.equals(token);
  }

  @PostConstruct
  void inicializarChave() throws Exception {
    chave = createAesKey();
  }

  private String encriptar(String entrada) {
    try {
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(Cipher.ENCRYPT_MODE, chave);
      return Base64.getEncoder().encodeToString(cipher.doFinal(entrada.getBytes("UTF-8")));
    } catch (Exception e) {
      System.out.println("Error while encrypting: " + e.toString());
    }
    return null;
  }

  private String decriptar(String entrada) {
    try {
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
      cipher.init(Cipher.DECRYPT_MODE, chave);
      return new String(cipher.doFinal(Base64.getDecoder().decode(entrada)));
    } catch (Exception e) {
      System.out.println("Error while decrypting: " + e.toString());
    }
    return null;
  }

  private SecretKey createAesKey() throws Exception {
    SecureRandom securerandom = new SecureRandom();
    KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
    keygenerator.init(256, securerandom);
    return keygenerator.generateKey();
  }

}
