class ReaderTask implements Runnable {
    private String readerName;
    private String bookName;
    private Integer ageBook;

    public ReaderTask(String readerName, String bookName, Integer ageBook) {
        this.readerName =  readerName;
        this.bookName = bookName;
        this.ageBook = ageBook;
    }

    @Override

    public void run() {
        try {
            System.out.println(readerName + " kitap izdep jatyr: " + bookName);
            Thread.sleep(1000);

            System.out.println(readerName + " kitapty okyp jatyr: " + bookName);
            Thread.sleep(2000);
            System.out.print(readerName + " kitapty kaitaru: " + bookName);
            Thread.sleep(2000);

            System.out.println(readerName + "Kitap jyly" + ageBook);
            Thread.sleep(2000);

        } catch (InterruptedException e) {

            System.out.println(readerName + " jumys toktaldy. ");
        }
    }
}
public class Main {
    public static void  main(String[] args) {
        ReaderTask reader1 = new ReaderTask("Okyrman 1", "Abay Joly");
        ReaderTask reader2 = new ReaderTask("Okyrmaan 2", "Kara sozder");
        ReaderTask reader3 = new ReaderTask("Okyrmaan 3", "Menin atym Kozha");

        ReaderTask reader4 = new ReaderTask("Okyrman 4",  "2026" );

        Thread thread1 = new Thread(reader1);
        Thread thread2 = new Thread(reader2);
        Thread thread3 = new Thread(reader3);

        Thread thread4 = new Thread(reader4);

        System.out.println("Kitaphana jymysy bastaldy");

        thread1.start();
        thread2.start();
        thread3.start();

        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();

            thread4.join();

        } catch (InterruptedException e) {

            System.out.println("Bagdarlaamaa toktatyldy. ");
        }

        System.out.println(" Barlyk okyrman kitaptaryn kaitardy!");
        System.out.println("Kitaphana jumysy ayaktaldy.");
    }
}