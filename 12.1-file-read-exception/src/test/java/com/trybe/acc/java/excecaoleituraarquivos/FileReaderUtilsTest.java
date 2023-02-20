package com.trybe.acc.java.excecaoleituraarquivos;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class FileReaderUtilsTest {

	@Test
	@DisplayName("1 - Retorna string correta quando arquivo não existe")
	public void deveRetornarSeArquivoNaoExistir() throws FileNotFoundException {
		var fileReader = new FileReaderUtils();
		
		Assertions.assertEquals("Arquivo não existe" , fileReader.getFirstLine());
	}
}
