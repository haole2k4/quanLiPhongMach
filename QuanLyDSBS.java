

import java.util.Scanner;

public class QuanLyDSBS {
//Thuoc tinh:
    private DSBS qldsbs;

//Phuong thuoc: 
    public void Menu(){
        
        System.out.print("\t\t\t ========  QUAN LY BAC SI  ========");
        qldsbs = new DSBS();
        qldsbs.docData();
        int menu = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("\n\t\t\t || 1) Nhap danh sach bac si.    ||" + 
                         "\n\t\t\t || 2) Xem danh sach bac si.     ||" + 
                         "\n\t\t\t || 3) Them bac si.              ||" + 
                         "\n\t\t\t || 4) Xoa bac si.               ||" + 
                         "\n\t\t\t || 5) Sua thong tin bac si.     ||" + 
                         "\n\t\t\t || 6) Tim kiem thong tin bac si.||" + 
                         "\n\t\t\t || 7) Thong ke danh sach bac si.||" + 
                         "\n\t\t\t || 8) Ket thuc.                 ||");
        System.out.print("\n\t\t\t ==================================");
        while(menu != 8){
            System.out.print("\n -Hay chon chuc nang: ");
            menu = input.nextInt();
            input.nextLine();
            switch(menu){
                case 1:
                    qldsbs.nhap();
                    break;
                case 2:
                    qldsbs.xuat();
                    break;
                case 3:
                    qldsbs.them();
                    break;
                case 4:
                    qldsbs.xoa();
                    break;
                case 5:
                    qldsbs.sua();
                    break;
                case 6:
                    qldsbs.timKiem();
                    break;
                case 7:
                    qldsbs.menuThongKe();
                    break;
                case 8:
                    break;
                default:
                    System.out.print("\nLua chon khong dung !!! Vui long chon lai.");
            }
        }
    }
}
