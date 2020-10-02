package br.pro.hashi.ensino.desagil.aps.model;

public class OrGate extends Gate {
    private final NandGate nandA;
    private final NandGate nandB;
    private final NandGate nandAB;


    public OrGate  () {
        super("OR", 2);
        nandA = new NandGate();
        nandB = new NandGate();
        nandAB = new NandGate();

        nandAB.connect(0, nandA);
        nandAB.connect(1, nandB);
    }

    @Override
    public boolean read() {
        return nandAB.read();
    }


    @Override
    public void connect(int inputIndex, Emitter emitter) {
        switch (inputIndex){
            case 0:
                nandA.connect(0,emitter);
                nandA.connect(1, emitter);
                break;
            case 1:
                nandB.connect(0,emitter);
                nandB.connect(1,emitter);
                break;
            default:
                throw new IndexOutOfBoundsException(inputIndex);
        }
    }

}
