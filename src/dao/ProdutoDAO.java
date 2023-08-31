package dao;

import beans.Produto;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProdutoDAO {
    private Connection conn;

    public ProdutoDAO() {
        this.conn = Conexao.getConexao();
    }

    public void inserir(Produto p) throws Exception{
        String sql = "INSERT INTO produto(nomeproduto, valor, categoriaid) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, p.getNomeproduto());
            stmt.setDouble(2, p.getValor());
            stmt.setInt(3, p.getCategoriaid().getId());
            stmt.execute();
        } catch (Exception e) {
            throw new Exception("Erro ao inserir produto: " + e.getMessage());
        }
    }
}
