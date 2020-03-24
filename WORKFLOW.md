# WORKFLOW

## Atualize o master local
```
git pull
```

## Cria novo branch

```
git checkout -b <NOME_DO_BRANCH>
```

*Faca as implementacoes pertinentes APENAS ao escopo do seu branch*

Isto significa que se encontrar um bug ou erro ou uma nova feature em outro lugar fora do escopo do branch, um outro branch deve ser criado para resolver este novo problema.

## Adicione as alteracoes

```
git add <NOME_ARQUIVO_OU_PASTA>
git add .
git commit -m "<MENSAGEM_SOBRE_COMMIT>"
```

## Crie/atualize branch remoto

```
git push --set-upstream origin <NOME_DO_BRANCH>
git push
```

Cria o PR selecionando o branch que voce acabou de criar.

## Convencao dos commits

```
<type>(<scope>): <subject>
```

### "type"

```
- feat: novas funcionalidades incluídas
- fix: alterações e correções em funcionalidades existentes
- docs: inclusão ou alteração de documentação no repositório
- style: alterações na formatação, como identação, pontuação, espaçamentos, nomes de pastas e arquivos, etc
- refactor: reorganizações no código fonte que não incluem ou alteram regras de negócio, por exemplo extração de novas funções, alterações de interfaces internas, mudanças na comunicação, otimizações de algoritmos, alterações de dependências
- test: inclusão ou alterações de testes
- chore: tarefas não relacionadas à funcionalidades ou ao código fonte; nenhuma mudança em código de produção
```

### "scope"
```
(API.InterfaceX)
(CORE.FuncionalidadeY)
```

### "subject"

Utilizando verbos no imperativo e no presente (inclui, altera, testa...) descreva o que aquele commit especifico esta fazendo ao codigo


## Atualizar dependencia

Para atualizar as dependencias, precisamos atualizar o build.gradle . Ele e o responsavel por determinar as dependencias do projeto.

A maioria das dependencias Java estao no maven central. Normalmente as aplicacoes ja mostram como adicionar no gradle.

Depois de adicionar a dependencia, pela linha de comando, execute:

```
gradle cleanEclipse eclipse
```

O comando analiza e adiciona as novas dependencias do eclipse.

Reinicie o eclipse para que ele reconheca o classpath.
