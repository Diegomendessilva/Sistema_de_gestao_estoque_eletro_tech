package controller;

import model.FornecedorProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FornecedorProdutoDAO {
    private Connection conexao;

    public FornecedorProdutoDAO() throws SQLException {
        this.conexao = ConexaoSQLite.getConexao();
    }

    public void inserir(FornecedorProduto fornecedorProduto) throws SQLException {
        String sql = "INSERT INTO FornecedorProduto (idProduto, idFornecedor) VALUES (?, ?);";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, fornecedorProduto.getIdProduto());
            preparedStatement.setInt(2, fornecedorProduto.getIdFornecedor());
            preparedStatement.executeUpdate();
        }
    }

    public void atualizar(FornecedorProduto fornecedorProduto) throws SQLException {
        String sql = "UPDATE FornecedorProduto SET idProduto = ?, idFornecedor = ? WHERE id = ?;";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, fornecedorProduto.getIdProduto());
            preparedStatement.setInt(2, fornecedorProduto.getIdFornecedor());
            preparedStatement.setInt(3, fornecedorProduto.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM FornecedorProduto WHERE id = ?;";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public ArrayList<FornecedorProduto> buscarTodos() throws SQLException {
        ArrayList<FornecedorProduto> fornecedorProdutos = new ArrayList<>();
        String sql = "SELECT \n" +
                "    fp.id AS \"ID\",\n" +
                "    fp.fk_id_produto AS \"ID PRODUTO\",\n" +
                "    p.nome AS \"PRODUTO\",\n" +
                "    fp.FK_Id_Fornecedor AS \"ID FORNECEDOR\",\n" +
                "    f.Nome AS \"FORNECEDOR\"\n" +
                "FROM \n" +
                "    Fornecedor_Produto fp\n" +
                "INNER JOIN \n" +
                "    Fornecedor f ON f.id = fp.FK_id_Fornecedor\n" +
                "INNER JOIN \n" +
                "    Produto p ON p.id = fp.FK_id_Produto;\n";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                FornecedorProduto fornecedorProduto = new FornecedorProduto();
                fornecedorProduto.setId(rs.getInt("ID"));
                fornecedorProduto.setIdProduto(rs.getInt("ID PRODUTO"));
                fornecedorProduto.setNomeProduto(rs.getString("PRODUTO"));
                fornecedorProduto.setIdFornecedor(rs.getInt("ID FORNECEDOR"));
                fornecedorProduto.setNomeFornecedor(rs.getString("FORNECEDOR"));
                fornecedorProdutos.add(fornecedorProduto);
            }
        }
        return fornecedorProdutos;
    }

    public FornecedorProduto buscarPorId(int id) throws SQLException {
        String sql = "SELECT \n" +
                "    fp.id AS \"ID\",\n" +
                "    fp.fk_id_produto AS \"ID PRODUTO\",\n" +
                "    p.nome AS \"PRODUTO\",\n" +
                "    fp.FK_Id_Fornecedor AS \"ID FORNECEDOR\",\n" +
                "    f.Nome AS \"FORNECEDOR\"\n" +
                "FROM \n" +
                "    Fornecedor_Produto fp\n" +
                "INNER JOIN \n" +
                "    Fornecedor f ON f.id = fp.FK_id_Fornecedor\n" +
                "INNER JOIN \n" +
                "    Produto p ON p.id = fp.FK_id_Produto\n" +
                "WHERE fp.id = ?;";

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    FornecedorProduto fornecedorProduto = new FornecedorProduto();
                    fornecedorProduto.setId(rs.getInt("ID"));
                    fornecedorProduto.setIdProduto(rs.getInt("ID PRODUTO"));
                    fornecedorProduto.setNomeProduto(rs.getString("PRODUTO"));
                    fornecedorProduto.setIdFornecedor(rs.getInt("ID FORNECEDOR"));
                    fornecedorProduto.setNomeFornecedor(rs.getString("FORNECEDOR"));
                    return fornecedorProduto;
                }
            }
        }
        return null; // Retorna null se não encontrar um registro com o ID especificado
    }



}
