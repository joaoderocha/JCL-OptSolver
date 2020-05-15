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

# Instalando e configurando Visual Studio Code

Para instalar no linux utilize o comando

```
sudo snap install code --classic
```

Ou baixe pelo site oficial do [VSCode](https://code.visualstudio.com/Download)

Instalar as seguintes extensões:
[Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
[GitLens](https://marketplace.visualstudio.com/items?itemName=eamodio.gitlens)
[Checkstyle for Java](https://marketplace.visualstudio.com/items?itemName=shengchen.vscode-checkstyle)
[Material Icon Theme](https://marketplace.visualstudio.com/items?itemName=PKief.material-icon-theme) (Opcional)

# nomeclaturas

As classes devem comecar com letra maiuscula seguindo o camelCase

```
class ExemploCamelCase
```

Funcoes e metodos das classes devem comecar com letra minuscula seguindo o camelCase

```
function funcaoCamelCase
```

Os pacotes devem ser todos minusculos e seguindo o kebab-case *SE* necessario

```
package package-kebab-case
```

# Clone o projeto
