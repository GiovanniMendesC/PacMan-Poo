<h1 align="center"> PAC-MAN </h1>
<h1 align="center">
 <img src= https://static2.thegamerimages.com/wordpress/wp-content/uploads/2020/03/PacmanHeader.jpg />
</h1>

# 💻 Sobre o projeto
Sendo um jogo extremamente popular e atemporal, Pac-man consiste num único objetivo: devorar todas as frutinhas do labirinto sem ser pego por algum dos fantasmas. Este é um projeto desenvolvido para a disciplina de Programação Orientada a Objetos com Java, onde a equipe fez uso de conceitos como herança, polimorfismo, encapsulamento, classes abstratas e interface, dentre outros.

# Relação de classes
- Personagens, classe abstrata que serve como a base para a criação de personagens no jogo, incluindo PacMan e Ghost, que são suas classes filhas. A classe Personagens não pode ser instanciada e pode ter métodos abstratos, embora, neste caso específico, não tenha nenhum método abstrato definido.

- PacMan, classe que herda Personagens, é controlado pelo jogador e é usado na classe MovimentoPacMan. Ela tem atributos estáticos que podem ser visualizados por classes diferentes e diferentes construtores para inicializar o pacman.

- MovimentoPacMan, classe que cria uma instância de PacMan e lida com sua movimentação, usando diferentes bibliotecas (javax.swing.JPanel, javax.swing.Timer, java.awt.event.ActionEvent, java.awt.event.ActionListener, java.awt.event.KeyEvent, java.awt.event.KeyListener) para receber entradas do teclado e atualizar a posição do PacMan. Além disso, a classe MovimentoPacMan verifica colisões com as paredes e pontos do mapa usando os atributos da classe Mapa.

- Ghost, classe que herda Personagens, usada na classe MovimentoGhost. Ela tem o método distanciaPacmMan, que verifica a distância do fantasma para o pacman, e um método construtor.

- A classe MovimentoGhost gerencia a movimentação dos quatro fantasmas do jogo utilizando as instâncias de Ghost. Ao contrário de PacMan, a movimentação dos fantasmas não depende das ações do usuário. A classe MovimentoGhost utiliza os atributos e métodos das classes Mapa, PacMan e Player assim como diferentes bibliotecas para fazer atualização das posições do fantasma. Além disso, a classe MovimentoGhost é responsável pelo desenho dos personagens e do mapa na tela e o fim do jogo.

- Painel é uma classe que lida com a exibição do jogo na tela. Ela cuida da apresentação elementos visuais do jogo em um frame.

- Mapa é uma classe que contém uma matriz representando o layout do mapa do jogo em  células, informações sobre as paredes e pontos. Cada céulula da matriz representa 20 unidades da tela do pacman (600x900).

- Player é uma classe que, originalmente, deveria trabalhar com os dados dos usuários e o banco de dados, mas essa funcionalidade não foi implementada. Ele guarda nome e pontos do usuário.

- PacGame é a classe principal do jogo que inicia a execução no método main.

## Diagrama de Classes
<h1 align="center">
 <img src= https://lh3.googleusercontent.com/pw/ADCreHcpbZfp6CQ5jqGS0KH9IaVd5tXxhRTW2adMABPy87nw_KpsZu5uqW6Seqjy9DuavbBZ_uI2tEcwEOiTE20_kPv9c8rluY5cgJ4KqSxcJxpVBiF5_tPv33Q8Shtvb8f4nJicX1C9owOfp_bykHwKT06fBeiDBAuRVXOjSmnyACzZgtS4XwX_Y_qtQ7QnLXyDIaZrTRn1VD0xR9B2uI36xgza0xTYsfbsheaachFOkZKV72rrSyycwT26Sc6VPNcOuCfiacva7xy6gJKrYu4uTGyn7oyf461sSqUTljLbCqifwhtCcoeMgEsktilDArHBO4v0ZghSOFg2aKZYKlpRjlKoP0H87ZFUWbluAPzTopuvVqUaMKoaykWWAfFMjn9LtWjX2UB2rqHNjD3zWJ51ewxfRZUBG9E1KqRVL9rhLkq8FXtfj9DW4Cl0XFJARXfeU5VKKyz5AQXNKT-ApGdWsYNVOdSNYeazmfktoujXmZE7JOH07-pY3DHg8VchZTo3yXkfg3kOiXixbyAR4Zbfxy_jtx1Am1lrybd6Qr88ha9zmVqFnSU4qZmN3H8vzh8QnrHvt_6659CO6tF-nxmVmNdYR03qy8hIxyx-6rmXzqfiuwTuUY1yDimG620_BSkU0jGK3irAl90Qs1qydAvLeqbbmic9JHyaZwlXhUSV_F349XPDXJUpnfVSRYUtVZWdEscI7bx6jCOBPenanvU6W0tTx_Lj-Sk4OC-iRXnIiY6_D8zOwvvL3vzAi3IAjrOXb9zg-zypCLU1Ut7ylvqVKYy0970f2p5jac2ZZsJX8jyhDsMenfdbfo55f9BSsRHpkdB6ESW4GHn2vbBJ4BBl5XZ0DhDPAcmACgmMaeW-HJDMiC3fQzlWOmJUeXZ5SZ9SE9Q6P0Us7JkIB1cAFXodY545s9ltC6eHGJzgDJUuRvGx8EfGIRD01dqe94LAlJ1nZDjEaIcR5w1cjN-29jFdW6h4osbWMGy5oFeKNC0VGmbdNFQJhFLlfSdsxWaDhvRRnHRn=w1189-h924-s-no-gm?authuser=3 />
</h1>

  
# ⌨️ Tecnologias utilizadas
## Implementação:
Java
## Ambientes de Desenvolvimento:
[1. IntelliJ IDEA](https://www.oracle.com/br/java/)

[2. Visual Studio Code](https://code.visualstudio.com/download)
# 🎮 Como executar o projeto
1. Clone o código do jogo em "Code";
2. Execute em um editor de código como o Visual Studio Code ou em um Ambiente de Desenvolvimento como o IntelliJ
   #### OBS: JVM necessária para o funcionamento do programa
# 👾 Demonstração
[Link para demonstração](https://drive.google.com/drive/folders/10P7K4x-vmwaaGUgNhEzWaVZ6yLecun58?usp=sharing)
# 👤 Autores
[1. Ana Clara](https://github.com/anaclx)

[2. Danylo Nunes](https://github.com/danylodebz)

[3. Giovanni Mendes](https://github.com/GiovanniMendesC)

[4. Gleice Heloise](https://github.com/gleicehl)

