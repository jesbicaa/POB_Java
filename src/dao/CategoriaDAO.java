package dao;

import beans.Categoria;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CategoriaDAO {

    private Connection conn;

    public CategoriaDAO() {
        this.conn = Conexao.getConexao();
    }

    public void inserir(Categoria c) throws Exception{
        String sql = "INSERT INTO categoria(nomeCategoria) VALUES(?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, c.getNomecategoria());
            stmt.execute();
        } catch (Exception e) {
            throw new Exception("Erro ao inserir categoria: " + e.getMessage());
        }
    }
    
    public Categoria getCategoria(int id) throws Exception{
        String sql = "SELECT * FROM categoria WHERE id = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.first();
            
            Categoria c = new Categoria();
            c.setId(id);
            c.setNomecategoria(rs.getString("nomeCategoria"));
            return c;
        } catch (Exception e) {
            throw new Exception("Categoria não encontrada");
        }
    }
    
    public void update(Categoria c) throws Exception{
        String sql = "UPDATE categoria SET nomeCategoria = ? WHERE id = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, c.getNomecategoria());
            stmt.setInt(2, c.getId());
            stmt.execute();
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar categoria: " + e.getMessage());
        }
    }
}
