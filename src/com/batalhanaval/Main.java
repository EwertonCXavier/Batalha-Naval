package com.batalhanaval;

import com.batalhanaval.controller.CriarTabuleiro;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

  public static void main(String[] args) {
    CriarTabuleiro criarTabuleiro =  new CriarTabuleiro();
    criarTabuleiro.posicionarNaviosJogador();
    criarTabuleiro.posicionarNaviosCPU();
    criarTabuleiro.isPlayingClass();
  }
}

//  public static String[][] posicionarNaviosCPU() {
////  Usado para permitir o posicionamento do navio no tabuleiro
////  Definição da matriz tabuleiro
//    Random rand = new Random();
//    int positionX;
//    int positionY;
//    String[][] tabuleiro;
//    int cont = 0;
//
//    tabuleiro = criarTabuleiro();
//
////    Posicionamento dos navios no tabuleiro da CPU
//    while(cont < tabuleiro.length) {
//      positionX = rand.nextInt(tabuleiro.length);
//      positionY = rand.nextInt(tabuleiro.length);
//      System.out.printf("O navio ficará posicionado em: %d %d%n", positionX, positionY);
//
//      while(!tabuleiro[positionX][positionY].equals("_")) {
//        positionX = rand.nextInt(tabuleiro.length);
//        positionY = rand.nextInt(tabuleiro.length);
//        System.out.printf("O navio ficará posicionado, após revisão, em: %d %d%n", positionX, positionY);
//      }
//      tabuleiro[positionX][positionY] = "C";
//      cont ++;
//
//    }
//    //    Imprime o tabuleiro na tela
//    imprimeTabuleiro(tabuleiro);
//    return tabuleiro;
//  }
//
//  public static String[] @NotNull [] posicionarNaviosJogador() {
//    Scanner input = new Scanner(System.in);
//    String linha, aux;
//    int coluna;
//    String alphabet = "ABCD";
//    String[][] board;
//    board = criarTabuleiro();
//
////   Posiciona navios de acordo com o tamanho da matriz
//    for (int i = 0; i < board.length; i++) {
//      linha = linhaTabuleiro(input, alphabet);
//      int index = alphabet.toLowerCase().indexOf(linha.toLowerCase());
//      coluna = colunaTabuleiro(input, alphabet, board);
//
//      while (board[index][coluna].equals("N")) {
//        linha = linhaTabuleiro(input, alphabet);
//        index = alphabet.toLowerCase().indexOf(linha.toLowerCase());
//        coluna = colunaTabuleiro(input, alphabet, board);
//      }
//      if (coluna < board.length) {
//        if (board[index][coluna].equals("_")) {
//          board[index][coluna] = "N";
//          imprimeTabuleiro(board);
//        }
//      }
//    }
//    return board;
//  }
//
//
//  public static void imprimeTabuleiro(String[] @NotNull [] board) {
//    //    Impressão do tabuleiro formatado
//    for (int i = 0; i < board[0].length; i++) {
//      for (int j = 0; j < board.length; j++) {
//        if (j == (board.length - 1)) {
//          System.out.printf("%s%n", board[i][j]);
//        } else {
//          System.out.printf("%s ", board[i][j]);
//        }
//      }
//    }
//  }
//
//  public static String[] @NotNull [] criarTabuleiro() {
//    String[][] tabuleiro = new String[4][4];
//    for (String[] strings : tabuleiro) {
//      Arrays.fill(strings, "_");
//    }
////    imprimeTabuleiro(tabuleiro);
//    return tabuleiro;
//  }
//
//  public static String linhaTabuleiro(@NotNull Scanner input, String alphabet) {
//    //  Linha
//    String linha;
//    System.out.print("Digite o valor da linha: ");
//    linha = input.nextLine();
//    int index = alphabet.indexOf(linha.toUpperCase());
//    while (index == -1) {
//      System.out.print("Repita a linha: ");
//      linha = input.nextLine();
//      index = alphabet.toLowerCase().indexOf(linha.toLowerCase());
//    }
//
//    return linha;
//  }
//
//  public static int colunaTabuleiro(@NotNull Scanner input, String alphabet, String[][] board) {
//    String aux;
//    int coluna;
//    System.out.print("Digite o valor da coluna: ");
//    aux = input.nextLine();
//    coluna = Integer.parseInt(aux);
//
//    while (coluna < 0 || coluna >= board.length) {
//      System.out.print("Repita a coluna: ");
//      aux = input.nextLine();
//      coluna = Integer.parseInt(aux);
//    }
//
//    return coluna;
//  }
//
//
////  Verificar se o jogo está acontencendo/rolando
//  public static void isPlayingClass() {
//    boolean isPlaying  = true;
//
//    int contJogador = 0, contCPU = 0; //Contador de jogadas
//    int acertosJogador = 0, acertosCPU = 0; //Verificação de acertos
//    int contRodadas = 0;
//    String[][] tabuleiroJogador;
//    String[][] tabuleiroCPU;
//
//    tabuleiroJogador = posicionarNaviosJogador();
//    tabuleiroCPU = posicionarNaviosCPU();
//    while(isPlaying) {
////  Verifica se a diferença de jogadas entre o jogador e a CPU é 1
//
//      if((contJogador - contCPU) == 1) {
//        tabuleiroJogador = vezCPU(contCPU, acertosCPU, tabuleiroJogador, tabuleiroCPU);
//        contCPU++;
//        // Lógica para atualização ou não do número de acertos do jogador
//        acertosCPU = atualizaContagem(tabuleiroJogador);
//      } else {
//        tabuleiroCPU = vezJogador(contJogador, acertosJogador, tabuleiroCPU, tabuleiroJogador);
//        acertosJogador = atualizaContagem(tabuleiroCPU);
//        contJogador++;
//        // Lógica para atualização ou não do número de acertos da CPU
//
//      }
//      contRodadas++;
//      System.out.printf("Rodada: %d", contRodadas);
//      // Verifica se o jogador ou a CPU ganharam após o round atual
//      if(acertosJogador == tabuleiroCPU.length) {
//        System.out.println("Parabéns,você ganhou!!!!!");
//        isPlaying = false;
//      } else if (acertosCPU == tabuleiroJogador.length) {
//        System.out.println("Infelizmente você perdeu! Tente novamente!");
//        isPlaying = false;
//      }
//    }
//  }
//
//
//  public static String[][] vezJogador(int qtdJogadas, int numAcertos, String[][] boardCPU, String[][] boardJogador) {
////    . Navio posicionado N (ene maiúsculo)
////    . Tiro certeiro * (asterisco)
////    . Tiro na água – (traço)
////    . Tiro certeiro com navio posicionado X (xis maiúsculo)
////    . Tiro na água com navio posicionado n (ene minúsculo)
//
//
//    String alphabet = "ABCD";
//    Scanner input = new Scanner(System.in);
//    String linha;
//    int coluna;
//    String[][] tabuleiroCPU, tabuleiroJogador;
//    tabuleiroCPU = boardCPU;
//    tabuleiroJogador = boardJogador;
//
//    linha = linhaTabuleiro(input, alphabet);
//    int index = alphabet.toLowerCase().indexOf(linha.toLowerCase());
//    coluna = colunaTabuleiro(input, alphabet, tabuleiroCPU);
//
//    if ((tabuleiroCPU[index][coluna].equals("C") ||  tabuleiroCPU[index][coluna].equals("c") || tabuleiroCPU[index][coluna].equals("X")) && !(tabuleiroJogador[index][coluna].equals("N") || tabuleiroJogador[index][coluna].equals("n"))) {
//      tabuleiroJogador[index][coluna] = "*";
//      tabuleiroCPU[index][coluna] = "O";
//    } else if ((tabuleiroCPU[index][coluna].equals("C") || tabuleiroCPU[index][coluna].equals("c")) && (tabuleiroJogador[index][coluna].equals("N") || tabuleiroJogador[index][coluna].equals("n"))) {
//      tabuleiroJogador[index][coluna] = "X";
//      tabuleiroCPU[index][coluna] = "O";
//    } else if (!(tabuleiroCPU[index][coluna].equals("C") || tabuleiroCPU[index][coluna].equals("c") || tabuleiroCPU[index][coluna].equals("X")) && (tabuleiroJogador[index][coluna].equals("N") || tabuleiroJogador[index][coluna].equals("n"))) {
//      tabuleiroJogador[index][coluna] = "n";
//    } else if (!(tabuleiroCPU[index][coluna].equals("C") || tabuleiroCPU[index][coluna].equals("c") || tabuleiroCPU[index][coluna].equals("X")) && !(tabuleiroJogador[index][coluna].equals("N") || tabuleiroJogador[index][coluna].equals("n"))) {
//      tabuleiroJogador[index][coluna] = "-";
//    } else {
//      vezJogador(qtdJogadas, numAcertos, boardCPU, boardJogador); // Recursão
//      System.out.println("Repetir a jogada!");
//    }
//
////    setContJogador(qtdJogadas + 1);
//    imprimeTabuleiro(tabuleiroJogador);
//
//    return tabuleiroCPU;
//  }
//
//
//  public static String[][] vezCPU(int qtdJogadas, int numAcertos, String[][] boardJogador, String[][] boardCPU) {
//    Random rand = new Random();
//    int positionX;
//    int positionY;
//    positionX = rand.nextInt(boardJogador.length);
//    positionY = rand.nextInt(boardJogador.length);
//    String[][] tabuleiroCPU, tabuleiroJogador;
//    tabuleiroCPU = boardCPU;
//    tabuleiroJogador = boardJogador;
//    if ((boardJogador[positionX][positionY].equals("N") ||  boardJogador[positionX][positionY].equals("n") || boardJogador[positionX][positionY].equals("X")) && !boardCPU[positionX][positionY].equals("C")) {
//      tabuleiroCPU[positionX][positionY] = "*";
//      tabuleiroJogador[positionX][positionY] = "O";
//    } else if((boardJogador[positionX][positionY].equals("N") || boardJogador[positionX][positionY].equals("n")) && (boardCPU[positionX][positionY].equals("C") || boardCPU[positionX][positionY].equals("c"))) {
//      tabuleiroCPU[positionX][positionY] = "X";
//      tabuleiroJogador[positionX][positionY] = "O";
//    } else if (!(boardJogador[positionX][positionY].equals("N") || boardJogador[positionX][positionY].equals("n") || boardJogador[positionX][positionY].equals("X")) && (boardCPU[positionX][positionY].equals("C") || boardCPU[positionX][positionY].equals("c"))) {
//      tabuleiroCPU[positionX][positionY] = "c";
//    } else if (!(boardJogador[positionX][positionY].equals("N") || boardJogador[positionX][positionY].equals("n") || boardJogador[positionX][positionY].equals("X")) && !(boardCPU[positionX][positionY].equals("C") || boardCPU[positionX][positionY].equals("c"))) {
//      tabuleiroCPU[positionX][positionY] = "-";
//    } else {
//      // Repetir a jogada;
//      vezCPU(qtdJogadas, numAcertos, tabuleiroJogador, tabuleiroCPU);
//      System.out.println("Repetir a jogada!");
//    }
//    System.out.println("\n\nAqui vai o tabuleiro: \n\n");
//    imprimeTabuleiro(tabuleiroCPU);
//
//
//    return tabuleiroJogador;
//  }
//
//  public static int atualizaContagem(String[][] board) {
//    int contagem = 0;
//    // É necessário passar a quantidade de acertos atual do jogador/CPU e o tabuleiro do adversário para fazer a contagem
//    for(int linha = 0; linha < board[0].length; linha++) {
//      for(int coluna = 0; coluna < board.length; coluna++) {
//        if(board[linha][coluna].equals("0")) {
//          contagem++;
//        }
//      }
//    }
//
//    System.out.printf("A quantidade de acertos do jogador atual eh %d%n", contagem);
//    return contagem;
//  }




