package controller;

import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProdutoDAO {
    Connection conn;

    public ProdutoDAO() throws SQLException {
        this.conn = ConexaoSQLite.getConexao();
    }

    public ArrayList<Produto> buscarTodos() throws SQLException {

        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produto;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Produto produto = new Produto();
            produto.setId(resultSet.getInt("Id"));
            produto.setNome(resultSet.getString("Nome"));
            produto.setDescricao(resultSet.getString("Descricao"));
            produto.setCategoria(resultSet.getString("Categoria"));

            produtos.add(produto);

        }

        return produtos;
    }

    public Produto buscarPorId(int id) throws SQLException {

        String sql = "SELECT * FROM Produto WHERE Id = ?;";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        Produto produto = new Produto();
        produto.setId(resultSet.getInt("Id"));
        produto.setNome(resultSet.getString("Nome"));
        produto.setDescricao(resultSet.getString("Descricao"));
        produto.setCategoria(resultSet.getString("Categoria"));

        return produto;
    }


    public void cadastrar() throws SQLException {
        String sql = "INSERT INTO Produto VALUES(null, ?,?,?);";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o nome do produto: ");
        String nome = sc.nextLine();
        System.out.print("Digite a descrição do produto: ");
        String descricao = sc.nextLine();
        System.out.print("Informe a categoria do produto: ");
        String categoria = sc.nextLine();
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, descricao);
        preparedStatement.setString(3, categoria);
        preparedStatement.executeUpdate();
    }

    public void atualizar(int id, String coluna, String dado) throws SQLException {
        String sql = "UPDATE Produto SET " + coluna + " = '" + dado + "' WHERE Id = " + id + ";";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
//        preparedStatement.setString(1,coluna);
//        preparedStatement.setString(2,dado);
//        preparedStatement.setInt(3,id);
        preparedStatement.executeUpdate();

    }

}
