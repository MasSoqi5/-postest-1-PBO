/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiket_kapal;

import java.util.ArrayList;
import java.util.Scanner;

public class Tiket_Kapal {
    // ArrayList untuk menyimpan data tiket
    static ArrayList<String> namaPenumpang = new ArrayList<>();
    static ArrayList<String> tujuan = new ArrayList<>();
    static ArrayList<Integer> jumlahTiket = new ArrayList<>();
    static ArrayList<Double> harga = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            // Menu utama
            System.out.println("=== SISTEM MANAJEMEN TIKET PELABUHAN KAPAL ===");
            System.out.println("1. Tambah Tiket");
            System.out.println("2. Lihat Semua Tiket");
            System.out.println("3. Update Tiket");
            System.out.println("4. Hapus Tiket");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // buang newline

            switch (pilihan) {
                case 1:
                    tambahTiket(input);
                    break;
                case 2:
                    lihatTiket();
                    break;
                case 3:
                    updateTiket(input);
                    break;
                case 4:
                    hapusTiket(input);
                    break;
                case 5:
                    System.out.println("Terima kasih sudah menggunakan sistem.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!\n");
            }
        } while (pilihan != 5);
    }

    // CREATE
    public static void tambahTiket(Scanner input) {
        System.out.print("Nama Penumpang : ");
        namaPenumpang.add(input.nextLine());

        System.out.print("Tujuan         : ");
        tujuan.add(input.nextLine());

        System.out.print("Jumlah Tiket   : ");
        jumlahTiket.add(input.nextInt());

        System.out.print("Harga          : ");
        harga.add(input.nextDouble());
        input.nextLine();

        System.out.println("Tiket berhasil ditambahkan!\n");
    }

    // READ
    public static void lihatTiket() {
        if (namaPenumpang.isEmpty()) {
            System.out.println("Belum ada tiket yang terdaftar.\n");
        } else {
            System.out.println("=== DAFTAR TIKET ===");
            for (int i = 0; i < namaPenumpang.size(); i++) {
                System.out.println("ID Tiket       : " + (i + 1));
                System.out.println("Nama Penumpang : " + namaPenumpang.get(i));
                System.out.println("Tujuan         : " + tujuan.get(i));
                System.out.println("Jumlah Tiket   : " + jumlahTiket.get(i));
                System.out.println("Harga          : Rp " + harga.get(i));
                System.out.println("----------------------------------");
            }
        }
    }

    // UPDATE
    public static void updateTiket(Scanner input) {
        lihatTiket();
        if (namaPenumpang.isEmpty()) return;

        System.out.print("Masukkan ID tiket yang ingin diupdate: ");
        int id = input.nextInt();
        input.nextLine();

        if (id > 0 && id <= namaPenumpang.size()) {
            System.out.print("Nama Penumpang baru : ");
            namaPenumpang.set(id - 1, input.nextLine());

            System.out.print("Tujuan baru         : ");
            tujuan.set(id - 1, input.nextLine());

            System.out.print("Jumlah Tiket baru   : ");
            jumlahTiket.set(id - 1, input.nextInt());

            System.out.print("Harga baru          : ");
            harga.set(id - 1, input.nextDouble());
            input.nextLine();

            System.out.println("Tiket berhasil diupdate!\n");
        } else {
            System.out.println("ID tidak valid!\n");
        }
    }

    // DELETE
    public static void hapusTiket(Scanner input) {
        lihatTiket();
        if (namaPenumpang.isEmpty()) return;

        System.out.print("Masukkan ID tiket yang ingin dihapus: ");
        int id = input.nextInt();
        input.nextLine();

        if (id > 0 && id <= namaPenumpang.size()) {
            namaPenumpang.remove(id - 1);
            tujuan.remove(id - 1);
            jumlahTiket.remove(id - 1);
            harga.remove(id - 1);

            System.out.println("Tiket berhasil dihapus!\n");
        } else {
            System.out.println("ID tidak valid!\n");
        }
    }
}
