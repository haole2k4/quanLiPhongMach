

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BacSi {
// Thuoc tinh: 
    private String maBS, SDT, trinhDo, chuyenNganh, ho, ten, gioiTinh;
    private LocalDate ngaySinh;   
    private boolean hoatDong;

//Phuong thuc: 
    BacSi(){
        maBS = "NULL";
        ho = "NULL";
        ten = "NULL";
        gioiTinh = "NULL";
        ngaySinh = null;
        SDT = "NULL";
        trinhDo = "NULL";
        chuyenNganh = "NULL";
        hoatDong = false;
    }

    BacSi(String maBS, String ho, String ten, String gioiTinh, LocalDate ngaySinh, String SDT, String trinhDo, String chuyenNganh, boolean hoatDong){
        this.maBS = maBS;
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.SDT = SDT;
        this.trinhDo = trinhDo;
        this.chuyenNganh = chuyenNganh;
        this.hoatDong = hoatDong;
    }

    BacSi(BacSi bs){
        maBS = bs.maBS;
        ho = bs.ho;
        ten = bs.ten;
        gioiTinh = bs.gioiTinh;
        ngaySinh = bs.ngaySinh;
        SDT = bs.SDT;
        trinhDo = bs.trinhDo;
        chuyenNganh = bs.chuyenNganh;
        hoatDong = bs.hoatDong;
    }

//Nhap:
    public void nhap(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma bac si: ");
        maBS = input.nextLine();
        System.out.print("\nNhap ho: ");
        ho = input.nextLine();
        System.out.print("\nNhap ten: ");
        ten = input.nextLine();
        System.out.print("\nNhap gioi tinh (Nam/Nu): ");
        gioiTinh = input.nextLine();
        System.out.print("\nNhap ngay sinh (yyyy-mm-dd): ");
        String ngaySinhTemp = input.nextLine();
        DateTimeFormatter kieuNgay = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ngaySinh = LocalDate.parse(ngaySinhTemp, kieuNgay);
        System.out.print("\nNhap so dien thoai: ");
        SDT = input.nextLine();
        System.out.print("\nNhap trinh do: ");
        trinhDo = input.nextLine();
        System.out.print("\nNhap chuyen nganh: ");
        chuyenNganh = input.nextLine();
        System.out.print("\nNhap hoat dong: ");
        hoatDong = input.nextBoolean();
        System.out.print("\n----------\n");
    }

//Xuat: 
    public void xuat(){
        System.out.print("\n-----------------");
        System.out.print("\nMa bac si: " + maBS + "\nHo: " + ho + "\nTen: " + ten + "\nGioi tinh: " + gioiTinh + 
        "\nNgay sinh: " + ngaySinh + "\nSDT: " + SDT + "\nTrinh do: " + trinhDo + "\nChuyen nganh: " + chuyenNganh + "\nHoat dong: " + hoatDong);
    }

//Set:
    public void setMaBS(String data){
        maBS = data;
    }
    public void setHo(String data){
        ho = data;
    }
    public void setTen(String data){
        ten = data;
    }
    public void setGioiTinh(String data){
        gioiTinh = data;
    }
    public void setNgaySinh(LocalDate data){
        ngaySinh = data;
    }
    public void setSDT(String data){
        SDT = data;
    }
    public void setTrinhDo(String data){
        trinhDo = data;
    }
    public void setChuyenNganh(String data){
        chuyenNganh = data;
    }
    public void setHoatDong(boolean data){
        hoatDong = data;
    }

//Get:
    public String getMaBS(){
        return maBS;
    }
    public String getHo(){
        return ho;
    }
    public String getTen(){
        return ten;
    }
    public String getGioiTinh(){
        return gioiTinh;
    }
    public LocalDate getNgaySinh(){
        return ngaySinh;
    }
    public String getSDT(){
        return SDT;
    }
    public String getTrinhDo(){
        return trinhDo;
    }
    public String getChuyenNganh(){
        return chuyenNganh;
    }
    public boolean getHoatDong(){
        return hoatDong;
    }
    
//Sua: 
    public void menuSua(){
        Scanner input = new Scanner(System.in);
        System.out.print("\n** MENU Thong Tin Sua **" + "\n1) MaBS. \n2) Ho. \n3) Ten. \n4) Gioi Tinh. \n5) Ngay Sinh. \n6) SDT. \n7) Trinh Do \n8) Chuyen Nganh. \n9) Hoat Dong.");
        System.out.print("\nChon thong tin can sua: ");
        int menu = input.nextInt();
        input.nextLine();
        System.out.print("\nNhap noi dung sua: ");
        String nd = input.nextLine();
        switch(menu){
            case 1:
                setMaBS(nd);
                break;
            case 2:
                setHo(nd);
                break;
            case 3:
                setTen(nd);
                break;
            case 4:
                setGioiTinh(nd);
                break;
            case 5:
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
                LocalDate tt5 = LocalDate.parse(nd, formatter);
                setNgaySinh(tt5);
                break;
            case 6:
                setSDT(nd);
                break;
            case 7:
                setTrinhDo(nd);
                break;
            case 8:
                setChuyenNganh(nd);
                break;
            case 9:
                boolean hd;
                hd = Boolean.parseBoolean(nd);
                setHoatDong(hd);
            default:
                System.out.print("Sai!");
        }
    }

    public String getThongTin(){
        String inFor = maBS + "," + ho + "," + ten + "," + gioiTinh + "," + ngaySinh + "," + SDT + "," + trinhDo + "," + chuyenNganh + "," +hoatDong;
        return inFor;
    }
}
