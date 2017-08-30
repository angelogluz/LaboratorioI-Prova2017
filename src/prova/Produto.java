package prova;

/**
 * @author angeloluz
 */
public class Produto {

    private String marca;
    private String nome;
    private int volume;
    private double valorDeCompra;
    private double valorDeVenda;
    private double valorPorLitro;

    //Campos adicionais
    private int quantidade;

    /**
     * Construtor padrão
     */
    public Produto() {
    }

    /**
     * Construtor para Produto
     * Atribui nome, marca e volume ao produto.
     *
     * @param nome   String
     * @param marca  String
     * @param volume int
     */
    public Produto(String nome, String marca, int volume) {
        setNome(nome);
        setMarca(marca);
        setVolume(volume);
    }

    /**
     * Cadastra um novo produto.
     *
     * @param marca         String
     * @param nome          String
     * @param volume        int
     * @param valorDeCompra double
     * @param valorDeVenda  double
     * @param quantidade    int
     */
    public void cadastrar(String marca, String nome, int volume, double valorDeCompra,
                          double valorDeVenda, int quantidade) {
        setMarca(marca);
        setNome(nome);
        setVolume(volume);
        setValorDeCompra(valorDeCompra);
        setValorDeVenda(valorDeVenda);
        setQuantidade(quantidade);
    }

    /**
     * Diminui a quantidade de itens no estoque.
     * Caso o parametro passado seja maior que a quantidade armazenada,
     * Irá retoranar false
     *
     * @param quantidade int
     * @return boolean
     */
    public boolean baixarDoEstoque(int quantidade) {
        if (this.quantidade < quantidade) {
            return false;
        } else {
            this.quantidade -= quantidade;
            return true;
        }

    }

    /**
     * Divisão de valorDeVenda por volume multiplicado por 1000
     * é atribuido ao valorPorLitro
     */
    private void valorPorLitro() {
        valorPorLitro = ((valorDeVenda / volume) * 1000);
    }

    /**
     * Retorna marca do produto
     *
     * @return String
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Atribui uma marca ao produto
     *
     * @param marca String
     */
    private void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Retorna nome do produto
     *
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     * Atribui um nome ao produto
     *
     * @param nome String
     */
    private void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna volume do produto
     *
     * @return int
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Atribui volume ao produto
     *
     * @param volume int
     */
    private void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Retorna valor de compra
     *
     * @return double
     */
    public double getValorDeCompra() {
        return valorDeCompra;
    }

    /**
     * Atribui valor de compra
     *
     * @param valorDeCompra double;
     */
    private void setValorDeCompra(double valorDeCompra) {
        this.valorDeCompra = valorDeCompra;
    }

    /**
     * Retorna valor de venda
     *
     * @return double
     */
    public double getValorDeVenda() {
        return valorDeVenda;
    }

    /**
     * Atribui valor de venda e chama o método valorPorLitro()
     *
     * @param valorDeVenda double
     */
    private void setValorDeVenda(double valorDeVenda) {
        this.valorDeVenda = valorDeVenda;
        valorPorLitro();
    }

    /**
     * Retorna valor por litro
     *
     * @return double
     */
    public double getValorPorLitro() {
        return valorPorLitro;
    }

    /**
     * Retorna quantidade de produtos
     *
     * @return int quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Atribui quantidade de produtos
     *
     * @param quantidade int
     */
    private void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    @Override
    public String toString() {
        //return "Produto{" + "marca=" + marca + ", nome=" + nome + ", volume=" + volume + "ml, valorDeCompra= R$" + valorDeCompra + ", valorDeVenda= R$" + valorDeVenda + ", valorPorLitro= R$" + valorPorLitro + ", quantidade=" + quantidade + '}';
        return String.format("Produto{ marca=%s, nome=%s, volume=%d ml, Valor de Compra= R$ %.2f, Valor de Venda = %.2f, Valor por litro = %.2f, Quantidade em estoque = %d'}'\n", marca, nome, volume, valorDeCompra, valorDeVenda, valorPorLitro, quantidade);
    }

}
