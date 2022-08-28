# Aplicativo Cartola Club

## Introdução
Cartola Club é um aplicativo nativo usado na plataforma Android. Ele pode ser usado para ver suas escalações e times. Este diretório é para mostrar exemplos de uso do CartolaClub. 

## Configuração do projeto
Ele pode ser baixado conforme abaixo:
```sh
$ git clone https://github.com/SamuelDevMobile/AppMarvelStudios.git
```
Abra-o no seu Android Studio
<img width="796" alt="Captura de Tela 2022-08-18 às 16 49 30" src="https://user-images.githubusercontent.com/26841238/185482115-adb2f78d-4b36-4cac-a6b7-d2806b0b7bc5.png">

Execute o projeto no seguinte icone.
<img width="24" alt="Captura de Tela 2022-08-18 às 16 50 33" src="https://user-images.githubusercontent.com/26841238/185482305-56a82404-d54c-4590-a658-b855461eb1d2.png">

## Visão geral da arquitetura
Este projeto foi construido com a linguagem Kotlin e construído com a arquitetura MVVM junto com LiveData, Coroutines para uma requisição assíncrona e Retrofit para se comunicar com a API da Marvel e Injeção de dependência com Koin.
Desenvolvido com Fragments e Navigation para construir um fluxo de telas bem estruturados e com o uso também de DataBinding para manipulação das Views.
Referente a persistência de dados foi utilizado o Room para salvar os personagens da Marvel, RecyclerView para Listar os personagens na Tela principal e na tela de favoritos e uma NavigationBar para acessar QG dos heróis.

## Fluxo de trabalho de Controle de Versão
Usamos vagamente a abordagem "Git flow": master é a versão
branch - deve ser sempre liberável e apenas mesclado em
quando testamos e verificamos que tudo funciona e está
bom para ir.

O desenvolvimento diário é feito no ramo de desenvolvimento. Características,
correções de bugs e outras tarefas são feitas como ramificações do desenvolvimento,
em seguida, mesclado de volta ao desenvolvimento diretamente ou por meio de solicitações pull.

Mantenha os commits atômicos e autoexplicativos, use o rebase para limpar
até ramificações confusas antes de se fundir novamente no desenvolvimento.

## Ambiente de teste
```
Android Studio Chipmunk | 2021.2.1 Patch 1
dispositivo de teste: Android 21 (Google Pixel 2)
Certifique-se de que seu dispositivo tenha a versão Android >= 21.
```
