

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
        ngaySinh = LocalDate.of(2000, 01, 01);
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
        System.out.print("\nNhap gioi tinh: ");
        gioiTinh = input.nextLine();
        System.out.print("\nNhap ngay sinh: ");
        String ngaySinhTemp = input.nextLine();
        DateTimeFormatter kieuNgay = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
    public void setMaBS(String mabs){
        maBS = mabs;
    }
    public void setHo(String h){
        ho = h;
    }
    public void setTen(String t){
        ten = t;
    }
    public void setGioiTinh(String gt){
        gioiTinh = gt;
    }
    public void setNgaySinh(LocalDate ns){
        ngaySinh = ns;
    }
    public void setSDT(String sdt){
        SDT = sdt;
    }
    public void setTrinhDo(String td){
        trinhDo = td;
    }
    public void setChuyenNganh(String cn){
        chuyenNganh = cn;
    }
    public void setHoatDong(boolean hd){
        hoatDong = hd;
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
}
