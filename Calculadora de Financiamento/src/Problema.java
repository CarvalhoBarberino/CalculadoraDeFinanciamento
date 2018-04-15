
public class Problema {
	float valorMontante;
	float valorParcela;
	int nParcelas;
	float juros;
	public void setValores(float valorMontanteArg, float jurosArg){
		valorMontante = valorMontanteArg;
		juros = jurosArg;
	}
	public float solve(int numeroMaximoDeParcelas){
		float p;
		for(int i = 1; i <= numeroMaximoDeParcelas; i++){
			// esta é a notação definida no arquivo matematica: p = (Q * (1+j)^nP) / (1 + ((1+j)^nP - (1+j)) / j)
			p = (valorMontante * (float)Math.pow(1+juros, i)) / (1 + ((float)Math.pow(1+juros, i) - (1+juros)) / juros);
			System.out.println(i + "    " + p);
		}
		return 0;
	}
}
