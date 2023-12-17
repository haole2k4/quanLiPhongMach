import java.util.Scanner;
import java.time.LocalDate;
public class HOADON {
    
    private String maHoaDon;
    private String maDonThuoc;
    private String maPhieuKhamBenh;
    private double tongTien;
    private LocalDate ngayTao;
    private String hinhThucThanhToan;
    private String NVThuNgan;

    private DANHSACHDONTHUOC donThuoc;
    private DANHSACHPHIEUKHAMBENH phieuKhamBenh;
    private DANHSACHNHANVIEN dsnv;
   

    // 3 ham khoi tao

    public void them(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ma hoa don : ");
        maHoaDon = input.nextLine();
        ngayTao= ngayTao.now();
        System.out.print("Nhap ma don thuoc: ");
        maDonThuoc = input.nextLine();
        donThuoc = new DANHSACHDONTHUOC();
        donThuoc.docFile("D:\\phongMach_THUOC\\quanLiPhongMach\\data\\DONTHUOC.TXT");
        if (donThuoc.timKiemTheoMa(maDonThuoc) == 0 ){
            System.out.println("Ma don thuoc nay khong ton tai! nhap lai !!!!");
            them();
        }
        else {System.out.println("Da xong!");}
        //phieuKhamBenh.docFile("D:\phongMach_THUOC\quanLiPhongMach\data\\PHIEUKHAMBENH.TXT");
        System.out.println("Nhap ma phieu kham benh: ");

        maPhieuKhamBenh = input.nextLine();
       // phieuKhamBenh = new DANHSACHPHIEUKHAMBENH();
       // try{
         //   phieuKhamBenh.docData("D:\\phongMach_THUOC\\quanLiPhongMach\\data\\PHIEUKHAMBENH.TXT");
       // } catch(Exception e){
       //     System.out.println("loi doc file!");
     //       return;
   //     }
//        if (phieuKhamBenh.timKiemTheoMa(maPhieuKhamBenh)==0){
   //         System.out.println("Ma phieu kham benh nay khong ton tai ! nhap lai!!!");
 //           them();
     //   }
       // else {
       //     System.out.println("Da xong!");
        //}
    System.out.print("Hinh thuc thanh toan: (1:CK, 2:Tien mat)???");
    int option = input.nextInt();
    do{
        if (option ==1){
            hinhThucThanhToan ="CHUYEN KHOAN";
        }
        if (option == 2){
            hinhThucThanhToan= "TIEN MAT";
        }

    } while (option !=1 && option !=2);
    input.nextLine();
    System.out.print("Ma nhan vien :"); 
    NVThuNgan = input.nextLine();
    dsnv = new DANHSACHNHANVIEN();
    dsnv.docFile();
    if (dsnv.kiemTraMaNhanVien(NVThuNgan)==0){
        System.out.println("Nhan vien khong ton tai!");
        them();
    }
    else{
        System.out.println("Da xong!");
    }

    
        
    }

    public void xuat(){
        System.out.println("=".repeat(100));
        System.out.format("|| %94s ||\n","HOA DON BAN HANG");
        System.out.format("||       %-47s %39s  ||\n","TIEM THUOC NHOM 10","Ngay tao: "+ngayTao);
        System.out.format("|| %94s ||\n","So / Ma: "+maHoaDon);
        System.out.format("|| %-94s ||\n","Bac si quan ly: "+"CHUA CO");
        System.out.format("|| %-94s ||\n","Ma BSI: "+"CHUA CO");
        System.out.format("|| %-94s ||\n","SDT: "+"CHUA CO");
        System.out.format("|| %-94s ||\n"," ");
        System.out.format("|| %-94s ||\n","Ten benh nhan: "+ "Chua co");
        System.out.format("|| %-94s ||\n","Ma benh nhan: "+"CHUA CO");
        System.out.format("|| %-94s ||\n","Da chi: "+"CHUA CO");
        System.out.format("|| %-94s ||\n"," ");
        System.out.format("|| %-94s ||\n"," ".repeat(38)+"DON THUOC");
        // xuat don thuoc
        donThuoc.xuatDonThuocTheoMa(maDonThuoc);
        System.out.format("|| %53s %-40s ||\n"," ","Cong Tien Kham : "+ "CHUA CO");
        System.out.format("|| %53s %-40s ||\n"," ","Tong Tien Thanh Toan : "+ "CHUA CO");
        System.out.format("|| %53s %-40s ||\n"," ", "Hinh thuc thanh toan : "+ hinhThucThanhToan);
        System.out.format("|| %-94s ||\n"," ");
        System.out.format("||          %-48s %-31s      ||\n","Benh Nhan","Nhan vien Ban Hang");
        System.out.format("||         %-49s %-31s      ||\n","Nguyen Van A",dsnv.timkiem(NVThuNgan).getHo().toUpperCase()+" "+dsnv.timkiem(NVThuNgan).getTen().toUpperCase());
        System.out.println("=".repeat(100));


        
        

    }
    public static void main(String[] args) {
        HOADON hd = new HOADON();
        hd.them();
        hd.xuat();
    }
    
    
}
