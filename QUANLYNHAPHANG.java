
import java.util.Scanner;
public class QUANLYNHAPHANG
{
    private DANHSACHCHITHIETPHIEUNHAP dsctpn = new DANHSACHCHITHIETPHIEUNHAP();
    private DANHSACHPHIEUNHAP dspn = new DANHSACHPHIEUNHAP();
    private DANHSACHTHUOC dst;
    private Main main;
    public void menu()
    {
        dsctpn.docfile();//doc data co san
        dspn.docfile();
        System.out.println("    ==> Trinh quan ly nhap hang: ");
        System.out.println("    0: BACK");
        System.out.println("    1: Quan ly chi tiet phieu nhap");
        System.out.println("    2: Quan ly phieu nhap");
        int i; 
        do
        {
            System.out.print("    lua chon: ");
            Scanner input = new Scanner(System.in);
            i = input.nextInt();
            switch(i)
            {
                case 0:
                {
                    QUANLIDSTHUOC trinhQuanLi = new QUANLIDSTHUOC();
        
                     trinhQuanLi.menu();
                }
                case 1:
                { 
                
                    dsctpn.menu(); 
                    
                }break;
                case 2: dspn.menu(); break;
            }


        }
        while (i!=0);

    
    
    }
    public static void main(String[] args) {
        QUANLYNHAPHANG ql = new QUANLYNHAPHANG();
        ql.menu();
    }
}