
public class QUANLIDSDonThuoc {
    public void thaoTac() {
        try {
            DANHSACHDONTHUOC ds = new DANHSACHDONTHUOC();
            ds.docData("data\\DONTHUOC.txt");
            ds.xuat();
            ds.menuThaoTac();
            ds.ghiData("data\\HOADON.txt");
        }
        catch(Exception e) {
            // e.printStackTrace();
            System.out.println("Loi khi thuc hien thao tac doc file\n");
        }
    }

}


