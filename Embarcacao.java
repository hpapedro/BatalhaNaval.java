package Marcha;

public abstract class Embarcacao {
    protected char tipo;
    protected int tamanho;

    public Embarcacao(char tipo, int tamanho) {
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    public char getTipo() {
        return tipo;
    }

    public int getTamanho() {
        return tamanho;
    }
}

class PortaAvioes extends Embarcacao {
    public PortaAvioes() {
        super('a', 8);
    }
}

class Destroyer extends Embarcacao {
    public Destroyer() {
        super('d', 5);
    }
}

class Submarino extends Embarcacao {
    public Submarino() {
        super('s', 4);
    }
}

class Fragata extends Embarcacao {
    public Fragata() {
        super('f', 3);
    }
}

class Bote extends Embarcacao {
    public Bote() {
        super('b', 2);
    }
}
