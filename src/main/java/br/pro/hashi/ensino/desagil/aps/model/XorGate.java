package br.pro.hashi.ensino.desagil.aps.model;

public class XorGate extends Gate{
    private final NandGate nandMid;
    private final NandGate nandTop;
    private final NandGate nandBottom;
    private final NandGate nandOut;

    public XorGate() {
        super("XOR", 2);

        nandMid = new NandGate();

        nandTop = new NandGate();
        nandTop.connect(1, nandMid);


        nandBottom = new NandGate();
        nandBottom.connect(0, nandMid);


        nandOut = new NandGate();
        nandOut.connect(0, nandTop);
        nandOut.connect(1, nandBottom);

    }



    @Override
    public boolean read() {
        return nandOut.read();
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {

        switch (inputIndex){
            case 0:
                nandMid.connect(0, emitter);
                nandTop.connect(0,emitter);
                break;
            case 1:
                nandMid.connect(1,emitter);
                nandBottom.connect(1, emitter);
                break;
            default:
                throw new IndexOutOfBoundsException(inputIndex);
        }


    }


}
