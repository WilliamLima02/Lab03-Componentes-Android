# Laboratório 02 — Componentes da Aplicação Android

**Unidade curricular:** Aplicações Móveis  
**Instituição:** ISPTEC  
**Tecnologias:** Java, XML, Android SDK e Gradle

Este repositório reúne os projetos do Laboratório 02, separados por exercício. Cada pasta de aplicação é um projeto Android independente: abra-a individualmente no Android Studio através de **File → Open**.

## Estrutura

```text
Lab02-Componentes-Android/
├── Exercicio-1-Activities/
│   ├── SimpleActivity/
│   └── ActivityLifecycle/
├── Exercicio-2-Services/
│   └── ServiceSimple/
├── Exercicio-3-Broadcast-Receivers/
│   └── PhoneStateReceiver/
├── Exercicio-4-Bloco-de-Notas/
│   └── SimpleNotes/
├── Memorando/
│   └── Relatorio_Lab02.docx
├── README.md
├── .gitignore
└── CRIAR-COMMITS-E-PUBLICAR.ps1
```

## Exercício 1 — Activities

### SimpleActivity
Projeto baseado no `SimpleActivity.zip` fornecido. Inclui o botão **Encerrar**, que termina a Activity através de `finish()`, e registo dos callbacks do ciclo de vida no Logcat.

Sequência normal de arranque: `onCreate → onStart → onResume`. Ao terminar a Activity, normalmente são chamados `onPause → onStop → onDestroy`. Ao enviar a aplicação para segundo plano e retomá-la, os callbacks dependem de a instância continuar viva.

### ActivityLifecycle
Projeto baseado no `ActivityLifecycle.zip` fornecido. Contém `ActivityA`, `ActivityB`, `ActivityC` e `DialogActivity`, com navegação por Intents explícitos e utilitários para acompanhar estados.

## Exercício 2 — Services

Projeto baseado no `ServiceSimple.zip`, adaptado para incluir um contador partilhado através de uma classe `Application` (`CounterApplication`). A Activity incrementa o contador antes de iniciar o serviço e `MyService.onStartCommand()` consulta e apresenta o valor.

O contador vive apenas enquanto o processo da aplicação estiver ativo; não é guardado permanentemente em disco.

## Exercício 3 — Broadcast Receivers

O projeto `PhoneStateReceiver` contém `MyPhoneReceiver`, que observa a ação `PHONE_STATE`, lê o estado da chamada e tenta obter o número recebido. A Activity solicita as permissões relevantes em tempo de execução.

Para testar, execute num emulador Android, conceda as permissões e use **Extended Controls → Phone** para simular uma chamada. Consulte o Logcat e filtre pelas mensagens do receiver. A disponibilização do número depende da versão Android, das permissões e das restrições do emulador; o número pode ser `null`.

## Exercício 4 — Aplicação Bloco de Notas

A aplicação contém:
- `ListNotesActivity`: lista as notas e permite iniciar a criação de uma nota;
- `CreateNoteActivity`: recolhe título e conteúdo; OK guarda e Cancel descarta;
- `ReadNoteActivity`: apresenta o conteúdo de uma nota.

As notas são mantidas em memória por `NoteRepository`. Ao terminar o processo da aplicação, os dados deixam de estar disponíveis.

## Como executar

1. Descompacte o repositório.
2. Abra uma das pastas de aplicação acima individualmente no Android Studio.
3. Aguarde a sincronização do Gradle.
4. Selecione um emulador ou dispositivo compatível e execute a aplicação.
5. Repita para cada projeto.

## Estado da validação

Os projetos foram organizados e preparados a partir do material do laboratório. A execução final de cada aplicação deve ser confirmada no Android Studio da máquina de entrega. Em particular, o comportamento do receiver telefónico depende da versão Android e da imagem do emulador. Não considere screenshots, chamadas simuladas ou testes como realizados sem os executar e registar.

## Memorando

O documento `Memorando/Relatorio_Lab02.docx` contém a base do relatório. Antes de entregar, complete os dados de identificação, insira screenshots reais dos testes e confirme as respostas e observações com os resultados obtidos no seu emulador.

## Publicação no GitHub

Consulte `CRIAR-COMMITS-E-PUBLICAR.ps1`. O script cria commits locais separados por exercício e, opcionalmente, publica-os num repositório GitHub que já tenha sido criado na sua conta.
