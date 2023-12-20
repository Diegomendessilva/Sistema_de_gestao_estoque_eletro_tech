package model;

public class FornecedorProduto {
    private int id;
    private int idProduto;
    private int idFornecedor;
    private String nomeProduto;
    private String nomeFornecedor;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public FornecedorProduto(int idProduto, int idFornecedor) {
        this.idProduto = idProduto;
        this.idFornecedor = idFornecedor;
    }

    public FornecedorProduto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    @Override
    public String toString() {
        return String.format("| %-5d | %-10s | %-30s | %-15s | %-30s |", id, idProduto,nomeProduto, idFornecedor,nomeFornecedor);

    }
}
