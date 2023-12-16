import java.util.Arrays;
import java.io.*;
import java.util.Scanner;
public class DANHSACHDONTHUOC {
    private DONTHUOC [] dsdt;
    private int soLuongDonThuoc;

    //3 ham khoi tao


    //ham ghi file
    public void ghiFile(String path)
    {
        File file = new File(path);
        PrintWriter write = null;
        try {
            write = new PrintWriter(file);
        } catch (Exception e){
            System.out.println("Loi ghi file ");
            return;
        }
        write.println(soLuongDonThuoc);
        for (int i=0;i<soLuongDonThuoc;i++){
            write.println(dsdt[i].getThongTin());
        }
        write.close();
    }

    public void them(DANHSACHTHUOC dst){
        soLuongDonThuoc++;
        if (soLuongDonThuoc == 1){
            dsdt = new DONTHUOC[1];
            dsdt[0] = new DONTHUOC();
            dsdt[0].them(dst);
        }
        else{
            this.dsdt = Arrays.copyOf(this.dsdt, soLuongDonThuoc);
            dsdt[soLuongDonThuoc-1] = new DONTHUOC();
            dsdt[soLuongDonThuoc-1].them(dst);
        }
        ghiFile("D:\\phongMach_THUOC\\quanLiPhongMach\\data\\DONTHUOC.TXT");
    }

    public void xuat(){
        for (int i=0;i<soLuongDonThuoc;i++){
            dsdt[i].xuat();
        }
    }

    public void menu(DANHSACHTHUOC dst){
        System.out.println("TRINH QUAN LY DON THUOC");
        System.out.println("0: Thoat");
        System.out.println("1: Them don thuoc");
        System.out.println("2: Xuat danh sach don thuoc");
        System.out.print("Lua chon: "); 
        Scanner input = new Scanner(System.in);
        int i=1;
        while (i!=0){
        i = input.nextInt();
        if (i==1){
            them(dst);
        };
        if (i==2){
            xuat();
        };
    }
    }
    
    
}
