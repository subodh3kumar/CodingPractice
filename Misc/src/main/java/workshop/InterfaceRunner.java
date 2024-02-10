package workshop;

public interface InterfaceRunner {

    System.Logger LOG = System.getLogger("Application");

    static void main(String[] args) {
        LOG.log(System.Logger.Level.INFO, "Hello, lazy!");
        LOG.log(System.Logger.Level.INFO, () -> "Hello, there!");
    }
}
