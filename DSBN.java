package doanphongmachoop;

import java.util.Scanner;
import java.time.LocalDate;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DSBN implements arrayInterfaceBENHNHAN{
    private BenhNhan[] dsbn;
    private int n;

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    DSBN() {
        dsbn[0] = null;
        dsbn[0] = new BenhNhan();
        n = 0;
    }

    DSBN(BenhNhan[] dsbn, int n) {
        this.dsbn = dsbn;
        this.n = n;
    }

    DSBN(DSBN l) {
        dsbn = l.dsbn;
        n = l.n;
    }

        public String fileBN()
    {
        return "D:\\phongMach_THUOC\\quanLiPhongMach\\BenhNhan.txt";
    }
    //ham lay dong de ghi vao file
    public String getLine(int i)
    {
        return (dsbn[i].getMaBenhNhan()+","+dsbn[i].getHo()+","+dsbn[i].getTen()+","+dsbn[i].getGioiTinh()+","+dsbn[i].getSDT()+","+dsbn[i].getCanNang()+","+dsbn[i].getChieuCao()+","+dsbn[i].getNgaySinh()+","+dsbn[i].getQueQuan()+","+dsbn[i].getBenhNen()+","+dsbn[i].getNgayKham());
    }
    //ham de xoa data trong 1 file
    public void xoaDataFile(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath, false);
            writer.write("");

            writer.close();
        } catch (IOException e) {
            System.out.println("loi");
        }
    }
    //ham ghi file
    public void ghiLine(String fileName,String s)
    {
        // xoa data trong file tr
        File outFile = new File(fileName);
        PrintWriter write=null;
            try {
                write= new PrintWriter(new FileWriter(outFile,true));
                }
               catch (Exception e){ System.out.println("Khong the tao tap tin ket qua");
                    return;
               }
               write.print(s);
               write.print("\n");
               write.close();
    }
    void ghiFile()
    {
        xoaDataFile(fileBN());
        ghiLine(fileBN(),String.valueOf(n));
        for (int i=0;i<n;i++)
        {
            ghiLine(fileBN(),getLine(i));
        }
    }
    public void NhapBN() {
        //xoa data trong file truoc khi ghi lai file moi
        xoaDataFile(fileBN());
        Scanner input = new Scanner(System.in);
        System.out.print("\nNhap so luong: ");
        n = input.nextInt();
        dsbn = new BenhNhan[n];
        for (int i = 0; i < n; i++) {
            dsbn[i] = new BenhNhan();
            dsbn[i].nhapThongTinBenhNhan();
        }
        ghiFile();
    }
    
        void docData()
        {
            File inFile = new File(fileBN());
            Scanner read = null;
            try
            {
                read = new Scanner(inFile);
            }
            catch (Exception e)
            {
                System.out.print("khong the mo file BenhNhan.txt");
                return ;
            }
            String sl = read.nextLine();
            n = Integer.parseInt(sl);
            dsbn = new BenhNhan[n];
            for (int i=0;i<n;i++)
            {
                dsbn[i] = new BenhNhan();
                String line = read.nextLine();
                String [] str = line.split(",");
                dsbn[i].setMaBenhNhan(str[0]);
                dsbn[i].setHo(str[1]);
                dsbn[i].setTen(str[2]);
                dsbn[i].setGioiTinh(str[3]);
                dsbn[i].setSDT(str[4]);
                dsbn[i].setCanNang(Double.parseDouble(str[5]));
                dsbn[i].setChieuCao(Double.parseDouble(str[6]));
                LocalDate ngaySinhDate = LocalDate.parse(str[7], dateFormatter);
                dsbn[i].setNgaySinh(ngaySinhDate.format(dateFormatter));
                dsbn[i].setQueQuan(str[8]);
                dsbn[i].setBenhNen(str[9]);
                LocalDate ngayKhamDate = LocalDate.parse(str[10], dateFormatter);
                dsbn[i].setNgayKham(ngayKhamDate.format(dateFormatter));
            }
            read.close();
        }
        
    public void XuatBN() {
        for (int i = 0; i < n; i++) {
            dsbn[i].xuatThongTinBenhNhan();
        }
    }

    public void ThemBN() {
        n = dsbn.length;
        dsbn = Arrays.copyOf(dsbn, n + 1);
            dsbn[n] = new BenhNhan();
        dsbn[n].nhapThongTinBenhNhan();
        n++;
        ghiFile();
    }

    public int TimkiemBN(String maBenhNhan) {
        for (int i = 0; i < n; i++) {
            if (dsbn[i].getMaBenhNhan().equals(maBenhNhan)) {
                return i;
            }
        }
        return -1;
    }

    public void XoaBN(String maBenhNhan) {
        int d = TimkiemBN(maBenhNhan);
        if (d == -1) {
            System.out.print("\nKhong ton tai nguoi nay!!!");
        } else {
            System.arraycopy(dsbn, d + 1, dsbn, d, n - d - 1);
            dsbn = Arrays.copyOf(dsbn, n - 1);
            n--;
        }
        ghiFile();
    }

    public void SuaTTBN() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nNhap ma benh nhan: ");
        String ma = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (dsbn[i].getMaBenhNhan().equals(ma)) {
                MenuSua(i);
            }
            else System.out.println("Khong tim thay benh nhan!");
        }
        ghiFile();
    }

    public void MenuSua(int m) {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("\n** MENU Thong Tin Sua **" + "\n1) Ma benh nhan. \n2) Ho. \n3) Ten. \n4) Gioi Tinh. \n5) Ngay Sinh. \n6) SDT. \n7) Can Nang \n8) Chieu Cao. \n9) Ngay Tai Kham.");
        System.out.print("\nChọn thông tin cần sửa: ");
        int menu = input.nextInt();
        input.nextLine();
        switch(menu) {
            case 1:
                System.out.print("\nNhap thong tin sua: ");
                String tt1 = input.nextLine();
                dsbn[m].setMaBenhNhan(tt1);
                break;
            case 2:
                System.out.print("\nNhap thong tin sua: ");
                String tt2 = input.nextLine();
                dsbn[m].setHo(tt2);
                break;
            case 3:
                System.out.print("\nNhap thong tin sua: ");
                String tt3 = input.nextLine();
                dsbn[m].setTen(tt3);
                break;
            case 4:
                System.out.print("\nNhap thong tin sua: ");
                String tt4 = input.nextLine();
                dsbn[m].setGioiTinh(tt4);
                break;
            case 5:
                System.out.print("\nNhap thong tin sua: ");
                String ngaySinhTemp = input.nextLine();
                LocalDate tt5 = LocalDate.parse(ngaySinhTemp, formatter);
                dsbn[m].setNgaySinh(tt5.format(formatter));
                break;
            case 6:
                System.out.print("\nNhap thong tin sua: ");
                String tt6 = input.nextLine();
                dsbn[m].setSDT(tt6);
                break;
            case 7:
                System.out.print("\nNhap thong tín sua: ");
                double tt7 = input.nextDouble();
                dsbn[m].setCanNang(tt7);
                break;
            case 8:
                System.out.print("\nNhap thong tin sua: ");
                double tt8 = input.nextDouble();
                dsbn[m].setChieuCao(tt8);
                break;
            case 9:
                System.out.print("\nNhap thong tin sua (dd/mm/yyyy): ");
                String ngayKhamTemp = input.nextLine();
                LocalDate tt9 = LocalDate.parse(ngayKhamTemp, formatter);
                dsbn[m].setNgayKham(tt9.format(formatter));
                break;
        }
    }
}

