public class Filosofo extends Thread {
    private int id;
    private Cuchillo cIzquiedo;
    private Cuchillo cDerecho;

    public Filosofo(int id, Cuchillo cIzquiedo, Cuchillo cDerecho) {
        this.id = id + 1;
        this.cIzquiedo = cIzquiedo;
        this.cDerecho = cDerecho;
    }

    public void run() {
        while (true) {
            think();
            if (cIzquiedo.agafaCuchillo(this, "izquiedo")) {
                if (cDerecho.agafaCuchillo(this, "derecho")) {
                    eat();
                    cDerecho.deixaCuchillo(this, "derecho");
                }
                cIzquiedo.deixaCuchillo(this, "izquierdo");
            }
        }
    }

    private void think() {
        System.out.println("Filosofo " + id + " pensando...");
        try {
            Thread.sleep((int)(Math.random() * 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        System.out.println("Filosofo (" + id + ") comiendo");
        try {
            Thread.sleep((int)(Math.random() * 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}