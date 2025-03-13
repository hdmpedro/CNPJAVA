package io.hdmpedro.util;

import io.hdmpedro.model.ApiData;

import javax.management.timer.Timer;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Func {
    static Scanner sc = new Scanner(System.in);

    public static void menuPrincipal() throws IOException, InterruptedException {
        while (true) {
            System.out.println("Qual consulta gostaria de realizar? ");
            System.out.println("Receita Federal[1]");
            System.out.println("Simples Nacional[2]");
            System.out.println("Cadastro de Contribuintes[3]");
            System.out.println("SUFRAMA[4]");
            System.out.println("Sair[0]");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("1")) {
                receitaFederal();
            } else if (input.equalsIgnoreCase("2")) {
                simplesNacional();

            } else if (input.equalsIgnoreCase("3")) {
                cadastroContribuintes();
            } else if (input.equalsIgnoreCase("4")) {
                sufrarma();
            } else if (input.equalsIgnoreCase("0")) {
                System.exit(0);
            }


        }


    }

    public static String receitaFederal() throws IOException, InterruptedException {
        int input = 1;
        System.out.println("Esta consulta fornece informações cadastrais do estabelecimento, incluindo situação da inscrição, endereço, contatos, atividades econômicas e quadro societário.");
        System.out.println("Digite o CNPJ: ");
        String cnpj = sc.nextLine();
        ApiConsumer api = new ApiConsumer();
        String apiKey = ApiData.API_KEY.getValue();
        String apiUrl = ApiData.API_URL_RECEITA_FEDERAL.formatarUrl(cnpj);

        String response = api.fazerRequisicaoGet(apiUrl, apiKey);
        System.err.println(response);
        TimeUnit.SECONDS.sleep(1);

        menuPrincipal();
        return (response);


    }

    public static String simplesNacional() throws IOException, InterruptedException {
        int input = 1;
        System.out.println("A consulta à Receita Federal disponibiliza os dados cadastrais, no entanto não inclui informações sobre a opção pelo regime tributário do Simples Nacional ou o enquadramento no MEI (Microempreendedor Individual).");
        System.out.println("Digite o CNPJ: ");
        String cnpj = sc.nextLine();

        ApiConsumer api = new ApiConsumer();
        String apiKey = ApiData.API_KEY.getValue();
        String apiUrl = ApiData.API_URL_SIMPLES_NACIONAL.formatarUrl(cnpj);

        String response = api.fazerRequisicaoGet(apiUrl, apiKey);
        System.err.println(response);
        TimeUnit.SECONDS.sleep(1);

        menuPrincipal();

        return (response);


    }

    public static String cadastroContribuintes() throws IOException, InterruptedException {

        int input = 1;
        System.out.println("Outra informação amplamente utilizada são Inscrições Estaduais, obtidas através do Cadastro Centralizado de Contribuinte (CCC), que está sujeito a cobranças adicionais similares às do regime Simples Nacional.");
        System.out.println("Digite o CNPJ: ");
        String cnpj = sc.nextLine();
        ApiConsumer api = new ApiConsumer();
        String apiKey = ApiData.API_KEY.getValue();
        String apiUrl = ApiData.API_URL_CADASTRO_CONTRIBUINTE.formatarUrl(cnpj);

        String response = api.fazerRequisicaoGet(apiUrl, apiKey);
        System.err.println(response);
        TimeUnit.SECONDS.sleep(1);

        menuPrincipal();
        return (response);

    }

    public static String sufrarma() throws IOException, InterruptedException {
        int input = 1;
        System.out.println("A Superintendência da Zona Franca de Manaus (SUFRAMA) permite a consulta de projetos associados ao CNPJ, bem como a obtenção de informações sobre incentivos fiscais disponíveis para essas entidades.");
        System.out.println("Digite o CNPJ: ");
        String cnpj = sc.nextLine();

        ApiConsumer api = new ApiConsumer();
        String apiKey = ApiData.API_KEY.getValue();
        String apiUrl = ApiData.API_URL_RECEITA_SUFRARMA.formatarUrl(cnpj);
        String response = api.fazerRequisicaoGet(apiUrl, apiKey);
        System.err.println(response);
        TimeUnit.SECONDS.sleep(1);

        menuPrincipal();



        return (response);
    }


}
