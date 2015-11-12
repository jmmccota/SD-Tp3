using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CalculatorClient2
{

    public interface ILeiloeiro
    {
        void AddProduto(String nome, double preco, long termino);
        bool MakeGambling(int idProduto, double valor, String cliente);
        String GetArrayProduct();
    }
}
