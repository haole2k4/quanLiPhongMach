

import java.util.Scanner;

public class QuanLyDSBS {
//Thuoc tinh:
    private DSBS dsbs;

//Phuong thuoc: 
    public void Menu(){
        System.out.print("----------------");
        dsbs = new DSBS();
        int menu = 0;
        Scanner input = new Scanner(System.in);
        while(menu != 8){
            System.out.print("\n1) Nhap DSBS." + "\n2) Xem DSBS." + "\n3) Them BS." + "\n4) Xoa BS." + "\n5) Sua thong tin BS." + "\n6) Tim kiem." + "\n7) Thong ke." + "\n8) Ket thuc.");
            System.out.print("\nHay chon chuc nang: ");
            menu = input.nextInt();
            input.nextLine();
            switch(menu){
                case 1:
                    dsbs.Nhap();
                    break;
                case 2:
                    dsbs.Xuat();
                    break;
                case 3:
                    dsbs.Them();
                    break;
                case 4:
                    System.out.print("\nNhap ma bac si muon xoa: ");
                    String ma1 = input.nextLine();
                    dsbs.Xoa(ma1);
                    break;
                case 5:
                    dsbs.SuaTT();
                    break;
                case 6:
                    System.out.print("\nNhap ma sinh vien can tim: ");
                    String ma2 = input.nextLine();
                    System.out.print(dsbs.Timkiem(ma2));
                    break;
                //case 7:
                //dsbs.ThongKe();
                //break;
            }
        }
    }
}
