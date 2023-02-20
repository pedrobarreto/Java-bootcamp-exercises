#!/bin/sh

rm -rf ./main/com/trybe/acc/java/App.java ./test/java/com/trybe/acc/java/AppTest.java
if [ "$?" -ne 0 ]; then
   echo "Erro ao deletar App.java e AppTest.java"
   echo "\tVocê pode removê-los manualmente:"
   echo "\trm -rf ./main/java/com/trybe/acc/java/App.java ./test/java/com/trybe/acc/java/AppTest.java"
   exit 1
 fi

rm -Rf .git target HOW-TO.md
if [ "$?" -ne 0 ]; then
   echo "Erro ao deletar diretórios/arquivos .git target HOW-TO.md"
   echo "\tVocê pode removê-los manualmente:"
   echo "\trm -R .git target HOW-TO.md"
   exit 1
 fi

rm closeTemplate.sh
if [ "$?" -ne 0 ]; then
   echo "Erro ao deletar esse script closeTemplate.sh"
   echo "\tVocê pode removê-lo manualmente:"
   echo "\trm rm closeTemplate.sh"
   exit 1
 fi

echo "Pronto seu pacote está fechado. Basta colocar TODOS (inclusive arquivos escondidos) esses arquivos no seu projeto template do Github."
