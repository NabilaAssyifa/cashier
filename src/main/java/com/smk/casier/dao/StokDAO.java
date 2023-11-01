package com.smk.casier.dao;
import com.smk.casier.model.Barang;
import com.smk.casier.model.Stok;
import java.sql.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class StokDAO implements Dao<Stok, Integer> {
    private final Optional<Connection>connection;

    public StokDAO() {
        connection = JdbcConnection.getConnection();
    }

    public Optional<Stok> get(int id) {
        return connection.flatMap(conn ->{
            Optional <Stok> stok = Optional.empty();
            String sql = "SELECT * from stok where stok_id = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    int stokId = rs.getInt("stok_id");
                    String namaBarang = rs.getString("nama_barang");
                    int jumlahStok = rs.getInt("jumlah_stok");
                    Stok stokResult = new Stok();
                    stokResult.setStokId(String.valueOf(stokId));
                    stokResult.setNamaBarang(namaBarang);
                    stokResult.setJumlahStok(jumlahStok);
                    stok = Optional.of(stokResult);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return stok;
        });

}
    @Override
    public Collection<Stok> getAll() {
        return null;
    }

    @Override
    public Optional<Integer> save(Stok stok) {
        Stok nonNullStok = Objects.requireNonNull(stok);
        String sql = "INSERT INTO Stok"+"(stok_id, nama_barang, jumlah_stok, created_by, updated_by, date_created, last_modified)"+
                "VALUES(?,?,?,?,?,?,?)";
        return connection.flatMap(conn ->{
            Optional<Integer> generatedId = Optional.empty();
            try {
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1,stok.getStokId());
                ps.setString(2,stok.getNamaBarang());
                ps.setInt(3,stok.getJumlahStok());
                ps.setString(4,stok.getCreatedBy());
                ps.setString(5,stok.getUpdatedBy());
                ps.setDate(6,new Date(stok.getDateCreated().getTime()));
                ps.setDate(7,new Date(stok.getLastModified().getTime()));

                int numberOfInsertedRows = ps.executeUpdate();
                if (numberOfInsertedRows > 0){
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()){
                        generatedId = Optional.of(rs.getInt(1));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return generatedId;
        });
    }

    @Override
    public void update(Stok stok) {

    }

    @Override
    public void delete(Stok stok) {

    }

    @Override
    public Collection<Stok> search(String keyword) {
        return null;
    }
}




