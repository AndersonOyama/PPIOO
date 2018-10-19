# PPIOO


Trabalho / Coleções
O objetivo deste trabalho é a criação de um software utilizando o paradigma de programação orientado a objetos.

O trabalho é em equipe de até duas pessoas. O compartilhamento de informações entre as equipes é permitido (e aconselhado), mas o compartilhamento de código não é permitido. Trabalhos que tenham porções significativas de código iguais, ou copiados da internet, serão anulados.

Descrição
Criar um programa de gerenciamento de álbuns de figurinhas.

> novo album # Cria um novo álbum
Título: Fundo do mar
Quantidade figurinhas: 10
> novo album
Título: Pokémon
Quantidade figurinhas: 999
> ls album # Lista os álbuns existentes
1 - Fundo do mar
2 - Pokémon
> mostrar 1 # Exibe os detalhes do álbum 1
Título: Fundo do mar
Quantidade figurinhas: 10
Preenchimentos:
> preencher novo # Cria um novo preenchimento
Album: 1
Título: Principal
Figurinhas: 1 2 5
> ls album # Na listagem de álbuns deve aparecer os preenchimentos
1 - Fundo do mar
    Principal (30%)
2 - Pokémon
> mostra 1/Principal # Exibe o preenchimento
Album: Fundo do mar
Título: Principal
Presentes (30%): 1 2 5
Faltantes (70%): 3 4 6 7 8 9 10
> preencher 1/Principal # Continua o preenchimento
Figurinhas: 7 9 10
Algumas classes do domínio

Album

Representa um álbum que foi publicado por uma editora
Cada álbum deve contem um título (ex: Copa 2018) e quantidade de figurinhas
Preenchimento

Representada o estado de um álbum que está sendo preenchido pelo usuário
deve estar associado com um álbum
Deve ter um título (ex: álbum do joão, presente, etc). Muitos colecionadores gostam de completar mais do que um álbum, o título serve para identificar cada álbum
Deve ter o número das figurinhas que foram coladas no álbum
Algumas interfaces

ColecoesDAO (DAO = Data access object)

Contém métodos para armazenar e recuperar os dados preenchidos pelo usuário
ColecoesService

Contém os métodos com a lógica de negócio (ex: adição / remoção de figurinhas no preenchimento, troca com usuários, calculo de porcentagem de figurinhas preenchidas, faltantes, etc)
A implementação de ColecoesService vai usar internamente a implementação de ColecoesDAO
O código que implementa a interface com o usuário usará uma instância de ColecoesService para executar as suas funções
