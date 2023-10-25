package com.smk.casier.service;
import com.smk.casier.dao.StokDAO;
import com.smk.casier.model.Stok;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(
        MethodOrderer.OrderAnnotation.class
)

class StokServiceTest {

    /*@Test
    @Order(2)
    void getStokList() {
        List<Stok> stokList=StokService.getInstance().getStokList();
        assertEquals(stokList.size(),2);
    }*/

    @Test
    @Order(4)
    void saveStokToDatabase(){
        StokDAO stokDao = new StokDAO();
        Stok laptop = new Stok();
        laptop.setStokId("001");
        laptop.setNamaBarang("Laptop");
        laptop.setJumlahStok(50);
        laptop.setDateCreated(new Date());
        laptop.setLastModified(new Date());
        stokDao.save(laptop);

        Stok mouse = new Stok();
        mouse.setStokId("001");
        mouse.setNamaBarang("Mouse");
        mouse.setJumlahStok(10);
        mouse.setDateCreated(new Date());
        mouse.setLastModified(new Date());
        stokDao.save(mouse);

        Stok LaptopGaming = new Stok();
        LaptopGaming.setStokId("002");
        LaptopGaming.setNamaBarang("Laptop" + " Gaming");
        LaptopGaming.setJumlahStok(200);
        LaptopGaming.setDateCreated(new Date());
        LaptopGaming.setLastModified(new Date());
        stokDao.save(LaptopGaming);

    }

    @Test
    @Order(5)
    void getDataById(){
        StokDAO stokDao = new StokDAO();
        Optional<Stok> stok1 = stokDao.get(1);
        stok1.ifPresent(new Consumer<Stok>() {
            @Override
            public void accept(Stok stok) {
                assertEquals("Laptop", stok.getNamaBarang());
                assertEquals("LPOO1", stok.getStokId());

            }
        });

        Optional<Stok> stok2 = stokDao.get(2);
        stok2.ifPresent(new Consumer<Stok>() {
            @Override
            public void accept(Stok stok) {
                assertEquals("Mouse", stok.getNamaBarang());
                assertEquals("001", stok.getStokId());

            }
        });
    }

    /*@Test
    @Order(1)
    void addStok() {
        Stok laptop = new Stok();
        laptop.setStokId("001");
        laptop.setNamaBarang("Laptop");
        laptop.setJumlahStok(50);
        StokService.getInstance().addStok(laptop);

        Stok mouse = new Stok();
        mouse.setStokId("001");
        mouse.setNamaBarang("Mouse");
        mouse.setJumlahStok(10);
        StokService.getInstance().addStok(mouse);

        Stok laptopGaming = new Stok();
        laptopGaming.setStokId("002");
        laptopGaming.setNamaBarang("Laptop " + "Gaming");
        laptopGaming.setJumlahStok(200);
        StokService.getInstance().addStok(laptopGaming);


    }*/
}