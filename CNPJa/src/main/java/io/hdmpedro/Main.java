package io.hdmpedro;

import io.hdmpedro.model.ApiData;
import io.hdmpedro.util.ApiConsumer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.hdmpedro.util.Func;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        ApiConsumer api = new ApiConsumer();

        Func.menuPrincipal();



        //String apiKey = ApiData.API_KEY.getValue();
        //String apiUrl = ApiData.API_URL_RECEITA_FEDERAL.formatarUrl(cnpj);

        //String response = api.fazerRequisicaoGet(apiUrl, apiKey);

        //System.err.println(response);

        //ObjectMapper mapper = new ObjectMapper();
        // mapper.writerWithDefaultPrettyPrinter().writeValue(new File("dados2.json"), response);

        sc.close();


    }
}