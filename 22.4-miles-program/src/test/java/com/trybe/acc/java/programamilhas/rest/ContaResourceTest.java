package com.trybe.acc.java.programamilhas.rest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;
import com.trybe.acc.java.programamilhas.dto.LancamentoDto;
import com.trybe.acc.java.programamilhas.dto.ResgateProdutoDto;
import com.trybe.acc.java.programamilhas.dto.TransferenciaDto;
import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import org.eclipse.microprofile.config.ConfigProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ContaResourceTest {

    @Test
    @DisplayName("7 - As operações de saldo, transferência, resgate e extrato funcionam com sucesso.")
    public void testOperacoes() {
    	UtilTest util = new UtilTest();
    	String tokenHuguinho = util.getToken("huguinho", "root");
    	String tokenZezinho = util.getToken("zezinho", "senha");
    	SaldoResult saldo = given().when().get("/conta/saldo?token=" + tokenHuguinho).as(SaldoResult.class);
    	Integer saldoAnteriorHuguinho = saldo.getSaldo();
    	assertEquals(Integer.valueOf(10000), saldoAnteriorHuguinho);
    	
    	List<Lancamento> extratoHuguinho = Arrays.asList(given().when().get("/conta/extrato?token=" + tokenHuguinho).as(Lancamento[].class));
    	assertEquals(Integer.valueOf(1), extratoHuguinho.size());
    	
    	List<Lancamento> extratoZezinho = Arrays.asList(given().when().get("/conta/extrato?token=" + tokenZezinho).as(Lancamento[].class));
    	assertEquals(Integer.valueOf(1), extratoZezinho.size());
    	
    	TransferenciaDto dadosTransferencia = new TransferenciaDto();
    	dadosTransferencia.setUsuarioDestino("zezinho");
    	dadosTransferencia.setValor(1500);
		
		// Transferencia sucesso
		given().contentType("application/json").body(dadosTransferencia).when().post("/transacao/transferencia?token=" + tokenHuguinho).then()
				.statusCode(200);
		
		// Transferencia sem saldo
		TransferenciaDto dadosTransferenciaSemSaldo = new TransferenciaDto();
		dadosTransferenciaSemSaldo.setUsuarioDestino("zezinho");
		dadosTransferenciaSemSaldo.setValor(8501);
		given().contentType("application/json").body(dadosTransferenciaSemSaldo).when().post("/transacao/transferencia?token=" + tokenHuguinho).then()
						.statusCode(500);
		
		List<Lancamento> extratoHuguinhoApos = Arrays.asList(given().when().get("/conta/extrato?token=" + tokenHuguinho).as(Lancamento[].class));
    	assertEquals(Integer.valueOf(2), extratoHuguinhoApos.size());
    	
    	List<Lancamento> extratoZezinhoApos = Arrays.asList(given().when().get("/conta/extrato?token=" + tokenZezinho).as(Lancamento[].class));
    	assertEquals(Integer.valueOf(2), extratoZezinhoApos.size());
    	
    	
    	// Transferencia de volta sem saldo
		TransferenciaDto dadosTransferenciaDeVoltaSemSaldo = new TransferenciaDto();
		dadosTransferenciaDeVoltaSemSaldo.setUsuarioDestino("huguinho");
		dadosTransferenciaDeVoltaSemSaldo.setValor(11501);
		given().contentType("application/json").body(dadosTransferenciaDeVoltaSemSaldo).when().post("/transacao/transferencia?token=" + tokenZezinho).then()
						.statusCode(500);
		
		// Transferencia de volta com saldo
		TransferenciaDto dadosTransferenciaDeVoltaComSaldo = new TransferenciaDto();
		dadosTransferenciaDeVoltaComSaldo.setUsuarioDestino("huguinho");
		dadosTransferenciaDeVoltaComSaldo.setValor(5000);
		given().contentType("application/json").body(dadosTransferenciaDeVoltaComSaldo).when().post("/transacao/transferencia?token=" + tokenZezinho).then()
						.statusCode(200);
		
		List<Lancamento> extratoHuguinhoApos2 = Arrays.asList(given().when().get("/conta/extrato?token=" + tokenHuguinho).as(Lancamento[].class));
    	assertEquals(Integer.valueOf(3), extratoHuguinhoApos2.size());
    	
    	List<Lancamento> extratoZezinhoApos2 = Arrays.asList(given().when().get("/conta/extrato?token=" + tokenZezinho).as(Lancamento[].class));
    	assertEquals(Integer.valueOf(3), extratoZezinhoApos2.size());
    	
    	SaldoResult saldoHuguinhoApos = given().when().get("/conta/saldo?token=" + tokenHuguinho).as(SaldoResult.class);
    	Integer saldoPosteriorHuguinho = saldoHuguinhoApos.getSaldo();
    	assertEquals(Integer.valueOf(13500), saldoPosteriorHuguinho);
    	
    	SaldoResult saldoZezinhoApos = given().when().get("/conta/saldo?token=" + tokenZezinho).as(SaldoResult.class);
    	Integer saldoPosteriorZezinho = saldoZezinhoApos.getSaldo();
    	assertEquals(Integer.valueOf(6500), saldoPosteriorZezinho);
    	
    	// Resgate ADM Zezinho
    	String admToken = ConfigProvider.getConfig().getValue("app.adm.token", String.class);
    	LancamentoDto resgate = new LancamentoDto();
    	resgate.setDescricao("Resgate Zezinho");
    	resgate.setIdParceiro(1);
    	resgate.setIdTipoLancamento(4);
    	resgate.setValor(3500);
    	resgate.setUsuario("zezinho");
    	given().contentType("application/json").body(resgate).when().post("/admin/resgate?token=" + admToken).then().statusCode(200);
    	
    	SaldoResult saldoZezinhoAposResgate = given().when().get("/conta/saldo?token=" + tokenZezinho).as(SaldoResult.class);
    	Integer saldoPosteriorResgateZezinho = saldoZezinhoAposResgate.getSaldo();
    	assertEquals(Integer.valueOf(3000), saldoPosteriorResgateZezinho);
    	
    	List<Lancamento> extratoZezinhoApos3 = Arrays.asList(given().when().get("/conta/extrato?token=" + tokenZezinho).as(Lancamento[].class));
    	assertEquals(Integer.valueOf(4), extratoZezinhoApos3.size());
    	
    	// Resgate de produto sem saldo
    	ResgateProdutoDto resgateProduto = new ResgateProdutoDto();
    	resgateProduto.setDescricao("Resgate passagem internacional");
    	resgateProduto.setIdProduto(2);
    	given().contentType("application/json").body(resgateProduto).when().post("/transacao/resgate-produto?token=" + tokenZezinho).then().statusCode(500);
    	
    	// Novo saldo e extrato
    	assertEquals(Integer.valueOf(3000), given().when().get("/conta/saldo?token=" + tokenZezinho).as(SaldoResult.class).getSaldo());
    	
    	// Resgate de produto com saldo
    	ResgateProdutoDto resgateProdutoComSaldo = new ResgateProdutoDto();
    	resgateProdutoComSaldo.setDescricao("Resgate passagem nacional");
    	resgateProdutoComSaldo.setIdProduto(1);
    	given().contentType("application/json").body(resgateProdutoComSaldo).when().post("/transacao/resgate-produto?token=" + tokenZezinho).then().statusCode(200);
    	
    	// Novo saldo e extrato
    	assertEquals(Integer.valueOf(1500), given().when().get("/conta/saldo?token=" + tokenZezinho).as(SaldoResult.class).getSaldo());
    	
    	List<Lancamento> extratoZezinhoAposTudo = Arrays.asList(given().when().get("/conta/extrato?token=" + tokenZezinho).as(Lancamento[].class));
    	assertEquals(Integer.valueOf(5), extratoZezinhoAposTudo.size());
    	
    }

}