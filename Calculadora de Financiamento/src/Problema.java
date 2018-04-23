
public class Problema {
	float valorMontante;
	float valorParcela;
	int nParcelas;
	float juros;
	public void setValores(float valorMontanteArg, float jurosArg){
		valorMontante = valorMontanteArg;
		juros = jurosArg;
	}
	public String[] solve(int numeroMaximoDeParcelas){
		float p;
		String[] lista = new String[numeroMaximoDeParcelas];
		for(int i = 1; i <= numeroMaximoDeParcelas; i++){
			// esta é a notação definida no arquivo matematica: p = (Q * (1+j)^nP) / (1 + ((1+j)^nP - (1+j)) / j)
			p = (valorMontante * (float)Math.pow(1+juros, i)) / (1 + ((float)Math.pow(1+juros, i) - (1+juros)) / juros);
			lista[i-1] = i + "x" + p;
		}
		return lista;
	}
	public String printEvolucao(String itemSelecionado){
		String resposta = "";
		nParcelas = Integer.valueOf(itemSelecionado.substring(0, itemSelecionado.indexOf('x')));
		valorParcela = Float.valueOf(itemSelecionado.substring(1 + itemSelecionado.indexOf('x')));
		float saldo = valorMontante;
		for(int i = 1; i <= nParcelas; i++){
			resposta = resposta + String.format("%.2f", saldo) + " + juros => " + String.format("%.2f", saldo * (1 + juros)) + " pagando uma parcela => " + String.format("%.2f", saldo * (1 + juros) - valorParcela) + "\n";
			saldo = saldo * (1 + juros) - valorParcela;
		}
		return resposta;
	}
}
