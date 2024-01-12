import java.io.*;

public class SerializableThread extends Thread implements Serializable {
    private String threadName;

    SerializableThread(String name){
        threadName = name;
    }

    public void run(){
        System.out.println("Running " +  threadName );
    }

    public static void main(String args[]) {
        SerializableThread T1 = new SerializableThread("Thread-1");
        T1.start();

        try {
            FileOutputStream fileOut = new FileOutputStream("/tmp/thread.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(T1);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/thread.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
