package entity;

import java.util.ArrayList;
import java.util.List;

public class Barang {
    private String nama;

    public List<Barang> getAllPaket() {

        // TODO: Fetch from SQL
        List<Barang> paketList = new ArrayList<Barang>();
        Barang paket = new Barang();

        paketList.add(paket);
        return paketList;
    }
}
