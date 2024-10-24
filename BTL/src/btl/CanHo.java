package btl;

public class CanHo {
    private String maCanHo;
    private String chuHo;
    private int soNguoi;

    public CanHo(String maCanHo, String chuHo, int soNguoi) {
        this.maCanHo = maCanHo;
        this.chuHo = chuHo;
        this.soNguoi = soNguoi;
    }

    public String getMaCanHo() { return maCanHo; }
    public String getChuHo() { return chuHo; }
    public int getSoNguoi() { return soNguoi; }

    public void setMaCanHo(String maCanHo) { this.maCanHo = maCanHo; }
    public void setChuHo(String chuHo) { this.chuHo = chuHo; }
    public void setSoNguoi(int soNguoi) { this.soNguoi = soNguoi; }
}
