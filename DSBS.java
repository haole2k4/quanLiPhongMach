

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DSBS {
//Thuoc tinh:
    private BacSi [] dsbs;
    private int n;

//Phuong thuc:
    DSBS(){
        dsbs = new BacSi[1];
        dsbs [0] = null;
        dsbs [0] = new BacSi();
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

//     public String fileBS(){
//         return "data/BacSi.txt";
//     }

// // Ham lay dong de ghi vao file
//     public String getLine(int i){
//         return (dsbs[i].getMaBS()+","+dsbs[i].getHo()+","+dsbs[i].getTen()+","+dsbs[i].getGioiTinh()+","+dsbs[i].getNgaySinh()+","+dsbs[i].getSDT()+","+dsbs[i].getTrinhDo()+","+dsbs[i].getChuyenNganh()+","+dsbs[i].getHoatDong());
//     }

// // Ham xoa data trong file
//     public void xoaDataFile(String filePath){
//         try{
//             FileWriter writer = new FileWriter(filePath, false);
//             writer.write("");
//             writer.close();
//         } catch(IOException e){
//             System.out.print("\nLoi");
//         }
//     }

// // Ham ghi file
//     public void ghiLine(String fileName, String s){
//         // Xoa data trong file truoc
//         File outFile = new File(fileName);
//         PrintWriter write = null;
//         try{
//             write = new PrintWriter(new FileWriter(outFile, true));
//         } catch(Exception e){
//             System.out.print("\nKhong the tao tap tin ket qua");
//             return;
//         }
//         write.print(s);
//         write.print("\n");
//         write.close();
//     }

    void ghiFile(String filePath){
        File file = new File(filePath);
        PrintWriter write = null;
        try {
            write = new PrintWriter(file);
        } catch (Exception e) {
            System.out.println("loi ghi file!");
        }
        write.println(n);
        for (int i = 0; i < n; i++) {
            write.println(dsbs[i].getThongTin());
        }
        write.close();
    }

//Nhap:
    public void nhap(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nNhap so luong: ");
        n = input.nextInt();
        dsbs = new BacSi[n];
        for(int i = 0; i < n; i++){
            dsbs[i] = new BacSi();
            System.out.print("Bac si ["+(i+1)+"] : \n");
            dsbs[i].nhap();
            System.out.print("\n");
        }
        
    }

// Ham doc file
    void docData(String filePath){
        File inFile = new File(filePath);
        Scanner read = null;
        try{
            read = new Scanner(inFile);   
        } catch( Exception e){
            System.out.print("Khong mo duoc file BacSi.txt");
            return;
        }
        String sl = read.nextLine();
        n = Integer.parseInt(sl);
        dsbs = new BacSi[n];
        for(int i = 0; i < n; i++){
            dsbs[i] = new BacSi();
            String line = read.nextLine();
            String [] str = line.split(",");
            dsbs[i].setMaBS(str[0]);
            dsbs[i].setHo(str[1]);
            dsbs[i].setTen(str[2]);
            dsbs[i].setGioiTinh(str[3]);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate tempNgaySinh = LocalDate.parse(str[4], formatter);
            dsbs[i].setNgaySinh(tempNgaySinh);
            dsbs[i].setSDT(str[5]);
            dsbs[i].setTrinhDo(str[6]);
            dsbs[i].setChuyenNganh(str[7]);
            dsbs[i].setHoatDong(Boolean.parseBoolean(str[8]));
        }
        read.close();
    }

//Xuat:
    public void xuat(){
        System.out.print("\nDanh sach bac si: ");
        for(int i = 0; i < n; i++){
            dsbs[i].xuat();
            System.out.print("\n");
        }
    }

//Them:
    public void them(){
        // n = dsbs.length;
        dsbs = Arrays.copyOf(dsbs, n + 1);
        dsbs[n] = new BacSi();
        dsbs[n].nhap();
        n++;
        
    }

// Sua
    void sua(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nNhap ma bac si can sua: ");
        String ma = input.nextLine();
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(ma.equals(dsbs[i].getMaBS())){
                flag = true;
                dsbs[i].menuSua();
            }
        } if(!flag){
            System.out.print("\nKhong tim thay bac si !!!");
        }
        
    }

    void sua(String ma){
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(ma.equals(dsbs[i].getMaBS())){
                flag = true;
                dsbs[i].menuSua();
            }
        } if(!flag){
            System.out.print("\nKhong tim thay bac si !!!");
        }
        
    }

//Tim:
    // public int timKiem(String maBS){
    //     for(int i = 0; i < n; i++){
    //         if(dsbs[i].getMaBS().equals(maBS)){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

