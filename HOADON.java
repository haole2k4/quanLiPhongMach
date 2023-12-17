import java.util.Scanner;
public class HOADON {
    private String maHoaDon;
    private String maDonThuoc;
    private String maPhieuKhamBenh;
    private double tongTien;

    private DANHSACHDONTHUOC donThuoc;
    private DANHSACHPHIEUKHAMBENH phieuKhamBenh;
   

    // 3 ham khoi tao

    public void them(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ma hoa don : ");
        maHoaDon = input.nextLine();
        System.out.print("Nhap ma don thuoc: ");
        maDonThuoc = input.nextLine();
        donThuoc.docFile("D:\\phongMach_THUOC\\quanLiPhongMach\\data\\DONTHUOC.TXT");
        if (donThuoc.timKiemTheoMa(maDonThuoc) == 0 ){
            System.out.println("Ma don thuoc nay khong ton tai! nhap lai !!!!");
            them();
        }
        else {System.out.println("Da xong!");}
        //phieuKhamBenh.docFile("D:\phongMach_THUOC\quanLiPhongMach\data\\PHIEUKHAMBENH.TXT");
        System.out.println("Nhap ma phieu kham benh: ");
        maPhieuKhamBenh = input.nextLine();
        try{
            phieuKhamBenh.docData("D:\\phongMach_THUOC\\quanLiPhongMach\\data\\PHIEUKHAMBENH.TXT");
        } catch(Exception e){
            System.out.println("loi doc file!");
            return;
        }
//        if (phieuKhamBenh.timKiemTheoMa(maPhieuKhamBenh)==0){
   //         System.out.println("Ma phieu kham benh nay khong ton tai ! nhap lai!!!");
 //           them();
     //   }
       // else {
       //     System.out.println("Da xong!");
        //}
        

    }

    public void xuat(){
        System.out.println("=".repeat(100));
        System.out.format("|| %-94s ||", " ".repeat(10)+"TIEM THUOC NHOM 10"+" ".repeat(50)+"HOA DON BAN HANG");


    }
    public static void main(String[] args) {
        HOADON hd = new HOADON();
        hd.them();
        hd.xuat();
    }
    
    
}
