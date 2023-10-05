package Practica2;


public class CovidTuple {
    private int numCasos;
    private int numCasosPCR;
    private int numCasosTestAC;

    public CovidTuple(int numCasos, int numCasosPCR, int numCasosTestAC) {
        this.numCasos = numCasos;
        this.numCasosPCR = numCasosPCR;
        this.numCasosTestAC = numCasosTestAC;
    }

    public int getNumCasos() {
        return numCasos;
    }

    public void setNumCasos(int numCasos) {
        this.numCasos = numCasos;
    }

    public int getNumCasosPCR() {
        return numCasosPCR;
    }

    public void setNumCasosPCR(int numCasosPCR) {
        this.numCasosPCR = numCasosPCR;
    }

    public int getNumCasosTestAC() {
        return numCasosTestAC;
    }

    public void setNumCasosTestAC(int numCasosTestAC) {
        this.numCasosTestAC = numCasosTestAC;
    }


}
