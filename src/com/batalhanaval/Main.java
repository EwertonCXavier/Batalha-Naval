package com.batalhanaval;
import org.jetbrains.annotations.NotNull;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    posicionarNaviosCPU();
    String[][] matriz = posicionarNaviosJogador();
  }

  public static void posicionarNaviosCPU() {
//  Usado para permitir o posicionamento do navio no tabuleiro
//  Definição da matriz tabuleiro
    Random rand = new Random();
    int positionX;
    int positionY;
    String[][] tabuleiro;
    int cont = 0;

    tabuleiro = criarTabuleiro();

//    Posicionamento dos navios no tabuleiro da CPU
    while(cont < tabuleiro.length) {
      positionX = rand.nextInt(tabuleiro.length);
      positionY = rand.nextInt(tabuleiro.length);

      System.out.printf("O navio ficará posicionado em: %d %d%n", positionX, positionY);

      while(!tabuleiro[positionX][positionY].equals("_")) {
        positionX = rand.nextInt(tabuleiro.length);
        positionY = rand.nextInt(tabuleiro.length);
        System.out.printf("O navio ficará posicionado, após revisão, em: %d %d%n", positionX, positionY);
      }
      tabuleiro[positionX][positionY] = "N";
      cont ++;

    }
    //    Imprime o tabuleiro na tela
    imprimeTabuleiro(tabuleiro);
  }

  public static String[] @NotNull [] posicionarNaviosJogador() {
    Scanner input = new Scanner(System.in);
    String linha, aux;
    int coluna;
    String alphabet = "ABCD";
    String[][] board;
    board = criarTabuleiro();

//   Posiciona navios de acordo com o tamanho da matriz
    for (int i = 0; i < board.length; i++) {
      linha = linhaTabuleiro(input, alphabet);
      int index = alphabet.toLowerCase().indexOf(linha.toLowerCase());
      coluna = colunaTabuleiro(input, alphabet, board);

      while (board[index][coluna].equals("A")) {
        linha = linhaTabuleiro(input, alphabet);
        index = alphabet.toLowerCase().indexOf(linha.toLowerCase());
        coluna = colunaTabuleiro(input, alphabet, board);
      }
      if (coluna >= 1 && coluna < board.length) {
        if (board[index][coluna].equals("_")) {
          board[index][coluna] = "A";
          imprimeTabuleiro(board);
        }
      }
    }
    return board;
  }


  public static void imprimeTabuleiro(String[] @NotNull [] board) {
    //    Impressão do tabuleiro formatado
    for (int i = 0; i < board[0].length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (j == (board.length - 1)) {
          System.out.printf("%s%n", board[i][j]);
        } else {
          System.out.printf("%s ", board[i][j]);
        }
      }
    }
  }

  public static String[] @NotNull [] criarTabuleiro() {
    String[][] tabuleiro = new String[4][4];
    for (String[] strings : tabuleiro) {
      Arrays.fill(strings, "_");
    }
    return tabuleiro;
  }

  public static String linhaTabuleiro(@NotNull Scanner input, String alphabet) {
    //  Linha
    String linha;
    System.out.print("Digite o valor da linha que deseja posicionar o navio: ");
    linha = input.nextLine();
    int index = alphabet.indexOf(linha.toUpperCase());
    while (index == -1) {
      System.out.print("Repita a linha: ");
      linha = input.nextLine();
      index = alphabet.toLowerCase().indexOf(linha.toLowerCase());
    }

    return linha;
  }

  public static int colunaTabuleiro(@NotNull Scanner input, String alphabet, String[][] board) {
    String aux;
    int coluna;
    System.out.print("Digite o valor da coluna que deseja posicionar o navio: ");
    aux = input.nextLine();
    coluna = Integer.parseInt(aux);

    while (coluna < 0 || coluna >= board.length) {
      System.out.print("Repita a coluna: ");
      aux = input.nextLine();
      coluna = Integer.parseInt(aux);
    }

    return coluna;
  }
}
