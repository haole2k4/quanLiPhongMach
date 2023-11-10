
import java.util.Arrays;
import java.util.Scanner;

import java.io.*;

public class DSCTPN {
    private ChiTietPhieuNhap[] dsctpn;
    private int soLuong = 0;

    // 3 ham khoi tao
    // HAM DOC FILE
    public void docfile() {
        File file = new File("D:\\phongMach_THUOC\\quanLiPhongMach\\chitietphieunhap.txt");
        Scanner read = null;
        try {
            read = new Scanner(file);

        } catch (Exception e) {
            System.out.println("Loi doc file!");

        }
        if (read.hasNextLine()) {
            soLuong = Integer.parseInt(read.nextLine());
            dsctpn = new ChiTietPhieuNhap[soLuong];
        } else
            return;
        int i = 0;

        while (read.hasNextLine()) {
            dsctpn[i] = new ChiTietPhieuNhap();
            String line = read.nextLine();
            String[] arr = line.split(",");
            dsctpn[i].setMaCTPhieuNhap(arr[0]);
            dsctpn[i].setSoLoaiThuocNhap(Integer.parseInt(arr[1]));
            dsctpn[i].dsThuocNhap = new THUOC[Integer.parseInt(arr[1])];
            System.out.println();
            for (int j = 0; j < dsctpn[i].getSoLoaiThuocNhap(); j++) {
                dsctpn[i].dsThuocNhap[j] = new THUOCVI();
                dsctpn[i].dsThuocNhap[j].setMaThuoc(arr[j * 3 + 2]);
                dsctpn[i].dsThuocNhap[j].setSoLuong(Integer.parseInt(arr[j * 3 + 3]));
                dsctpn[i].dsThuocNhap[j].setGiaCa(Double.parseDouble(arr[j * 3 + 4]));
                dsctpn[i].setThanhTien(Double.parseDouble(arr[arr.length - 1]));

            }
            i++;

        }
        read.close();

    }

    // HAM GHI FILE
    public void ghiFile() {
        File file = new File("D:\\phongMach_THUOC\\quanLiPhongMach\\chitietphieunhap.txt");
        PrintWriter write = null;
        try {
            write = new PrintWriter(file);
        } catch (Exception e) {
            System.out.print("Loi ghi file!");
        }
        write.println(soLuong);
        for (int i = 0; i < soLuong; i++) {
            write.print(dsctpn[i].getChuoiThuocNhap());
            write.println();
        }
        write.close();
    }

    // HAM THEM
    public void them() {

        soLuong++;
        if (soLuong == 1) {
            dsctpn = new ChiTietPhieuNhap[1];
            dsctpn[0] = new ChiTietPhieuNhap();
            dsctpn[0].nhap();
        } else {
            this.dsctpn = Arrays.copyOf(this.dsctpn, soLuong);
            dsctpn[soLuong - 1] = new ChiTietPhieuNhap();
            dsctpn[soLuong - 1].nhap();
        }
        ghiFile();
    }

    public void xoa() {
        Scanner input = new Scanner(System.in);
        System.out.print("nhap ma phieu nhap:");
        String ma = input.nextLine();
        for (int i = 0; i < soLuong; i++) {
            if (ma.equals(dsctpn[i].getMaCTPhieuNhap())) {
                for (int j = i; j < soLuong - 1; j++) {
                    dsctpn[j] = dsctpn[j + 1];
                }
                soLuong--;
            }
        }
        ghiFile();
    }

    public void timKiem() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma chi tiet nhap hang can tim kiem: ");
        String ma = input.nextLine();
        for (int i = 0; i < soLuong; i++) {
            if (dsctpn[i].getMaCTPhieuNhap().equals(ma)) {
                dsctpn[i].xuat();
                return;
            }
        }
        System.out.println("Khong tim thay !");
    }

    public void xuat() {
        for (int i = 0; i < soLuong; i++) {
            dsctpn[i].xuat();
            System.out.println();
        }
    }

    public void menu() {
        System.out.println("        ==> MENU QUAN LY CHI TIET PHIEU NHAP: ");
        System.out.println("        0: BACK");
        System.out.println("        1: Them chi tiet phieu nhap");
        System.out.println("        2: Xoa chi tiet phieu nhap");
        System.out.println("        3: Tim kiem tiet phieu nhap");
        System.out.println("        4: Xem tat ca chi tiet phieu nhap");
        int i;
        do {
            System.out.print("        lua chon: ");
            Scanner input = new Scanner(System.in);
            i = input.nextInt();
            switch (i) {
                case 0: {
                    QUANLYNHAPHANG qlnh = new QUANLYNHAPHANG();
                    qlnh.menu();
                }
                case 1: {
                    them();
                }
                    break;

                case 2: {
                    xoa();
                }
                    break;
                case 3: {
                    timKiem();
                }
                    break;
                case 4: {
                    xuat();
                }
                    break;

            }
        } while (i != 0);
    }

    public static void main(String[] args) {
        DSCTPN test = new DSCTPN();
        test.menu();
    }
}
