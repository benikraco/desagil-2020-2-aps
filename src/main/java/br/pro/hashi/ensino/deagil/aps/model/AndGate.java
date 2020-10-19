package br.pro.hashi.ensino.deagil.aps.model;

public class AndGate extends Gate {
    private final NandGate nandFirst;
    private final NandGate nandSecond;

    public AndGate() {
        super("AND", 2);

        nandFirst = new NandGate();
        nandSecond = new NandGate();

        nandSecond.connect(0, nandFirst);
        nandSecond.connect(1, nandFirst);

    }

    @Override
    public boolean read() {
        return nandSecond.read();
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if (inputIndex > 1 || inputIndex < 0) {
            throw new IndexOutOfBoundsException(inputIndex);
        }
        nandFirst.connect(inputIndex, emitter);
    }
}




