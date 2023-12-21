package controller;

import model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FornecedorDAO {
    private Connection conexao;

    public FornecedorDAO() throws SQLException {
        this.conexao = ConexaoSQLite.getConexao();
    }

    public void cadastrar(Fornecedor fornecedor) throws SQLException {
        String sql = "INSERT INTO Fornecedor (CNPJ_CPF, nome, Razao_Social) VALUES (?, ?, ?);";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, fornecedor.getCnpjCpf());
            preparedStatement.setString(2, fornecedor.getNome());
            preparedStatement.setString(3, fornecedor.getRazaoSocial());
            preparedStatement.executeUpdate();
        }
    }

    public void atualizar(Fornecedor fornecedor) throws SQLException {
        String sql = "UPDATE Fornecedor SET CNPJ_CPF = ?, nome = ?, Razao_Social = ? WHERE id = ?;";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, fornecedor.getCnpjCpf());
            preparedStatement.setString(2, fornecedor.getNome());
            preparedStatement.setString(3, fornecedor.getRazaoSocial());
            preparedStatement.setInt(4, fornecedor.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM Fornecedor WHERE id = ?;";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public ArrayList<Fornecedor> buscarTodos() throws SQLException {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM Fornecedor;";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setCnpjCpf(rs.getString("CNPJ_CPF"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setRazaoSocial(rs.getString("Razao_Social"));
                fornecedores.add(fornecedor);
            }
        }
        return fornecedores;
    }

}
