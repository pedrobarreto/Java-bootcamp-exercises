package com.trybe.acc.java.programamilhas.rest;

import static io.restassured.RestAssured.given;
import com.trybe.acc.java.programamilhas.dto.LoginDto;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.result.TokenResult;
import java.util.Arrays;
import java.util.List;
import org.eclipse.microprofile.config.ConfigProvider;

public class UtilTest {

  final String admTokenName = "app.adm.token";

  List<SaldoResult> saldos() {
    String token = ConfigProvider.getConfig().getValue(admTokenName, String.class);
    return Arrays
        .asList(given().when().post("/admin/saldos?token=" + token).as(SaldoResult[].class));
  }

  String getToken(String login, String senha) {
    LoginDto dadosUsuario = new LoginDto();
    dadosUsuario.setLogin(login);
    dadosUsuario.setSenha(senha);
    TokenResult token = given().contentType("application/json").body(dadosUsuario).when()
        .post("/autenticacao").as(TokenResult.class);
    return token.getToken();
  }

}
