public class DeadLock {
    public static void main(String[] args) {
        int nFilosofos = 4;
        Filosofo[] filosofos = new Filosofo[nFilosofos];
        Cuchillo[] cuchillos = new Cuchillo[nFilosofos];

        for (int i = 0; i < nFilosofos; i++) {
            cuchillos[i] = new Cuchillo(i);
        }

        for (int i = 0; i < nFilosofos; i++) {
            filosofos[i] = new Filosofo(i, cuchillos[i], cuchillos[(i + 1) % nFilosofos]);
            filosofos[i].start();
        }
    }
}