import java.util.Scanner;

public class main {
    static int tentativas;
    static int acertos = 0;
    static int acertosNecessarios = 0;
    static int ctrl = 0;

    public static void main(String[] args) {

        char[][] tabuleiro = new char[10][10];
        char[][] mapa = new char[10][10];

        Scanner input = new Scanner(System.in);
        System.out.print("\nInforme qual mapa você deseja competir 1, 2 ou 3: ");
        int nMapa = input.nextInt();

        mapas(mapa, nMapa);
        montarTabuleiro(tabuleiro);
        countAcertos(mapa);

        imprimirMapas(tabuleiro);

        while (ctrl <= 100 || acertos < acertosNecessarios) {
            jogar(tabuleiro, mapa);
            comparador(tabuleiro, mapa);
            tentativas++;
            imprimirMapas(tabuleiro);
        }

        System.out.println("\n\nJogo Terminou. Você acertou em " + tentativas + " tentativas");
        imprimirMapas(tabuleiro);
    }

    public static void imprimirMapas(char[][] mapas) {
        System.out.printf("\nResultados: \nTentativas: %d\nAcertos: %d\n\n", tentativas, acertos);
        System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \t9 \t10");

        for (int linha = 0; linha < 10; linha++) {
            System.out.print((linha + 1) + "");
            for (int coluna = 0; coluna < 10; coluna++) {
                System.out.print("\t" + mapas[linha][coluna]);
            }
            System.out.println();
        }
    }

    public static void comparador(char[][] tabuleiro, char[][] mapas) {
        for (int linha = 0; linha < 10; linha++) {
            for (int coluna = 0; coluna < 10; coluna++) {
                if (tabuleiro[linha][coluna] != '~') {
                    tabuleiro[linha][coluna] = mapas[linha][coluna];
                    ctrl++;
                }
            }
        }
    }

    public static void montarTabuleiro(char[][] tabuleiro) {
        for (int linha = 0; linha < 10; linha++)
            for (int coluna = 0; coluna < 10; coluna++)
                tabuleiro[linha][coluna] = '~';
    }

    public static void jogar(char[][] tabuleriro, char[][] mapa) {
        int linha;
        int coluna;

        do {
            Scanner input = new Scanner(System.in);

            System.out.print("\nInforme a Linha: ");
            linha = input.nextInt();

            System.out.print("Informe a Coluna: ");
            coluna = input.nextInt();

            if (linha != 0) linha--;
            if (coluna != 0) coluna--;

            if (tabuleriro[linha][coluna] != '~') {
                System.out.println("Esta jogada ja foi efetuada por favor faça outra");
            }

        } while (tabuleriro[linha][coluna] != '~');

        tabuleriro[linha][coluna] = '+';

        if (mapa[linha][coluna] != '+') {
            acertos++;
        }
    }

    public static void countAcertos(char[][] mapa) {
        for (int linha = 0; linha < 10; linha++) {
            for (int coluna = 0; coluna < 10; coluna++) {
                if (mapa[linha][coluna] != '+') {
                    acertosNecessarios++;
                }
            }
        }
    }

    public static void mapas(char[][] mapas, int nMapa) {
        for (int linha = 0; linha < 10; linha++) {
            for (int coluna = 0; coluna < 10; coluna++) {
                mapas[linha][coluna] = '+';
            }
        }

        if (nMapa == 1) {
            // submarinos
            mapas[1][2] = 's';
            mapas[1][3] = 's';
            // contra torpedeiros
            mapas[3][5] = 'c';
            mapas[4][5] = 'c';
            mapas[5][5] = 'c';
            //  navio tanque
            mapas[3][3] = 'n';
            mapas[4][3] = 'n';
            mapas[5][3] = 'n';
            mapas[6][3] = 'n';
            //  porta avião
            mapas[9][5] = 'p';
            mapas[9][6] = 'p';
            mapas[9][7] = 'p';
            mapas[9][8] = 'p';
            mapas[9][9] = 'p';

        } else if (nMapa == 2) {
            // submarinos
            mapas[2][2] = 's';
            mapas[2][3] = 's';
            // contra torpedeiros
            mapas[3][7] = 'c';
            mapas[4][7] = 'c';
            mapas[5][7] = 'c';
            //  navio tanque
            mapas[3][1] = 'n';
            mapas[4][1] = 'n';
            mapas[5][1] = 'n';
            mapas[6][1] = 'n';
            //  porta avião
            mapas[8][5] = 'p';
            mapas[8][6] = 'p';
            mapas[8][7] = 'p';
            mapas[8][8] = 'p';
            mapas[8][9] = 'p';

        } else if (nMapa == 3) {
            // submarinos
            mapas[9][2] = 's';
            mapas[9][3] = 's';
            // contra torpedeiros
            mapas[3][8] = 'c';
            mapas[4][8] = 'c';
            mapas[5][8] = 'c';
            //  navio tanque
            mapas[3][1] = 'n';
            mapas[4][1] = 'n';
            mapas[5][1] = 'n';
            mapas[6][1] = 'n';
            //  porta avião
            mapas[5][5] = 'p';
            mapas[5][6] = 'p';
            mapas[5][7] = 'p';
            mapas[5][8] = 'p';
            mapas[5][9] = 'p';
        }
    }
}