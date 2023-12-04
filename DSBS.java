

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DSBS {
//Thuoc tinh:
    private BacSi [] dsbs;
    private int n;

//Phuong thuc:
    DSBS(){
        dsbs = null;
        n = 0;
    }

    DSBS(BacSi dsbs[], int n){
        this.dsbs = dsbs;
        this.n = n;
    }

    DSBS(DSBS l){
        dsbs = l.dsbs;
        n = l.n;
    }

//Nhap:
    public void Nhap(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nNhap so luong: ");
        n = input.nextInt();
        dsbs = new BacSi[n];
        for(int i = 0; i < n; i++){
            dsbs[i] = new BacSi();
            dsbs[i].nhap();
        }
    }

//Xuat:
    public void Xuat(){
        for(int i = 0; i < n; i++){
            dsbs[i].xuat();
        }
    }

//Them:
    public void Them(){
        n = dsbs.length;
        dsbs = Arrays.copyOf(dsbs, n + 1);
        dsbs[n] = new BacSi();
        n++;
    }

//Tim:
    public int Timkiem(String maBS){
        for(int i = 0; i < n; i++){
            if(dsbs[i].getMaBS().equals(maBS)){
                return i;
            }
        }
        return -1;
    }

//Xoa: 
    public void Xoa(String maBS){
        int d = Timkiem(maBS);
        if(d == -1){
            System.out.print("\nKHONG TON TAI NGUOI NAY!!!");
        }
        else{
            for(int i = d; i < n - 1; i++){
                dsbs[i] = new BacSi(dsbs[i + 1]);
            }
            dsbs = Arrays.copyOf(dsbs, n - 1);
            n--;
        }
    }

//Sua: 
    public void SuaTT(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nNhap ma bac si: ");
        String ma = input.nextLine();
        for(int i = 0; i < n; i++){
            if(dsbs[i].getMaBS().equals(ma)){
                MenuSua(i);
            }
        }
    }
    public void MenuSua(int m){
        Scanner input = new Scanner(System.in);
        System.out.print("\n** MENU Thong Tin Sua **" + "\n1) MaBS. \n2) Ho. \n3) Ten. \n4) Gioi Tinh. \n5) Ngay Sinh. \n6) SDT. \n7) Trinh Do \n8) Chuyen Nganh. \n9) Hoat Dong.");
        System.out.print("\nChon thong tin can sua: ");
        int menu = input.nextInt();
        input.nextLine();
        switch(menu){
            case 1:
                System.out.print("\nNhap thong tin sua: ");
                String tt1 = input.nextLine();
                dsbs[m].setMaBS(tt1);
                break;
            case 2:
                System.out.print("\nNhap thong tin sua: ");
                String tt2 = input.nextLine();
                dsbs[m].setHo(tt2);
                break;
            case 3:
                System.out.print("\nNhap thong tin sua: ");
                String tt3 = input.nextLine();
                dsbs[m].setTen(tt3);
                break;
            case 4:
                System.out.print("\nNhap thong tin sua: ");
                String tt4 = input.nextLine();
                dsbs[m].setGioiTinh(tt4);
                break;
            case 5:
                System.out.print("\nNhap thong tin sua: ");
                String ngaySinhTemp = input.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
                LocalDate tt5 = LocalDate.parse(ngaySinhTemp, formatter);
                dsbs[m].setNgaySinh(tt5);
                break;
            case 6:
                System.out.print("\nNhap thong tin sua: ");
                String tt6 = input.nextLine();
                dsbs[m].setSDT(tt6);
                break;
            case 7:
                System.out.print("\nNhap thong tin sua: ");
                String tt7 = input.nextLine();
                dsbs[m].setTrinhDo(tt7);
            case 8:
                System.out.print("\nNhap thong tin sua: ");
                String tt8 = input.nextLine();
                dsbs[m].setChuyenNganh(tt8);
            case 9:
                System.out.print("\nNhap thong tin sua: ");
                boolean tt9 = input.nextBoolean();
                dsbs[m].setHoatDong(tt9);

        }
    }
}
