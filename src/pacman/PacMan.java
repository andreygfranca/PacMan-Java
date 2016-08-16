package pacman;

public class PacMan {

    private int x, y, pontos, dir;
    private boolean lockMove;

    public PacMan() {
    }

    public PacMan(int x, int y, int pontos, int dir) {
        this.x = x;
        this.y = y;
        this.pontos = pontos;
        this.dir = dir;
    }

    public void colisao() {
        System.out.println("x:" + x + "  y:" + y);
        if (dir == 3 && y > 180 && (x > 30 && x < 120 || x > 133 && x < 193 || x > 208 && x < 431 || x > 448 && x < 504 || x > 519 && x < 604)) {
            lockMove = true;
        } else if ((dir == 1 && x < 30 && (y > 35 && y < 179)) || (dir == 4 && x > 603 && (y > 35 && y < 179))) {
            lockMove = true;
        } else if (dir == 4 && (y > 35 && y < 80) && (x > 32 && x < 88)) {
            lockMove = true;
        } else if (dir == 1 && (x > 195 && x < 400) && (y < 100)) {
            lockMove = true;
        } else if (dir == 3 && (x > 223 && x < 430) && (y < 109)) {
            lockMove = true;
        } else if (dir == 4 && (x > 223 && x < 430) && (y < 100)) {
            lockMove = true;
        } else if (dir == 2 && (x > 502 && x < 597) && y < 30) {
            lockMove = true;
        } else if (dir == 1 && x > 540 && y > 77 && y < 133) {
            lockMove = true;
        } else if (dir == 3 && x > 508 && x < 572 && y < 105 && y > 61) {
            lockMove = true;
        } else if (dir == 2 && x > 508 && x < 572 && y < 161 && y > 1) {
            lockMove = true;
        } //tratamento entrada do c
        else if (dir == 4 && x < 92 && y > 77 && y < 137) {
            lockMove = true;
        } else if (dir == 3 && x > 64 && x < 112 && y < 105 && y > 61) {
            lockMove = true;
        } else if (dir == 2 && x > 68 && x < 120 && y < 161 && y > 109) {
            lockMove = true;
        } // pernas do c
        else if (dir == 4 && x > 64 && x < 124 && ((y > 35 && y < 101) || (y > 120 && y < 178))) {
            lockMove = true;
        } // poste apos o c
        else if (dir == 1 && y > 78 && y < 185 && x > 123 && x < 192) {
            lockMove = true;
        } else if (dir == 4 && y > 78 && y < 185 && x > 145 && x < 197) {
            lockMove = true;
        } else if (dir == 2 && y > 68 && y < 185 && x > 134 && x < 192) {
            lockMove = true;
        } // poste ao lado do c contrario
        else if (dir == 1 && y > 78 && y < 185 && x > 435 && x < 498) {
            lockMove = true;
        } else if (dir == 4 && y > 78 && y < 185 && x > 444 && x < 508) {
            lockMove = true;
        } else if (dir == 2 && y > 68 && y < 185 && x > 444 && x < 500) {
            lockMove = true;
        } // tratamento barrona
        else if (dir == 2 && y > 105 && y < 240 && x > 204 && x < 428) {
            lockMove = true;
        } else if (dir == 1 && y > 108 && y < 170 && x > 190 && x < 400) {
            lockMove = true;
        } else if (dir == 4 && y > 117 && y < 177 && x < 438 && x > 300) {
            lockMove = true;
        } // pernas c contrario
        else if (dir == 1 && x > 504 && x < 580 && y > 129 && y < 177) {
            lockMove = true;
        } else if (dir == 1 && x > 504 && x < 580 && y > 41 && y < 97) {
            lockMove = true;
        } else {
            lockMove = false;
        }

    }

    //TODO
    //Funcao que move o pacman pela tela e trata as colisoes
    public void mover() {
        colisao();
        if (lockMove == false) {
            switch (dir) {
                case 1:
                    if (x < 613) {
                        x += 4;
                    }
                    break;
                case 2:
                    if (y < 189) {
                        y += 4;
                    }
                    break;
                case 3:
                    if (y > 25) {
                        y -= 4;
                    }
                    break;
                case 4:
                    if (x > 25) {
                        x -= 4;
                    }
                    break;
                default:
                    break;
            }
        }

    }
    //TODO
    //Funcao que define o fim do jogo

    public void ganhar() {

    }

    //TODO
    //Funcao Game over que define o fim do jogo
    public void perder() {
        
        System.exit(0);

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

}
