import java.util.concurrent.locks.ReentrantLock;

public class Cuchillo {
    private int id;
    private ReentrantLock lock;

    public Cuchillo(int id) {
        this.id = id + 1;
        lock = new ReentrantLock();
    }

    public boolean agafaCuchillo(Filosofo filosofo, String mano) {
        if (lock.tryLock()) {
            System.out.println("Cuchillo: " + id + " ocupada");
            return true;
        }
        return false;
    }

    public void deixaCuchillo(Filosofo philosopher, String hand) {
        lock.unlock();
        System.out.println("Cuchillo: " + id + " no ocupada");
    }
}
