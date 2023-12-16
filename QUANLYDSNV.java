
import java.util.Scanner;
public class QUANLYDSNV {
    DANHSACHNHANVIEN qldsnv = new DANHSACHNHANVIEN();
    Scanner input = new Scanner(System.in);
    public void menu()
    
    {
    qldsnv.docFile();
    System.out.println("[==============  QUAN LY NHAN VIEN ============]");
    System.out.println("\n");
    System.out.println(" 0. nhap danh sach nhan vien");    
    System.out.println(" 1. Xem danh sach nhan vien");
    System.out.println(" 2. Them nhan vien");
    System.out.println(" 3. Xoa nhan vien");
    System.out.println(" 4. Sua thong tin nhan vien");
    System.out.println(" 5. Tim kiem nhan vien");
    System.out.println(" 6. Thong ke hoat dong cua nhan vien");
    System.out.println(" 7. Thoat");
        System.out.println("\n");
    int k=0;
    while (k!=7)
    {
    System.out.print("Lua chon: ");
    k = input.nextInt();
    switch(k)
        {
            case 0:
                qldsnv.nhap();
                break;
            case 1: 
            {
                qldsnv.xuat();
            } break;
            case 2: 
            {
                qldsnv.them();
            } break;
            case 3: 
            {
                qldsnv.xoa();
            } break;
            case 4: 
            {
                qldsnv.sua();
            } break;
            case 5:
            {
                qldsnv.timkiem().xuat();
                System.out.println("\n");
            } break;
            case 6:
            {
                qldsnv.thongKeHoatDong();
            } break;
            case 7:
            {
                break;
            }
            }
        }
    }

    public static void main(String[] args) {
        QUANLYDSNV test = new QUANLYDSNV();
        test.menu();
    }
}
  
