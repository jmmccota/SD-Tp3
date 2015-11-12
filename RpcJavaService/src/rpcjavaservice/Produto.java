package rpcjavaservice;


public class Produto {
	private int cod;
	private String nome;
	private double preco;
	private long termino;
	private String cliente="leilao";
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public long getTermino() {
		return termino;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public void setTermino(long termino) {
		this.termino = termino;
	}
	public String getStringProduto(){
            String str=cod+"#"+nome+"#"+preco+"#"+termino+"#"+cliente;
            return str;
        }
    public void setProdutoString(String str){
            String[] vetStr=str.split("#");
            cod=Integer.parseInt(vetStr[0]);
            nome=vetStr[1];
            preco=Double.parseDouble(vetStr[2]);
            termino=Long.parseLong(vetStr[3]);
            cliente=vetStr[4];
    }
}
