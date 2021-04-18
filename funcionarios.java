import java.util.Scanner;

class SalarioFuncionario {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Lista_array lista = new Lista_array();

		//double salario;

		System.out.println("Informe o n�mero de empregados que deseja cadastrar: ");
		int num = scanner.nextInt();

		// Adicionando os sal�rios
		for (int i = 0; i < num; i++) {
			System.out.println("Informe o " + (i + 1) + "� sal�rio do empregado:");
			double salario = scanner.nextDouble();
			lista.addLast(salario);
		}

		System.out.println("\n-------------------------------------------------");
		
		// Removendo sal�rio
		System.out.println("\nDeseja remover algum sal�rio? S - sim / N - n�o");
		char x = scanner.next().charAt(0);
		if (x == 'S' || x == 's') {
			System.out.println("\nLista dos sal�rios: " + lista.toString());
			System.out.println("\nQual posi��o do sal�rio que deseja remover? [0 a "+(lista.size()-1)+"]");			
			int posicao = scanner.nextInt();	
			System.out.println("\nO sal�rio removido foi: "+lista.remove(posicao));
		} else if (x == 'N' || x == 'n') {
			System.out.println("\nOk. Nenhum sal�rio foi removido!");
		}

		System.out.println("\n-------------------------------------------------");
				
		// Alterando sal�rio
		System.out.println("\n\nDeseja alterar algum sal�rio? S - sim / N - n�o");
		char y = scanner.next().charAt(0);
		if (y == 'S' || y == 's') {
			System.out.println("\nLista dos sal�rios: " + lista.toString());
			System.out.println("\nQual posi��o do sal�rio que deseja alterar? [0 a "+(lista.size()-1)+"]");
			int posicao = scanner.nextInt();
			while (!(posicao >= 0 && posicao < (lista.size()))) {
				System.out.println("Informe uma posi��o v�lida:");
				posicao = scanner.nextInt();	
			}
			System.out.println("\nQual o novo valor que deseja inserir?");
			double novoValor = scanner.nextDouble();
			lista.set(posicao, novoValor);
		} else if (y == 'N' || y == 'n') {
			System.out.println("\nOk. Nenhum sal�rio foi alterado!");
		}

		// Fechando a entrada das informa��es
		scanner.close();

		// Imprimindo as informa��es
		System.out.println("\n\n=========== Relat�rio das Informa��es ===========");
		System.out.printf("M�dia dos sal�rios: R$%.2f\n", lista.media());
		System.out.println("Quantidade de sal�rio(s) acima da m�dia: " + lista.quantSalariosAcimaMedia());
		System.out.printf("Primeiro sal�rio da lista: R$%.2f\n", lista.getFirst());
		System.out.printf("Ultimo sal�rio da lista: R$%.2f\n", lista.getLast());
		System.out.println("Lista dos sal�rios: " + lista.toString());
		System.out.println("=================================================");
	}

}


class Lista_array {
	Scanner scanner = new Scanner(System.in);
	private double[] vet;
	private int max;
	private int livre;

	public Lista_array() { // construtor vazio
		max = 1000;
		vet = new double[max];
		livre = 0; // a posi��o livre m�xima � 0
	}

	// M�todo para adicionar elementos na lista
	public void addLast(double elemento) {
		if (livre < max) {
			vet[livre] = elemento;
			livre++;
		} else {
			System.out.println("Lista cheia!");
		}
	}

	// M�todo que retorna o �ndice
	public double get(int i) {
		if ((i >= 0) && (i < size())) {
			return vet[i];
		} else {
			System.out.println("�ndice do vetor n�o encontrado!");
		}
		return 0;
	}

	// M�todo que retorna o tamanho da lista
	public int size() {
		return this.livre;
	}

	// M�todo para pegar o �ltimo elemento da lista
	public double getLast() {
		if (size() != 0) {
			return vet[livre - 1]; // pega a ultima posi��o
		} else {
			System.out.println("Lista vazia!");
			return 0;
		}
	}

	// M�todo para pegar o primeiro elemento da lista
	public double getFirst() {
		if (size() != 0) {
			return vet[0]; // pega o primeiro da lista
		} else {
			System.out.println("Lista vazia!");
			return 0;
		}
	}

	// M�todo remover
	public double remove(int posicao) {
		while (!(posicao >= 0 && posicao < size())) { // Enquanto acessar uma posi��o que n�o existe...
			System.out.println("Informe uma posi��o v�lida:");
			posicao = scanner.nextInt();
		}
		double removido = 0;
		removido = vet[posicao];
		for (int i = posicao; i < this.livre - 1; i++) {
			this.vet[i] = this.vet[i + 1];
		}
		livre--;
		return removido;
	}

	// M�todo SET
	public void set(int posicao, double novoValor) {
		double valor;
		valor = vet[posicao];
		vet[posicao] = novoValor;

		System.out.println("\nAntigo valor: "+valor+"\nNovo valor: "+novoValor);
	}


	// M�todo toString
	public String toString() {
		StringBuffer sf = new StringBuffer();
		sf.append("[ ");
		for (int i = 0; i < size(); i++) {
			sf.append(vet[i] + " ");
		}
		sf.append("]");

		return sf.toString();
	}

	//M�todo M�dia
	public double media() {
		double soma = 0;
		for (int i = 0; i < size(); i++) {
			soma += get(i);
		}

		return soma / size();
	}

	//M�todo sal�rio acima da m�dia
	public int quantSalariosAcimaMedia() {
	// Verificando a quantidade de sal�rios que s�o acima da m�dia
		int salariosAcimaMedia = 0;
		for (int i = 0; i < size(); i++) {
			if (get(i) > media()) {
				salariosAcimaMedia++;
			}
		}
		return salariosAcimaMedia;
	}
}
