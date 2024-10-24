/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl;

/**
 *
 * @author gearz
 */
public class PhiDichVu {
    private String loaiDichVu;
    private double gia;

    public PhiDichVu(String loaiDichVu, double gia) {
        this.loaiDichVu = loaiDichVu;
        this.gia = gia;
    }

    public String getLoaiDichVu() { return loaiDichVu; }
    public double getGia() { return gia; }

    public void setLoaiDichVu(String loaiDichVu) { this.loaiDichVu = loaiDichVu; }
    public void setGia(double gia) { this.gia = gia; }
}

