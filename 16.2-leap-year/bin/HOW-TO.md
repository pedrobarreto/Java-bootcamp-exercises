# sample-acc-java
Projeto base para os desafios da Aceleração Java.

## Como fazer?

Para todos os passos a seguir, iremos utilizar, como exemplo, esse [desafio](https://github.com/betrybe/acc-java-0x-exercises-idade-em-dias):  
    - [pom.xml](https://github.com/betrybe/acc-java-0x-exercises-idade-em-dias/blob/main/pom.xml)  
    - [requirements.json](https://github.com/betrybe/acc-java-0x-exercises-idade-em-dias/blob/main/.trybe/requirements.json)  
    - [Pessoa.java](https://github.com/betrybe/acc-java-0x-exercises-idade-em-dias/blob/main/src/main/java/com/trybe/idadeemdias/Pessoa.java)  
    - [PessoaTest.java](https://github.com/betrybe/acc-java-0x-exercises-idade-em-dias/blob/main/src/test/java/com/trybe/idadeemdias/PessoaTest.java)  
    - [Main.java](https://github.com/betrybe/acc-java-0x-exercises-idade-em-dias/blob/main/src/main/java/com/trybe/idadeemdias/Main.java)  
    - [MainTest.java](https://github.com/betrybe/acc-java-0x-exercises-idade-em-dias/blob/main/src/test/java/com/trybe/idadeemdias/MainTest.java)  
    - [README.md](https://github.com/betrybe/acc-java-0x-exercises-idade-em-dias/blob/main/README.md)  


Passos para criar o template:

1. Adicionar o nome do desafio:  
    No `pom.xml` encontra se as seguintes linhas:
    ```xml
        <groupId>com.trybe.acc.java.</groupId>
        <artifactId>sample-acc-java</artifactId>
    ```
    Onde,  
        - o `groupId` é o pacote Java em que as classes estarão. Mantenha esse valor e apenas complete com o pacote específico do desafio. Lembre se que, pelas regras do Java, o nome do pacote devem ser, OBRIGATORIAMENTE, em letras minúsculas. 
        - o `artifactId` é o nome do projeto. Altere o valor para o nome do projeto Java. Use um nome da sua escolha e que faça sentido com o enunciado.
    
    Exemplo:
    ```xml
        <groupId>com.trybe.acc.java.idadeemdias</groupId>
        <artifactId>IdadeEmDias</artifactId>
    ```

1. Criar o arquivo `.trybe/requirements.json`:  
    Este arquivo é um guia para o avaliador seguir e conhecer os testes que serão feitos nas classes de teste. Nele também descreve qual teste é bonus ou não.  
    No repositório da [Aceleração Java](https://github.com/betrybe/aceleracao-java), deve existir um desse arquivo para cada desafio, criado pela pessoa elaboradora de conteúdo. Caso não tenha, será preciso criar. O texto da `description` será apresentado no comentário do PR da pessoa estudante, portanto, revise se está de acordo com as diretrizes do Código de Ética e Conduta e do Manual da Pessoa Estudante da Trybe.

    Exemplo:
    ```json
    {
        "requirements": [
            {
                "description": "1 - A aplicação pergunta, no terminal, nome e idade e retorna a idade em dias",
                "bonus": false
            },
            {
                "description": "2 - Escreva uma classe com o nome Pessoa",
                "bonus": false
            },
            {
                "description": "3 - Escreva um método que calcule a idade de Pessoa em dias",
                "bonus": false
            },
            {
                "description": "4 - Faça com que o cálculo da idade retorne um valor do tipo inteiro",
                "bonus": false
            },
            {
                "description": "5 - Faça com que o programa retorne a saída esperada",
                "bonus": false
            }
        ]
    }
    ```
    

1. Criar as classes de testes:

    Todas as classes de teste devem ter o sufixo  `Test.java`. Ex: `PessoaTest.java`, `MainTest.java`. Note que se for preciso alterar o nome do arquivo, a classe deve seguir o mesmo nome, como diz as regras do Java.  

    Todos os testes (métodos anotado com `@Test` dentro das classes de teste) devem, **OBRIGATORIAMENTE**, conter a notação `@DisplayName("")` com, **EXATAMENTE**, o texto que está no `description` do referente teste no arquivo `requirements.json`.

    **É preciso que TODOS os testes listados no arquivo `requirements.json` tenham seu correspondente dentro de alguma classe de teste e sejam marcados com `@DisplayName()`**

    Exemplo:
    ```java
    class PessoaTest {

        @Test
        @DisplayName("2 - Escreva uma classe com o nome Pessoa")
        public void testPessoaClassname() {
            Pessoa p = new Pessoa();
            assertEquals("Pessoa", p.getClass().getSimpleName());
        }

        @Test
        @DisplayName("3 - Escreva um método que calcule a idade de Pessoa em dias")
        public void testCalcularIdadeEmDias1() {
            Pessoa p = new Pessoa();
            assertEquals(11769, p.calcularIdadeEmDias(32, 2, 29));
        }

        @Test
        @DisplayName("4 - Faça com que o cálculo da idade retorne um valor do tipo inteiro")
        public void testCalcularIdadeEmDias2() {
            Pessoa p = new Pessoa();
            assertEquals(11404, p.calcularIdadeEmDias(31, 2, 29));
        }

        @Test
        @DisplayName("5 - Faça com que o programa retorne a saída esperada")
        public void testCalcularIdadeEmDiasReturnType() {
            Pessoa p = new Pessoa();
            assertTrue(Integer.class.isInstance(p.calcularIdadeEmDias(32, 2, 29)));
        }

    }

    class MainTest {

        @Test
        @DisplayName("1 - A aplicação pergunta, no terminal, nome e idade e retorna a idade em dias")
        public void testeMain() {
            
            String userInput = String.format("Paulo%s31%s2%s29",
                    System.lineSeparator(),
                    System.lineSeparator(),
                    System.lineSeparator()
            );
            
            ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
            System.setIn(bais);

            String esperado = "Olá Paulo, sua idade em dias é 11404";
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(baos);
            System.setOut(printStream);

            Main.main(null);

            String[] linha = baos.toString().split(System.lineSeparator());
            String saida = linha[linha.length-1];
            
            assertEquals(esperado,saida);
            
        }

    }
    ```

1. CheckStyle:
    Verifique se está tudo correto com o CheckStyle. Execute o comando a seguir na linha de comando.
    ```shell
    mvn package
    ```
    Caso o BUILD não seja feito com sucesso, arrume os problemas de style indicado.  

1. Adicione o enunciado do desafio:  
    No arquivo [README.md](README.md) desde repositório, haverá um local marcado com `{{ENUNCIADO}}`. Remova essa marcação e adicione o enunciado do desafio que está no repositório da [Aceleração Java](https://github.com/betrybe/aceleracao-java).
  
1. Rodar o script de fechar template:  
    Uma vez que o script irá deletar essas instruções, antes de rodar o script, abra no seu navegador o link deste [HOW-TO.md](https://github.com/betrybe/sample-acc-java/blob/main/HOW-TO.md) para continuar os próximos passos.
    Esse script irá deletar:  
        - Diretório `.git`  
        - Diretório `target`  
        - Este arquivo `HOW-TO.md`  
        - O próprio script  
    
    Rode o script na raíz deste projeto:
    ```shell
    ./closeTemplate.sh
    ```

1. Criar projeto no [Github da Trybe](https://github.com/betrybe):  
    - Use a nomenclatura: `acc-java-0x-exercises-nome-separado-por-hifens`. Ex.: `acc-java-0x-exercises-idade-em-dias`  
    - Marque o projeto criado como `Template repository`, dentro da aba `Settings`, menu esquedo `General`.
    - Subir o código desse projeto na branch `main` do projeto criado no passo acima.

1. Testar o projeto criado:  
    Para testar o projeto, vamos criar a rubrica dele. Essa rubrica foi elaborada pela pessoa produtora de conteúdo, encontra se no repositório da [Aceleração Java](https://github.com/betrybe/aceleracao-java): 
    1. Fazer a disponibilização do projeto **em staging**. Use o mesmo nome do projeto seguido de `-rubric`. Ex.: `acc-java-0x-exercises-idade-em-dias-rubric` 
    1. Criar uma branch a partir da `main` e fazer o push  
    1. No Github, criar um PR da branch criada no passo anterior para a `main`  
    1. Resolver o desafio na branch criada nos passos anterior e fazer o push  
    1. Certificar que o avaliador passou com 100% da resolução
    1. **NÃO** aceite o merge do PR. Apenas deixe disponibilizado a branch da rubrica.
     

---
# Qual a definição de DONE?

Vamos precisar que você nos envie:

- o link do repositório do template criado no [Github da Trybe](https://github.com/betrybe).

- o link do repositório de rubrica com a solução do projeto, com pelo menos um PR com aprovação 100%. 
