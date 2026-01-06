import javax.swing.*;

public class JogoDaVelha {
    public static void main(String[] args) {
        char[][] jogoDaVelha = new char[3][3];
        boolean venceu = false;
        boolean escolhaInvalida = true;
        char jogadorAtual = ' ';
        int jogadas = 0;

        while (escolhaInvalida) {
            int escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha sua forma: \n1- X\n2- O"));

            if (escolha == 1) {
                jogadorAtual = 'X';
                escolhaInvalida = false;
            } else if (escolha == 2) {
                jogadorAtual = 'O';
                escolhaInvalida = false;
            } else {
                JOptionPane.showMessageDialog(null, "Escolha uma forma válida");
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                jogoDaVelha[i][j] = '-';
            }
        }

        while (!venceu && jogadas < 9) {
            int linha, coluna;

            while (true) {
                String tabuleiro = montarTabuleiro(jogoDaVelha);
                String entradaLinha = JOptionPane.showInputDialog(
                        "Jogador " + jogadorAtual + ", escolha uma linha (0 a 2):\n\n" + tabuleiro);
                linha = Integer.parseInt(entradaLinha);

                String entradaColuna = JOptionPane.showInputDialog(
                        "Jogador " + jogadorAtual + ", escolha uma coluna (0 a 2):\n\n" + tabuleiro);
                coluna = Integer.parseInt(entradaColuna);

                if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3) {
                    if (jogoDaVelha[linha][coluna] == '-') {
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Posição já ocupada! Escolha outra.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Posição inválida! Digite valores entre 0 e 2.");
                }
            }

            jogoDaVelha[linha][coluna] = jogadorAtual;
            jogadas++;

            JOptionPane.showMessageDialog(null, montarTabuleiro(jogoDaVelha));

            for (int i = 0; i < 3; i++) {
                if (
                        (jogoDaVelha[i][0] == jogadorAtual && jogoDaVelha[i][1] == jogadorAtual && jogoDaVelha[i][2] == jogadorAtual) ||
                                (jogoDaVelha[0][i] == jogadorAtual && jogoDaVelha[1][i] == jogadorAtual && jogoDaVelha[2][i] == jogadorAtual)
                ) {
                    venceu = true;
                }
            }
            if (
                    (jogoDaVelha[0][0] == jogadorAtual && jogoDaVelha[1][1] == jogadorAtual && jogoDaVelha[2][2] == jogadorAtual) ||
                            (jogoDaVelha[0][2] == jogadorAtual && jogoDaVelha[1][1] == jogadorAtual && jogoDaVelha[2][0] == jogadorAtual)
            ) {
                venceu = true;
            }

            if (venceu) {
                JOptionPane.showMessageDialog(null, "Jogador " + jogadorAtual + " venceu em " + jogadas + " jogadas!");
            } else if (jogadas == 9) {
                JOptionPane.showMessageDialog(null, "Empate! Todas as posições foram preenchidas.");
            } else {
                jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
            }
        }
    }

    public static String montarTabuleiro(char[][] tabuleiro) {
        String linha1 = tabuleiro[0][0] + " | " + tabuleiro[0][1] + " | " + tabuleiro[0][2] + "\n";
        String linha2 = tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | " + tabuleiro[1][2] + "\n";
        String linha3 = tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | " + tabuleiro[2][2] + "\n";
        return linha1 + linha2 + linha3;
    }
}

