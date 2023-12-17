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
    public void docFile(String path){
        Scanner read = null;
        File file = new File(path);
        try{
            read = new Scanner(file);
        } catch(Exception e){
            System.out.println("Loi doc file !");
            return;
        }
        if (!read.hasNextLine()) return;
        soLuongDonThuoc = Integer.parseInt(read.nextLine());
        dsdt = new DONTHUOC[soLuongDonThuoc];
        int i=0;
        while ( read.hasNextLine())
        {
            dsdt[i] = new DONTHUOC();
            String line = read.nextLine();
            String [] arr = line.split(",");
            dsdt[i].setMaDonThuoc(arr[0]);
            dsdt[i].setSoLuongThuocBoc(Integer.parseInt(arr[1]));
            THUOC [] arrThuoc = new THUOC[dsdt[i].getSoLuongThuocBoc()];
            //doc du lieu phan thuoc va truyen vo mang tam
            for (int j=0;j<dsdt[i].getSoLuongThuocBoc();j++){
                arrThuoc[j] = new THUOCCHICH();
                arrThuoc[j].setMaThuoc(arr[(j+1)*4-2]);
                arrThuoc[j].setTenThuoc(arr[4*(j+1)-1]);
                arrThuoc[j].setGiaCa(Double.parseDouble(arr[4*(j+1)]));
                arrThuoc[j].setSoLuong(Integer.parseInt(arr[4*(j+1)+1]));
            }
            dsdt[i].setDst(arrThuoc);
            dsdt[i].setDonGia(Double.parseDouble(arr[arr.length-1]));
            i++;


        }

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
        System.out.println("\u001B[34m=".repeat(20)+"[ DANH SACH DON THUOC ]"+"=".repeat(20)+"\u001B[0m");
        for (int i=0;i<soLuongDonThuoc;i++){
            System.out.format("STT: "+ (i+1)+"\n");
            dsdt[i].xuat();
            System.out.println();
        }
    }
    public void inCuoi(){
        System.out.println("Hoa don moi nhat : ");
        dsdt[dsdt.length-1].xuat();
    }
    public void timKiem(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma can tim kiem: ");
        String ma = input.nextLine();
        for (int i=0;i<soLuongDonThuoc;i++){
            if (ma.equals(dsdt[i].getMaDonThuoc())){
                dsdt[i].xuat();
                return;
            }
        }
        System.out.println("Ma thuoc khong ton tai!");

    }
    public void xoa(){
        Scanner input =  new Scanner(System.in);
        System.out.print("Nhap ma can xoa: ");
        String ma = input.nextLine();
        for (int i=0;i<soLuongDonThuoc;i++){
            if (ma.equals(dsdt[i].getMaDonThuoc()))
            {
                for (int j=i;j<soLuongDonThuoc-1;j++){
                    dsdt[i] = dsdt[i+1];
                    
                }
                System.out.println("Xoa thanh cong!");
                soLuongDonThuoc--;
                return;
            }
            
        }
        System.out.println("Khong tim thay ma nay ! xoa that bai!!!");
        

    }

    public void menu(DANHSACHTHUOC dst){
        System.out.println("TRINH QUAN LY DON THUOC");
        System.out.println("0: Thoat");
        System.out.println("1: Them don thuoc");
        System.out.println("2: Xuat danh sach don thuoc");
        System.out.println("3: tim kiem don thuoc");
        System.out.println("4: xoa don thuoc");
        
        System.out.println("5: In hoa don moi tao");
        
        System.out.print("Lua chon: ");
        Scanner input = new Scanner(System.in);
        int i= input.nextInt();
        do{

        if (i==1){
            them(dst);
        };
        if (i==2){
            xuat();
        };
        if ( i==3){
            timKiem();
        }
        if (i == 4)
        {
            xoa();
        }
        if ( i==5){
            inCuoi();
        }
        System.out.print("Lua chon: ");
        i= input.nextInt();
        
    } while ( i !=0 );
    }
    
    
}
