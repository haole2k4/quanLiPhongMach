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
        dsbn = new BenhNhan[1000];
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

    public int getSLBN() {
        n = dsbn.length;
        return n;
    }

    public String fileBN()
    {
        return "data/BenhNhan.txt";
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
        Scanner input = new Scanner(System.in);
        System.out.println("Thuc hien tiep se dan den viec mat toan bo du lieu da luu, ban co chac chan tiep tuc?");
        System.out.println("1) Tiep tuc.\n2) Quay lai.");
        int option = input.nextInt();
        while (option != 2)
        switch (option) {
            case 1:
                xoaDataFile(fileBN());
                System.out.print("\nNhap so luong: ");
                int soLuongNhap = input.nextInt();
                int soLuongHienTai = getSLBN();
                int maBatDau = soLuongHienTai + 1;
            
                dsbn = Arrays.copyOf(dsbn, soLuongHienTai + soLuongNhap);
            
                for (int i = soLuongHienTai; i < soLuongHienTai + soLuongNhap; i++) {
                    int MaBN = maBatDau++;
                    dsbn[i] = new BenhNhan();
                    dsbn[i].nhapThongTinBenhNhan(MaBN);
                }
                n = soLuongHienTai + soLuongNhap;
                ghiFile();            
                break;
            default:
                break;
        }
        // xoa data trong file truoc khi ghi lai file moi
    }
    
        void docData()
        {
            File inFile = new File(fileBN());
            Scanner read = null;

            if (!inFile.exists()) System.out.println("File does not exist: " + fileBN());

            try
            {
                read = new Scanner(inFile);
                if (read.hasNextLine()) 
                {
                    n = Integer.parseInt(read.nextLine());
                    dsbn = new BenhNhan[n];
                    for (int i=0;i<n;i++)
                    {
                        dsbn[i] = new BenhNhan();
                        String line = read.nextLine();
                        String [] str = line.split(",");
                        dsbn[i].setMaBenhNhan(Integer.parseInt(str[0]));
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
            }
                else System.out.println("File is empty!");
            }
            catch (Exception e)
            {
                System.out.print("khong the mo file BenhNhan.txt");
            }
            finally 
            {
                if (read != null) {
                    read.close();
                }
            }
        }
        
    public void xuatThongTinBenhNhan(int i) {
                System.out.format(  "%-12s %1s %-21s %1s %-9s %1s %-11s %1s %-13s %1s %-14s %1s %-10s %1s %-10s %1s %-12s %1s %-10s", dsbn[i].getMaBenhNhan(),"|", dsbn[i].getHo() + " " + dsbn[i].getTen(),"|", dsbn[i].getGioiTinh(),"|",dsbn[i].getSDT(),"|",dsbn[i].getCanNang(),"|",dsbn[i].getChieuCao(),"|",dsbn[i].getNgaySinh(),"|",dsbn[i].getQueQuan(),"|",dsbn[i].getBenhNen(),"|",dsbn[i].getNgayKham());
        }

    public void XuatBN() {
            System.out.println("-".repeat(65) + "DANH SACH BENH NHAN" + "-".repeat(65));
            System.out.format("%-12s %1s %-21s %1s %-9s %1s %-11s %1s %-13s %1s %-14s %1s %-10s %1s %-10s %1s %-12s %1s %-10s", "Ma benh nhan", "|", "Ho ten", "|", "Gioi tinh","|","SDT","|","Can nang(kg)","|","Chieu cao(kg)","|","Ngay sinh","|","Que quan","|","Benh nen","|","Ngay kham");
            System.out.println();
            System.out.print("-".repeat(149));
            for (int i = 0; i < n; i++) {
                System.out.println();
                xuatThongTinBenhNhan(i);
            } 
    }

    public void ThemBN() {
        dsbn = Arrays.copyOf(dsbn, n + 1);
        int MaBN = n;
        dsbn[n] = new BenhNhan();
        dsbn[n].nhapThongTinBenhNhan(MaBN);
        n++;
        ghiFile();
    }

    // public int TimkiemBN(String maBenhNhan) {
    //     for (int i = 0; i < n; i++) {
    //         if (dsbn[i].getMaBenhNhan().equals(maBenhNhan)) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    public void TimkiemBN() {
        int option = 0;
        while (option != 5) {
            System.out.println("\n----------------------");
            System.out.println("Chon thong tin can loc:\n1) Ma benh nhan.\n2) Ho.\n3) Gioi tinh. \n4) Que quan.\n5) Quay lai. ");
            System.out.print("Moi nhap lua chon: ");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();
            sc.nextLine();
    
            switch (option) {
                case 1:
                    System.out.print("\nNhap ma benh nhan can tim: ");
                    int ma2 = sc.nextInt();
                    boolean found = false;
                    for (int i = 0; i < n; i++) {
                        if (dsbn[i].getMaBenhNhan() == ma2) {
                            System.out.format("%-12s %1s %-21s %1s %-9s %1s %-11s %1s %-13s %1s %-14s %1s %-10s %1s %-10s %1s %-12s %1s %-10s", "Ma benh nhan", "|", "Ho ten", "|", "Gioi tinh","|","SDT","|","Can nang(kg)","|","Chieu cao(kg)","|","Ngay sinh","|","Que quan","|","Benh nen","|","Ngay kham");
                            System.out.println();
                            xuatThongTinBenhNhan(i);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Benh nhan khong ton tai!");
                    }
                    break;
    
                case 2:
                    System.out.print("\nNhap ho benh nhan can tim: ");
                    String ho2 = sc.nextLine();
                    boolean foundAny = false;
                    for (int i = 0; i < n; i++) {
                        if (dsbn[i].getHo().equalsIgnoreCase(ho2)) {
                            if (!foundAny) {
                                System.out.format("%-12s %1s %-21s %1s %-9s %1s %-11s %1s %-13s %1s %-14s %1s %-10s %1s %-10s %1s %-12s %1s %-10s", "Ma benh nhan", "|", "Ho ten", "|", "Gioi tinh","|","SDT","|","Can nang(kg)","|","Chieu cao(kg)","|","Ngay sinh","|","Que quan","|","Benh nen","|","Ngay kham");
                                System.out.println();
                                foundAny = true;
                            }
                            xuatThongTinBenhNhan(i);
                            System.out.println();
                        }
                    }
                    if (!foundAny) {
                        System.out.println("Benh nhan khong ton tai!");
                    }
                    break;

                case 3:
                    System.out.print("\nNhap gioi tinh can liet ke (Nam/Nu): ");
                    String gioiTinh2 = sc.nextLine();
                    boolean foundGender = false;
                    for (int i = 0; i < n; i++) {
                        if (dsbn[i].getGioiTinh().equalsIgnoreCase(gioiTinh2)) {
                            if (!foundGender) {
                                System.out.format("%-12s %1s %-21s %1s %-9s %1s %-11s %1s %-13s %1s %-14s %1s %-10s %1s %-10s %1s %-12s %1s %-10s", "Ma benh nhan", "|", "Ho ten", "|", "Gioi tinh","|","SDT","|","Can nang(kg)","|","Chieu cao(kg)","|","Ngay sinh","|","Que quan","|","Benh nen","|","Ngay kham");
                                System.out.println();
                                foundGender = true;
                            }
                            xuatThongTinBenhNhan(i);
                            System.out.println();
                        }
                    }
                    if (!foundGender) {
                        System.out.println("Khong co benh nhan voi gioi tinh nay!");
                    }
                    break;
    
                case 4:
                    System.out.print("\nNhap que quan benh nhan can tim: ");
                    String queQuan2 = sc.nextLine();
                    boolean foundHometown = false;
                    for (int i = 0; i < n; i++) {
                        if (dsbn[i].getQueQuan().equalsIgnoreCase(queQuan2)) {
                            if (!foundHometown) {
                                System.out.format("%-12s %1s %-21s %1s %-9s %1s %-11s %1s %-13s %1s %-14s %1s %-10s %1s %-10s %1s %-12s %1s %-10s", "Ma benh nhan", "|", "Ho ten", "|", "Gioi tinh","|","SDT","|","Can nang(kg)","|","Chieu cao(kg)","|","Ngay sinh","|","Que quan","|","Benh nen","|","Ngay kham");
                                System.out.println();
                                foundHometown = true;
                            }
                            xuatThongTinBenhNhan(i);
                            System.out.println();
                        }
                    }
                    if (!foundHometown) {
                        System.out.println("Khong co benh nhan voi que quan nay!");
                    }
                    break;
            }
        }
    }
    public BenhNhan timKiemBenhNhan(String ma){
        for (int i=0;i<n;i++){
            if (ma.equals(dsbn[i].getMaBenhNhan())){
                return dsbn[i];
            }
        }
        return null;
    }
    
    public void XoaBN(int maBenhNhan) {
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (dsbn[i].getMaBenhNhan() == maBenhNhan) {
                System.arraycopy(dsbn, i + 1, dsbn, i, n - i - 1);
                dsbn = Arrays.copyOf(dsbn, n - 1);
                n--;
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("\nKhong tim thay benh nhan!");
        } else {
            System.out.println("\nDa xoa benh nhan co ma " + maBenhNhan);
        }
    
        ghiFile();
    }
    

    public void SuaTTBN() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nNhap ma benh nhan can sua: ");
        int ma = input.nextInt();
        int foundIndex = -1;
        for (int i = 0; i < n; i++) {
            if (dsbn[i].getMaBenhNhan() == ma) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex != -1) {
            MenuSua(foundIndex);
        } else {
            System.out.println("Khong tim thay benh nhan!");
        }
        ghiFile();
    }

    public void MenuSua(int m) {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("\n** MENU Thong Tin Sua **" + "\n1) Ma benh nhan. \n2) Ho. \n3) Ten. \n4) Gioi Tinh. \n5) Ngay Sinh. \n6) SDT. \n7) Can Nang \n8) Chieu Cao. \n9) Ngay Tai Kham.");
        System.out.print("\nChon thong tin can sua: ");
        int menu = input.nextInt();
        input.nextLine();
        switch(menu) {
            case 1:
                System.out.print("\nNhap thong tin sua: ");
                int tt1 = input.nextInt();
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
                System.out.print("\nNhap thong tin sua: ");
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

    public void menuThongKe() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("**Menu thong ke thong tin benh nhan**\n1) So luong, nam va nu.\n2) Theo do tuoi.\n3) Trang thai suc khoe.\n4) Can nang va chieu cao.");
        System.out.print("Chon loai thong ke: ");
        int menu = sc.nextInt();
        sc.nextLine();
        switch(menu) {
            case 1:
                thongKeGioiTinh();
                break;
            case 2:
                thongKeDoTuoi();
                break;
            case 3:
                thongKeSucKhoe();
                break;
            case 4:
                thongKeCanNangChieuCao();
                break;
            default:
                System.out.println("Lua chon khong hop le.");
        }
    }
    
    public void thongKeGioiTinh() {
        int soNam = 0;
        int soNu = 0;
        
        for (int i = 0; i < n; i++) {
            if (dsbn[i].getGioiTinh().equalsIgnoreCase("Nam")) {
                soNam++;
            } else if (dsbn[i].getGioiTinh().equalsIgnoreCase("Nu")) {
                soNu++;
            }
        }
        
        System.out.println("Tong so benh nhan: " + n);
        System.out.println("So luong nam: " + soNam + " (" + (soNam * 100.0 / n) + "%)");
        System.out.println("So luong nu: " + soNu + " (" + (soNu * 100.0 / n) + "%)");
    }
    
    public void thongKeDoTuoi() {
        int[] soLuongDoTuoi = new int[7];
        int tongTuoi = 0;
    
        for (int i = 0; i < n; i++) {
            LocalDate ngaySinh = LocalDate.parse(dsbn[i].getNgaySinh(), dateFormatter);
            int tuoi = LocalDate.now().getYear() - ngaySinh.getYear();
            
            if (tuoi <= 10) {
                soLuongDoTuoi[0]++;
            } else if (tuoi <= 20) {
                soLuongDoTuoi[1]++;
            } else if (tuoi <= 30) {
                soLuongDoTuoi[2]++;
            } else if (tuoi <= 40) {
                soLuongDoTuoi[3]++;
            } else if (tuoi <= 50) {
                soLuongDoTuoi[4]++;
            } else if (tuoi <= 60) {
                soLuongDoTuoi[5]++;
            } else {
                soLuongDoTuoi[6]++;
            }
    
            tongTuoi += tuoi;
        }
    
        System.out.println("So luong benh nhan theo do tuoi:");
        System.out.println("0-10: " + soLuongDoTuoi[0]);
        System.out.println("11-20: " + soLuongDoTuoi[1]);
        System.out.println("21-30: " + soLuongDoTuoi[2]);
        System.out.println("31-40: " + soLuongDoTuoi[3]);
        System.out.println("41-50: " + soLuongDoTuoi[4]);
        System.out.println("51-60: " + soLuongDoTuoi[5]);
        System.out.println("61+: " + soLuongDoTuoi[6]);
        
        System.out.println("Do tuoi trung binh: " + (tongTuoi * 1.0 / n));
    }
    
    public void thongKeSucKhoe() {
        int soBenhNhanCoBenhNen = 0;
        for (int i = 0; i < n; i++) {
            if (!dsbn[i].getBenhNen().equalsIgnoreCase("khong co")) {
                soBenhNhanCoBenhNen++;
            }
        }
        System.out.println("So luong benh nhan co benh nen: " + soBenhNhanCoBenhNen);
    }
    
    public void thongKeCanNangChieuCao() {
        double trungBinhCanNang = 0.0;
        double trungBinhChieuCao = 0.0;
    
        for (int i = 0; i < n; i++) {
            trungBinhCanNang += dsbn[i].getCanNang();
            trungBinhChieuCao += dsbn[i].getChieuCao();
        }
    
        trungBinhCanNang /= n;
        trungBinhChieuCao /= n;
    
        System.out.println("Trung binh can nang: " + trungBinhCanNang + "kg.");
        System.out.println("Trung binh chieu cao: " + trungBinhChieuCao + "cm.");
    }
}