//Xoa: 
    
    // public void Xoa(String maBS){
    //     int d = timKiem(maBS);
    //     if(d == -1){
    //         System.out.print("\nKHONG TON TAI NGUOI NAY!!!");
    //     }
    //     else{
    //         for(int i = d; i < n - 1; i++){
    //             dsbs[i] = new BacSi(dsbs[i + 1]);
    //         }
    //         dsbs = Arrays.copyOf(dsbs, n - 1);
    //         n--;
    //     }
    // }

// Xoa
    public void xoa(){
        System.out.print("\nNhap ma bac si can xoa: ");
        Scanner input = new Scanner(System.in);
        String ma = input.nextLine();
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(ma.equals(dsbs[i].getMaBS())){
                flag = true;
                for(int j = i; j < n - 1; j++){
                    dsbs[j] = dsbs[j + 1];
                }
                n--;
            }
        } if(!flag){
            System.out.print("\nKhong tim thay ma bac si !!!");
            return;
        }
        
    }
    public void xoa(String ma){
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(ma.equals(dsbs[i].getMaBS())){
                flag = true;
                for(int j = i; j < n - 1; j++){
                    dsbs[j] = dsbs[j + 1];
                }
                n--;
            }
        } if(!flag){
            System.out.print("\nKhong tim thay ma bac si !!!");
            return;
        }
        
    }

// Tim kiem
    public BacSi timKiem(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nNhap ma bac si can tim: ");
        String ma = input.nextLine();
        for(int i = 0; i < n; i++){
            if((ma.equals(dsbs[i].getMaBS())) || (ma.equals(dsbs[i].getTen()))){
                System.out.print("\nThong tin bac si can tim: " );
                return dsbs[i];
            }
        } 
        System.out.print("\nKhong tim thay bac si !!!");
        BacSi none = new BacSi();
        return none;
    }

    public BacSi timKiem(String ma){
        
        for(int i = 0; i < n; i++){
            if((ma.equals(dsbs[i].getMaBS())) || (ma.equals(dsbs[i].getTen()))){
                System.out.print("\nThong tin bac si can tim: ");
                return dsbs[i];
            }
        } 
        System.out.print("\nKhong tim thay bac si !!!");
        BacSi none = new BacSi();
        return none;
    }


    
    public int timMaBacSi(String findedMaBacSi) {
        int index = -1;
        for (int i = 0; i < this.n; i++) {
            if (this.dsbs[i].getMaBS().equals(findedMaBacSi))
                index = i;
        }
        return index;
    }

// Thong ke
    public void menuThongKe(){
        Scanner input = new Scanner(System.in);
        int menu = 0;
        System.out.print("\n-----------------------");
        System.out.print("\n|| >>Thong ke theo<< ||\n||  1) Trinh do.     ||\n||  2) Gioi tinh.    ||\n||  3) Hoat dong.    ||\n||  4) Thoat.        ||");
        System.out.print("\n-----------------------");
        
            System.out.print("\n -Chon phuong thuc thong ke: ");
            menu = input.nextInt();
            input.nextLine();
            switch (menu) {
                case 1:
                    thongKeTrinhDo();
                    break;
                case 2:
                    thongKeGioiTinh();
                    break;
                case 3:
                    thongKeHoatDong();
                    break;
                case 4:
                    break;
                default:
                    System.out.print("\nLua chon khong hop le !!! Vui long nhap lai.");
                    
            }
        
    }

    public void thongKeTrinhDo(){

    }
    
    public void thongKeGioiTinh(){

    }

    public void thongKeHoatDong(){

    }

    public void menuBacSi(){
        int option = 0;
        do{  
            Scanner input = new Scanner(System.in);

            System.out.print("\t\t\t ========  QUAN LY BAC SI  ========");             
            System.out.print("\n\t\t\t || 0) Thoat.                    ||" +
                             "\n\t\t\t || 1) Tao danh sach bac si.     ||" + 
                             "\n\t\t\t || 2) Xem danh sach bac si.     ||" + 
                             "\n\t\t\t || 3) Them bac si.              ||" + 
                             "\n\t\t\t || 4) Xoa bac si.               ||" + 
                             "\n\t\t\t || 5) Sua thong tin bac si.     ||" + 
                             "\n\t\t\t || 6) Tim kiem thong tin bac si.||" + 
                             "\n\t\t\t || 7) Thong ke danh sach bac si.||" );
            System.out.print("\n\t\t\t ==================================");
        
            System.out.print("\n <-> Hay chon chuc nang: ");
            option = input.nextInt();
            while (option < 0 || option > 7){
                System.out.print("\nKhong ton tai lua chon nay !!! Vui long chon lai: ");
                option = input.nextInt();
            } if(option == 0){
                break;
            } if(option == 1){
                nhap();
            } if(option == 2){
                xuat();
            } if(option == 3){
                them();
            } if(option == 4){
                xoa();
            } if(option == 5){
                sua();
            } if(option == 6){
                timKiem();
            } if(option == 7){
                menuThongKe();
            }
        } while(option != 0);
    }
    
}
