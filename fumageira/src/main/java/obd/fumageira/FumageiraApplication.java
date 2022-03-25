package obd.fumageira;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FumageiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(FumageiraApplication.class, args);
		String url = "", metodo = "", output = "", line = "", aux = "";
		int escolha;
		HttpURLConnection conn;
		BufferedReader br;
		Scanner s = new Scanner(System.in);

		while (true) {

			System.out.println("Que quer?");
			System.out.println("1 para pesquisar");
			System.out.println("2 para inserir");
			System.out.println("3 para remover");
			System.out.println("4 para atualizar");
			System.out.println("5 para consultas");
			System.out.println("Outro para sair");
			escolha = s.nextInt();

			if (escolha == 1)
				metodo = "GET";
			else if (escolha == 2)
				metodo = "POST";
			else if (escolha == 3)
				metodo = "DELETE";
			else if (escolha == 4)
				metodo = "PUT";
			else if (escolha == 5)
				metodo = "GET";
			else
				break;

			if (escolha != 5) {
				System.out.println("Que entidade?");
				System.out.println("1 para funcionario");
				System.out.println("2 para produtor");
				System.out.println("3 para safra");
				System.out.println("4 para classe");
				System.out.println("5 para departamento");
				System.out.println("6 para fardo");
				System.out.println("7 para pedido");
				System.out.println("8 para produto pedido");
				System.out.println("9 para localidade");
				System.out.println("10 para produto");
				escolha = s.nextInt();
				if (escolha == 1)
					url = "funcionarios";
				else if (escolha == 2)
					url = "produtores";
				else if (escolha == 3)
					url = "safras";
				else if (escolha == 4)
					url = "classes";
				else if (escolha == 5)
					url = "departamentos";
				else if (escolha == 6)
					url = "fardos";
				else if (escolha == 7)
					url = "pedidos";
				else if (escolha == 8)
					url = "produtospedidos";
				else if (escolha == 9)
					url = "localidades";
				else if (escolha == 10)
					url = "produtos";

				if (metodo == "PUT") {
				}

				if (metodo == "PUT" || metodo == "POST") {
				}

				if (metodo == "GET" || metodo == "DELETE") {
					System.out.println("1 para um especifico");
					System.out.println("Outro para todos");
					escolha = s.nextInt();
					if (escolha == 1) {
						System.out.println("Qual id?");
						aux = s.nextLine();
						url = url + "/" + aux;
					}
				}

			} else {
				System.out.println("Qual consulta?");
				System.out.println("1 para as estimativas das safras");
				System.out.println("2 para fardos da classe L");
				System.out.println("3 para produtos sem estoque");
				System.out.println("4 para areas produzidas na cidades");
				System.out.println("5 para quantidade de fardos comprados por um funcionario");
				System.out.println("6 para areas produzidas por um produtor");
				System.out.println("7 para quantos produzem numa cidade");
				System.out.println("8 para quantos produtores um funcionario orienta");
				System.out.println("9 para quantos fardos o produtor ja produziu");
				System.out.println("10 para vendas de um produto e sua arrecadacao");
				escolha = s.nextInt();
				if (escolha == 1)
					url = "safras/estimativadoano";
				else if (escolha == 2)
					url = "fardos/fardol";
				else if (escolha == 3)
					url = "produtos/semestoque";
				else if (escolha == 4)
					url = "localidades/cidadeareaproduzida";
				else if (escolha == 5)
					url = "fardos/qtdfardoscompradorpor";
				else if (escolha == 6)
					url = "produtores/areaproduzidaporprodutor";
				else if (escolha == 7)
					url = "localidades/quantosproduzemnumacidade";
				else if (escolha == 8)
					url = "funcionarios/quantosofuncionarioorienta";
				else if (escolha == 9)
					url = "produtores/quantosfardosoprodutorproduziu";
				else if (escolha == 10)
					url = "produtos/arrecadacao";
			}

			if (metodo == "GET") {
				try {
					url = "http://localhost:8080/api/" + url;
					conn = (HttpURLConnection) new URL(url).openConnection();
					conn.setRequestMethod(metodo);
					conn.setRequestProperty("Accept", "application/json");
					if (conn.getResponseCode() != 200) {
						System.out.println("Erro " + conn.getResponseCode());
					}
					br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
					output = "";
					line = "";
					while ((line = br.readLine()) != null) {
						output += line;
					}
					conn.disconnect();
					System.out.println(output);
				} catch (IOException e) {
					return;
				}
			}
			if (metodo == "DELETE") {
				try {
					url = "http://localhost:8080/api/" + url;
					conn = (HttpURLConnection) new URL(url).openConnection();
					conn.setRequestMethod(metodo);
					conn.setRequestProperty("Accept", "application/json");
					if (conn.getResponseCode() != 200) {
						System.out.println("Erro " + conn.getResponseCode());
					}
					conn.disconnect();
				} catch (IOException e) {
					return;
				}
			}
		}
	}
}
