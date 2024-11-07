
import java.util.Scanner;

public class BioskopWithScanner23 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] penonton = new String[4][2];
        int menuOption;

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Input data penonton");
            System.out.println("2. Tampilkan daftar penonton");
            System.out.println("3. Exit");
            System.out.print("Pilih menu: ");
            menuOption = input.nextInt();
            input.nextLine();

            if (menuOption == 1) {
                while (true) {
                    System.out.print("Masukkan nama: ");
                    String nama = input.nextLine();

                    System.out.print("Masukkan baris: ");
                    int baris = input.nextInt();
                    System.out.print("Masukkan kolom: ");
                    int kolom = input.nextInt();
                    input.nextLine();

                    // Handle jika baris atau kolom tidak valid
                    if (baris < 1 || baris > 4 || kolom < 1 || kolom > 2) {
                        System.out.println("Nomor baris atau kolom tidak tersedia. Silakan coba lagi.");
                        continue;
                    }

                    // Warning jika kursi sudah terisi
                    if (penonton[baris - 1][kolom - 1] != null) {
                        System.out.println("Kursi sudah terisi! Silakan pilih kursi lain.");
                        continue;
                    }

                    penonton[baris - 1][kolom - 1] = nama;

                    System.out.print("Input penonton lainnya? (y/n): ");
                    String next = input.nextLine();

                    if (next.equalsIgnoreCase("n")) {
                        break;
                    }
                }
            } else if (menuOption == 2) {
                System.out.println("\n--- Daftar Penonton ---");
                for (int i = 0; i < penonton.length; i++) {
                    for (int j = 0; j < penonton[i].length; j++) {
                        if (penonton[i][j] == null) {
                            System.out.print("***\t");
                        } else {
                            System.out.print(penonton[i][j] + "\t");
                        }
                    }
                    System.out.println();
                }
            } else if (menuOption == 3) {
                System.out.println("Keluar dari program...");
                break;
            } else {
                System.out.println("Opsi tidak valid. Silakan pilih menu yang tersedia.");
            }
        }

        input.close();
    }
}
