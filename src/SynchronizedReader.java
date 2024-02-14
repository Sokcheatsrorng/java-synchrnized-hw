class Define {
    public synchronized String print(String string) {

        for (int i = 0; i < string.length(); i++) {
            System.out.print(string.charAt(i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return string;
    }

    public String print1(String string) {
        System.out.print(string);
        for (int i = 0; i < string.length(); i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return string;
    }
}

public class SynchronizedReader {
    public static void main(String[] arg) throws InterruptedException {
        Define define = new Define();
        Thread thread1 = new Thread(() -> {
            define.print("WELCOME TO CSTAD!\n");
        });
        Thread thread2 = new Thread(() -> {
            define.print(STR."\{"*".repeat(40)}\n");
        });
        Thread thread3 = new Thread(() -> {
            define.print("Don't give up on this opportunity, do your best first. \n"); // Newline here
        });

        Thread thread4 = new Thread(() -> {
            define.print(STR."\{"-".repeat(40)}\n");
        });
        Thread thread5 = new Thread(() -> {
            define.print1("Downloading ");
            define.print(".".repeat(10));
            define.print1(" completed 100%.\n");
        });
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
        thread4.start();
        thread4.join();
        thread5.start();
        thread5.join();
    }
}
