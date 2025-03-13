package io.hdmpedro.model;

public enum ApiData {

    API_URL_RECEITA_FEDERAL("https://api.cnpja.com/office/%s"),
    API_URL_SIMPLES_NACIONAL("https://api.cnpja.com/office/%s?simples=true"),
    API_URL_CADASTRO_CONTRIBUINTE("https://api.cnpja.com/office/%s?registrations=BR"),
    API_URL_RECEITA_SUFRARMA("https://api.cnpja.com/office/%s?suframa=true"),
    API_KEY("");




    private final String value;


    ApiData(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public String formatarUrl(String cpnjOuCpf){
        return String.format(this.value, cpnjOuCpf);
    }
}
