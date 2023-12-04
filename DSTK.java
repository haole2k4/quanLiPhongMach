import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class DSTK {
// thuoc tinh
    private TaiKhoan [] dstk = new TaiKhoan[1];
    private int soLuongTK;
    Scanner input = new Scanner(System.in);

//phuong thuc
    DSTK(){
        soLuongTK = 0;
        dstk [0] = new TaiKhoan();
        dstk [0] = null;
    }

    DSTK(int sltk, TaiKhoan [] ltk){
        soLuongTK = sltk;
        dstk = ltk;
    }

    DSTK(DSTK lTK){
        soLuongTK = lTK.soLuongTK;
        dstk = lTK.dstk;
    }
// File luu
    public String fileTK(){

        return "D:\\phongMach_THUOC\\quanLiPhongMach\\TaiKhoan.txt";
    }
// Ham lay dong de ghi vao file
    public String getLine(int i){

        return (dstk[i].getUSer() + "," +dstk[i].getPassWord());
    }

// Ham xoa data cua file
    public void xoaDataFile(String filePath){

        try {
            FileWriter writer = new FileWriter(filePath, false);
            writer.write("");

            writer.close();
        } catch (IOException e) {
            System.out.println("loi");
        }
    }

// Ham ghi file
    public void ghiLine(String fileName,String s){

        // xoa data trong file tr
        File outFile = new File(fileName);
        PrintWriter write=null;
            try {
                write= new PrintWriter(new FileWriter(outFile,true));
                }
               catch (Exception e){ System.out.println("Khong the tao tap tin ket qua");
                    return;
               }
               write.print(s);
               write.print("\n");
               write.close();
    }

    void ghiFile(){

        xoaDataFile(fileTK());
        ghiLine(fileTK(), String.valueOf(soLuongTK));
        for (int i=0; i < soLuongTK; i++){

            ghiLine(fileTK(), getLine(i));
        }
    }

    void nhap(){
        //xoa data trong file truoc khi ghi lai file moi
        xoaDataFile(fileTK());
        Scanner input = new Scanner(System.in);
        System.out.print(" - So luong tai khoan: "); 
        soLuongTK = input.nextInt();
        dstk = new TaiKhoan[soLuongTK];
        for (int i=0; i < soLuongTK; i++){

            dstk[i] = new TaiKhoan();
            System.out.print("Tai khoan ["+(i+1)+"] :\n");
            dstk[i].nhap();
            System.out.print("\n");
        }
        //ghi lai vao file
        ghiFile();
    }

    void docData(){

        File inFile = new File(fileTK());
        Scanner read = null;
        try
        {
            read = new Scanner(inFile);
        }
        catch (Exception e)
        {
            System.out.print("khong the mo file BenhNhan.txt");
            return ;
        }
        soLuongTK = Integer.parseInt(read.nextLine());
        dstk = new TaiKhoan[soLuongTK];
        for (int i=0; i < soLuongTK; i++){

            dstk[i] = new TaiKhoan();
            String line = read.nextLine();
            String [] str = line.split(",");
            dstk[i].setUSer(str[0]);
            dstk[i].setPassWord(str[1]);           
        }
        read.close();
    }

    void xuat(){

        docData();
        System.out.println("Danh sach cac tai khoan: ");
        for (int i=0; i < soLuongTK; i++){
            
            dstk[i].xuat();
            System.out.print("\n");
        }
    }

    void them(){

        dstk = Arrays.copyOf(dstk, soLuongTK + 1);
        dstk[soLuongTK] = new TaiKhoan();
        dstk[soLuongTK].nhap();
        soLuongTK++;
        ghiFile();
    }

    
}
