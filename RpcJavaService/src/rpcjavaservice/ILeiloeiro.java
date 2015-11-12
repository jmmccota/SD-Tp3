package rpcjavaservice;

import java.util.ArrayList;
import java.util.List;

public interface ILeiloeiro {

    public void AddProduto(String nome, double preco, long termino);//Cadastra produto no array do leiloeiro(usado pelo leiloeiro)

    public boolean MakeGambling(int codProd, double valor, String cliente);//faz lance pra certo produto(usado p�los clientes)

    public List GetArrayProduct();//pega dados de Todos os produtos do leiloeiro concatenados em uma String(usado pelos clientes)
}
