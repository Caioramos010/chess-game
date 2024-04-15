package chess.pices;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        if (getColor() == Color.BLACK){
            return "♚";
        }else {
            return "♔";
        }

    }

}