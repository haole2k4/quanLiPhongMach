
import java.util.Scanner;
public class QUANLYNHAPHANG
{
    private DANHSACHCHITHIETPHIEUNHAP dsctpn = new DANHSACHCHITHIETPHIEUNHAP();
    private DANHSACHPHIEUNHAP dspn = new DANHSACHPHIEUNHAP();
    public void menu()
    {
        dsctpn.docfile();//doc data co san
        dspn.docfile();
        System.out.println("\t\u001B[34m======[ Trinh quan ly nhap hang ]=====\u001B[0m");
        System.out.println("\t -> Nhap 0 de quay tro lai");
        System.out.println("\t -> Nhap 1 de quan ly chi tiet phieu nhap");
        System.out.println("\t -> Nhap 2 de quuan ly phieu nhap");
        int i; 
        do
        {
            System.out.print("\t -> lua chon: ");
            Scanner input = new Scanner(System.in);
            i = input.nextInt();
            switch(i)
            {
                case 0:
                {
                    Menu MainMenu = new Menu();
                    MainMenu.MainMenu();
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
}