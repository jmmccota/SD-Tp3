package rpcjavaservice;
import static java.lang.System.currentTimeMillis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class Leiloeiro implements ILeiloeiro {
	
	public ArrayList<Produto> arrayProdutos=new ArrayList<Produto>();
		
	   public void AddProduto(String nome, double preco,long termino){
		   
		   Produto prodAux=new Produto();
		   int cod=arrayProdutos.size();
		   String dadosProd=cod+"#"+nome+"#"+preco+"#"+termino+"#leilao";
		   prodAux.setProdutoString(dadosProd);
		   arrayProdutos.add(prodAux);
	   }
	   public boolean MakeGambling(int codProd, double valor,String cliente){
		   if(arrayProdutos.get(codProd).getTermino()>currentTimeMillis() && arrayProdutos.get(codProd).getPreco()<valor && codProd>-1 && codProd<arrayProdutos.size()){
			   Produto prodAux=new Produto();
			   prodAux.setProdutoString(arrayProdutos.get(codProd).getStringProduto());
			   prodAux.setPreco(valor);
			   prodAux.setCliente(cliente);
			   arrayProdutos.set(codProd, prodAux);

			   return true;
		   }else return false;
	   }
	   public ArrayList<Produto> GetArrayProduct(){
		   return arrayProdutos;
	   }
	
}
