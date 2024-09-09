---

# Chess Game in Java

Este é um jogo de xadrez desenvolvido em Java, com foco em conceitos de **Orientação a Objetos**. Ele demonstra o uso de herança, polimorfismo e encapsulamento, além de validação das regras de xadrez, como cheques e xeque-mate.

## Features

- Implementação completa de regras de xadrez.
- Validação de movimentos, incluindo cheque e xeque-mate.
- Design modular e extensível.
- **Polimorfismo** com o método `possibleMoves()`.

---

## Conceitos de OOP Aplicados

### 1. **Herança**
   Todas as peças de xadrez herdam da classe abstrata `ChessPiece`, que contém os atributos comuns (posição, cor ) e métodos a serem implementados individualmente por cada peça, como o `getChessPosition()`.

```java
public abstract class ChessPiece extends Piece {

    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }
...
    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }
...
```

### 2. **Polimorfismo**
   O polimorfismo é utilizado para permitir que diferentes peças implementem o método `possibleMoves()` de acordo com as regras específicas de movimento. Isso é visto nas classes como `Pawn` e `Rook`, que sobrescrevem o método e aplicam suas lógicas próprias.

```java
public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }
    @Override
    public String toString(){
        return "R";
    }
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0 , 0);

        //above
      ....
...
```

### 3. **Encapsulamento**
   A lógica de cada peça é encapsulada dentro de suas respectivas classes, facilitando a manutenção e expansão do código. Movimentos e estados são controlados internamente, com métodos públicos permitindo interações limitadas e controladas.

---

## Validação de Regras

O código lida com a verificação de estados de cheque e xeque-mate, garantindo que os movimentos sigam as regras do xadrez.

---

## Como Jogar

1. Clone o repositório:
   ```bash
   git clone https://github.com/Caioramos010/chess-game.git
   ```

2. Compile e execute o arquivo principal (`Program.java`) em sua IDE.

---

## Futuras Melhorias

- Implementar uma interface gráfica (GUI).
- Adicionar jogabilidade multiplayer.

---

## Licença

Este projeto está sob a licença MIT.

