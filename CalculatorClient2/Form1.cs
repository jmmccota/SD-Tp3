using System;
using System.Windows.Forms;
using Eneter.Messaging.EndPoints.Rpc;
using Eneter.Messaging.MessagingSystems.MessagingSystemBase;
using Eneter.Messaging.MessagingSystems.TcpMessagingSystem;

namespace CalculatorClient2
{
    public partial class Form1 : Form
    {
        // Declarar a mesma interface como na aplicação Java.

        private IRpcClient<ILeiloeiro> myRpcClient; //declara o Rpc client

        public Form1()
        {
            InitializeComponent();
            tbIP.Text = "127.0.0.1";
            tbPorta.Text = "38445";

            IRpcFactory anRpcFactory = new RpcFactory();
            myRpcClient = anRpcFactory.CreateClient<ILeiloeiro>();

            txtCliente.Enabled = false;
            txtCod.Enabled = false;
            txtValor.Enabled = false;
            SumButton.Enabled = false;
            button1.Enabled = false;
            ResultLabel.Text = "";
            label5.Text = "";

        }


        private void Form1_FormClosed(object sender, FormClosedEventArgs e)
        {
            myRpcClient.DetachDuplexOutputChannel();
        }

        private void SumButton_Click(object sender, EventArgs e)
        {
            int a =Convert.ToInt16(txtCod.Text);
            double b = double.Parse(txtValor.Text);
            String c = txtCliente.Text;

            bool r = myRpcClient.Proxy.MakeGambling(a,b,c); //usa metodo pra fazer lance do servidor,que retorna booleano pta indicar se foi aceito ou nao
            if (r) { 
                ResultLabel.Text = "Sucesso. Lance Aceito"; 
            } else {
                ResultLabel.Text = "Falha. Lance Inválido\n(valor menor ou fim do\ntempo do produto)"; 
            }
            
        }

        private void button1_Click(object sender, EventArgs e)//atualiza o grid com os produtos, pegando os dados atuais para exibir sobrescrevendo os antigos
        {
            label5.Text = ""+DateTime.Now.Millisecond;
            String r = myRpcClient.Proxy.GetArrayProduct();
            String[] vetProd = r.Split(new string[] { "%" }, StringSplitOptions.None); //Os produtos estao concatenados por %
            txtResultado.Text = "";
            for (int i = 0; i < vetProd.Length; i++)
            {

                String[] dadosProd = vetProd[i].Split(new string[] { "#" }, StringSplitOptions.None);//os dados de cada um esta concatenado por #
                if (dadosProd.Length > 2)//so pra caso esteja vazio
                {
                    txtResultado.Text = txtResultado.Text + "\nCodigo:" + dadosProd[0] + "\nNome:" + dadosProd[1] + "\nPreco:" + dadosProd[2] + "\nTermino:" + (double.Parse(dadosProd[3]) * 0.001) + "\nCliente:" + dadosProd[4] +"\n"+dadosProd[5]+ "\n---------------------------------------------";

                }
            }
        }

        private void label7_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            TcpMessagingSystemFactory aMessaging = new TcpMessagingSystemFactory();
            IDuplexOutputChannel anOutputChannel = aMessaging.CreateDuplexOutputChannel("tcp://" + tbIP.Text + ":" + tbPorta.Text + "/");//ip local e porta do servidor
            myRpcClient.AttachDuplexOutputChannel(anOutputChannel);
            txtCliente.Enabled = true;
            txtCod.Enabled = true;
            txtValor.Enabled = true;
            SumButton.Enabled = true;
            button1.Enabled = true;
            button2.Enabled = false;
            tbPorta.Enabled = false;
            tbIP.Enabled = false;
        }
    }
}
