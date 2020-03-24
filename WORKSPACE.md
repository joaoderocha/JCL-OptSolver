# JCL-OptSolver
JCL-OptSolver

# WORKSPACE

## Instalando JDK8

Baixa o arquivo (jdk-8u241-linux-x64.tar.gz) do site oficial da [oracle](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)

Crie o diretorio do java
```
sudo mkdir /usr/lib/jvm
```
Vai para pasta que criou:
```
cd /usr/lib/jvm
```
Extraia o arquivo de onde voce baixo:
```
sudo tar -xvzf ~/Downloads/jdk-8u241-linux-x64.tar.gz
```
Abra as variaveis de ambiente do linux:
```
sudo gedit /etc/environment
```
Adicione esses paths a variavel PATH do sistema, coloque elas separadas por dois pontos ':'.

```
/usr/lib/jvm/jdk1.8.0_241/bin
/usr/lib/jvm/jdk1.8.0_241/db/bin
/usr/lib/jvm/jdk1.8.0_241/jre/bin
```

Ao final coloque essas novas variaveis: 

```
J2SDKDIR="/usr/lib/jvm/jdk1.8.0_241"
J2REDIR="/usr/lib/jvm/jdk1.8.0_241/jre"
JAVA_HOME="/usr/lib/jvm/jdk1.8.0_241"
DERBY_HOME="/usr/lib/jvm/jdk1.8.0_241/db"
```

O arquivo deve ficar algo parecido com isso:

```
PATH="/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/usr/lib/jvm/jdk1.8.0_241/bin:/usr/lib/jvm/jdk1.8.0_241/db/bin:/usr/lib/jvm/jdk1.8.0_241/jre/bin"
J2SDKDIR="/usr/lib/jvm/jdk1.8.0_241"
J2REDIR="/usr/lib/jvm/jdk1.8.0_241/jre"
JAVA_HOME="/usr/lib/jvm/jdk1.8.0_241"
DERBY_HOME="/usr/lib/jvm/jdk1.8.0_241/db"
```
Configure as paths antigos para os novos
```
sudo update-alternatives --install "/usr/bin/java" "java" "/usr/lib/jvm/jdk1.8.0_241/bin/java" 0
```
```
sudo update-alternatives --install "/usr/bin/javac" "javac" "/usr/lib/jvm/jdk1.8.0_241/bin/javac" 0
```
```
sudo update-alternatives --set java /usr/lib/jvm/jdk1.8.0_241/bin/java
```
```
sudo update-alternatives --set javac /usr/lib/jvm/jdk1.8.0_241/bin/javac
```

verifique se esta tudo correto
```
update-alternatives --list java
```
```
update-alternatives --list javac
```
Reinicie ou deslogue da maquina para fazer efeito e utilize o comando
```
java -v
```

# Instalando Eclipse

Baixa o tar.gz do [eclipse](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2019-12/R/eclipse-inst-linux64.tar.gz)


Extraia o arquivo em alguma pasta com 
```
sudo tar -xvzf <ARQUIVO>
```

dentro da pasta extraida, execute o arquivo 
comando:
```
./eclipse-inst
```
clicar duas vezes no arquivo tambem funciona

# Instale SonarLint 5.0 no eclipse Marketplace

# Instale Buildship Gradle Integration 3.0

# Clone o projeto

