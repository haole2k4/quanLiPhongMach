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
                arrThuoc[j].setMaThuoc(arr[(j+1)*2]);
                arrThuoc[j].setTenThuoc(arr[2*(j+1)+1]);
                arrThuoc[j].setGiaCa(Double.parseDouble(arr[2*(j+1)+2]));
                arrThuoc[j].setSoLuong(Integer.parseInt(arr[2*(j+1)+3]));
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
            if (dsdt[0].them(dst) == 1)
            {
ghiFile("D:\\phongMach_THUOC\\quanLiPhongMach\\data\\DONTHUOC.TXT");
            };
        }
        else{
            this.dsdt = Arrays.copyOf(this.dsdt, soLuongDonThuoc);
            dsdt[soLuongDonThuoc-1] = new DONTHUOC();
            if (dsdt[soLuongDonThuoc-1].them(dst) ==1){
                        
ghiFile("D:\\phongMach_THUOC\\quanLiPhongMach\\data\\DONTHUOC.TXT");
            }
        
    
    }
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
        int i= input.nextInt();
        do{

        if (i==1){
            them(dst);
        };
        if (i==2){
            xuat();
        };
        System.out.print("Lua chon: ");
        i= input.nextInt();
        
    } while ( i !=0 );
    }
    
    
}
