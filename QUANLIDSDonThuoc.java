
public class QUANLIDSDonThuoc {
    public void thaoTac() {
        try {
            DANHSACHDONTHUOC ds = new DANHSACHDONTHUOC();
            ds.docFile("data\\DONTHUOC.txt");
            ds.xuat();
            ds.thaoTac();
            ds.ghiFile("data\\HOADON.txt");
        }
        catch(Exception e) {
            // e.printStackTrace();
            System.out.println("Loi khi thuc hien thao tac doc file\n");
        }
    }

}


