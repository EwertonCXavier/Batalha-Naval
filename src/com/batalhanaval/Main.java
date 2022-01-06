package com.batalhanaval;
import org.jetbrains.annotations.NotNull;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
//    posicionarNaviosCPU();
//    String[][] matriz = posicionarNaviosJogador();
    isPlayingClass();
  }

  public static String[][] posicionarNaviosCPU() {
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
      tabuleiro[positionX][positionY] = "n";
      cont ++;

    }
    //    Imprime o tabuleiro na tela
    imprimeTabuleiro(tabuleiro);
    return tabuleiro;
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

      while (board[index][coluna].equals("N")) {
        linha = linhaTabuleiro(input, alphabet);
        index = alphabet.toLowerCase().indexOf(linha.toLowerCase());
        coluna = colunaTabuleiro(input, alphabet, board);
      }
      if (coluna < board.length) {
        if (board[index][coluna].equals("_")) {
          board[index][coluna] = "N";
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
//    imprimeTabuleiro(tabuleiro);
    return tabuleiro;
  }

  public static String linhaTabuleiro(@NotNull Scanner input, String alphabet) {
    //  Linha
    String linha;
    System.out.print("Digite o valor da linha: ");
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
    System.out.print("Digite o valor da coluna: ");
    aux = input.nextLine();
    coluna = Integer.parseInt(aux);

    while (coluna < 0 || coluna >= board.length) {
      System.out.print("Repita a coluna: ");
      aux = input.nextLine();
      coluna = Integer.parseInt(aux);
    }

    return coluna;
  }


//  Verificar se o jogo está acontencendo/rolando
  public static void isPlayingClass() {
    boolean isPlaying  = true;

    int contJogador = 0, contCPU = 0; //Contador de jogadas
    int acertosJogador = 0, acertosCPU = 0; //Verificação de acertos
    String[][] tabuleiroJogador;
    String[][] tabuleiroCPU;

    tabuleiroJogador = posicionarNaviosJogador();
    tabuleiroCPU = posicionarNaviosCPU();
    while(isPlaying) {
//  Verifica se a diferença de jogadas entre o jogador e a CPU é 1

      if((contJogador - contCPU) == 1) {
        tabuleiroJogador = vezCPU(contCPU, acertosCPU, tabuleiroJogador);
        contCPU++;
        isPlaying = false;
      } else {
        tabuleiroCPU = vezJogador(contJogador, acertosJogador, tabuleiroCPU);
        contJogador++;
      }

    }
  }


  public static String[][] vezJogador(int qtdJogadas, int numAcertos, String[][] board) {
//    . Navio posicionado N (ene maiúsculo)
//    . Tiro certeiro * (asterisco)
//    . Tiro na água – (traço)
//    . Tiro certeiro com navio posicionado X (xis maiúsculo)
//    . Tiro na água com navio posicionado n (ene minúsculo)


    String alphabet = "ABCD";
    Scanner input = new Scanner(System.in);
    String linha;
    int coluna;
    String[][] tabuleiro;
    tabuleiro = board;
    linha = linhaTabuleiro(input, alphabet);
    int index = alphabet.toLowerCase().indexOf(linha.toLowerCase());
    coluna = colunaTabuleiro(input, alphabet, tabuleiro);

    if (tabuleiro[index][coluna].equals("n")) {
      tabuleiro[index][coluna] = "*";
    } else if (tabuleiro[index][coluna].equals("_")) {
      board[index][coluna] = "-";
    } else {
      // Repetir a jogada;
      vezJogador(qtdJogadas, numAcertos, board); // Recursão
      System.out.println("Repetir a jogada!");
    }

    imprimeTabuleiro(tabuleiro);

    return tabuleiro;
  }


  public static String[][] vezCPU(int qtdJogadas, int numAcertos, String[][] board) {
    Random rand = new Random();
    int positionX;
    int positionY;
    positionX = rand.nextInt(board.length);
    positionY = rand.nextInt(board.length);
    if (board[positionX][positionY].equals("N")) {
      board[positionX][positionY] = "*";
    } else if (board[positionX][positionY].equals("_")) {
      board[positionX][positionY] = "-";
    } else {
      // Repetir a jogada;
      vezCPU(qtdJogadas, numAcertos, board);
      System.out.println("Repetir a jogada!");
    }
    System.out.println("\n\nAqui vai o tabuleiro: \n\n");
    imprimeTabuleiro(board);


    return board;
  }
}
