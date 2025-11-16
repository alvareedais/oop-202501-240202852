package com.upb.agripos.model;

public class ObatHama extends Produk {
    private final String targetHama; 

    public ObatHama(String kode, String nama, double harga, int stok, String targetHama) {
        super(kode, nama, harga, stok);
        this.targetHama = targetHama;
    }

    @Override
    public String getInfo() {
        return "ObatHama  : " + super.getInfo() + ", Target: " + targetHama;
    }
} 
