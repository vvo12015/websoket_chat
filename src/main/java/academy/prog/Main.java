package academy.prog;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your login: ");
            String login = scanner.nextLine();

            Thread th = new Thread(new GetThread(login));
            th.setDaemon(true);
            th.start();

            while (true) {
                System.out.println("Enter your message: ");
                String text = scanner.nextLine();
                if (text.isEmpty()) break;

                Message m = null;
                System.out.print("Enter to login or enter: ");
                String to = scanner.nextLine();

                if (to.isEmpty()) {
                    to = Utils.ALL_ADDRESSEES;
                    System.out.println(to);
                }
                m = new Message(login, text, to);

                int res = m.send(Utils.getURL() + "/add");

                if (res != 200) { // 200 OK
                    System.out.println("HTTP error occurred: " + res);
                    return;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
}
