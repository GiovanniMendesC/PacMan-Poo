<h1 align="center"> PAC-MAN </h1>
<h1 align="center">
 <img src= https://static2.thegamerimages.com/wordpress/wp-content/uploads/2020/03/PacmanHeader.jpg />
</h1>

# 💻 Sobre o projeto
Sendo um jogo extremamente popular e atemporal, Pac-man consiste num único objetivo: devorar todas as frutinhas do labirinto sem ser pego por algum dos fantasmas. Este é um projeto desenvolvido para a disciplina de Programação Orientada a Objetos com Java, onde a equipe fez uso de conceitos como herança, polimorfismo, encapsulamento, classes abstratas e interface, dentre outros.

O objetivo do projeto é tentar recriar o jogo, do zero, a partir dos conhecimentos adiquiridos no decorrer do curso.

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
 <img src= https://github.com/GiovanniMendesC/Projeto_final_POO/blob/main/Classe%20UML.png?raw=true />
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
# Slides
[link para slides](https://www.canva.com/design/DAFzpD6yNUk/zoUCT_1kBUadgloM3me0Lg/edit)
# 👾 Demonstração
[Link para demonstração](https://drive.google.com/drive/folders/10P7K4x-vmwaaGUgNhEzWaVZ6yLecun58?usp=sharing)
# 👤 Autores
[1. Ana Clara](https://github.com/anaclx)

[2. Danylo Nunes](https://github.com/danylodebz)

[3. Giovanni Mendes](https://github.com/GiovanniMendesC)

[4. Gleice Heloise](https://github.com/gleicehl)

