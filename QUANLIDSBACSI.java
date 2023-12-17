

// import java.util.Scanner;

public class QUANLIDSBACSI {
    public void trinhQuanLiDSBacSi(){
        try{
            DSBS qlDSBS = new DSBS();
            qlDSBS.docData("data/BacSi.txt");
            // qlDSBS.xuat();
            qlDSBS.Menu();
            qlDSBS.ghiFile("data/BacSi.txt");
        } catch(Exception e){
            System.out.print("\nLoi khong the doc file !!!\n");
        }
    }
}
