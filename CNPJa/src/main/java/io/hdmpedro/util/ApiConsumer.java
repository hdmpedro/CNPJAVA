package io.hdmpedro.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ApiConsumer {

    public String fazerRequisicaoGet(String url, String chaveApi) throws IOException {
        HttpURLConnection conexao = null;
        StringBuilder resposta = new StringBuilder();

        try {
            URL urlObj = new URL(url);
            conexao = (HttpURLConnection) urlObj.openConnection();

            conexao.setRequestMethod("GET");
            conexao.setRequestProperty("Authorization", chaveApi);
            conexao.setConnectTimeout(5000);
            conexao.setReadTimeout(5000);

            int codigoResposta = conexao.getResponseCode();

            InputStream fluxoEntrada = (codigoResposta == HttpURLConnection.HTTP_OK) ?
                    conexao.getInputStream() :
                    conexao.getErrorStream();

            if (fluxoEntrada != null) {
                try (BufferedReader leitor = new BufferedReader(
                        new InputStreamReader(fluxoEntrada, StandardCharsets.UTF_8))) {

                    String linha;
                    while ((linha = leitor.readLine()) != null) {
                        resposta.append(linha);
                    }
                }
            }

        } finally {
            if (conexao != null) {
                conexao.disconnect();
            }
        }

        return resposta.toString();
    }
}
