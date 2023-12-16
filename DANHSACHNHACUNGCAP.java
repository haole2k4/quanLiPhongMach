
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class DANHSACHNHACUNGCAP {
    NHACUNGCAP[] dsncc;
    int soLuongNCC;

    public void ghiFile() {
        File file = new File("D:\\phongMach_THUOC\\quanLiPhongMach\\nhacungcap.txt");
        PrintWriter write = null;
        try {
            write = new PrintWriter(file);
        } catch (Exception e) {
            System.out.println("LOi mo file!");
        }
        write.println(soLuongNCC);
        for (int i = 0; i < soLuongNCC; i++) {
            write.println(dsncc[i].getLine());
        }

        write.close();
    }

    public void docFile() {
        File file = new File("D:\\phongMach_THUOC\\quanLiPhongMach\\nhacungcap.txt");
        Scanner read = null;
        try {
            read = new Scanner(file);
        } catch (Exception e) {
            System.out.println("Khong the mo file!");
        }
        if (read.hasNextLine()) {
            soLuongNCC = Integer.parseInt(read.nextLine());
            dsncc = new NHACUNGCAP[soLuongNCC];
        } else
            return;
        int i = 0;
        while (read.hasNextLine()) {
            String line = read.nextLine();
            String arr[] = line.split(",");
            dsncc[i] = new NHACUNGCAP();
            dsncc[i].setMaNhaCungCap(arr[0]);
            dsncc[i].setTenNhaCungCap(arr[1]);
            dsncc[i].setDiaChi(arr[2]);
            dsncc[i].setSDT(arr[3]);
            i++;
        }
    }

    public void them() {
        Scanner input = new Scanner(System.in);
        soLuongNCC++;
        if (soLuongNCC == 1) {
            dsncc = new NHACUNGCAP[1];
            dsncc[0] = new NHACUNGCAP();
            dsncc[0].nhap();
        } else {
            this.dsncc = Arrays.copyOf(this.dsncc, soLuongNCC);
            dsncc[soLuongNCC - 1] = new NHACUNGCAP();
            dsncc[soLuongNCC - 1].nhap();
        }
        ghiFile();

    }

    public void xuat() {
        docFile();
        for (int i = 0; i < soLuongNCC; i++) {
            System.out.print((i + 1) + " ");
            dsncc[i].xuat();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DANHSACHNHACUNGCAP test = new DANHSACHNHACUNGCAP();

        test.xuat();
    }
}
