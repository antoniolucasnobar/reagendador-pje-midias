package br.jus.trt4.pje.midias.reagendador;

import java.util.Optional;

public class Properties {

    public static String ENTITY_PACKAGES = "br.jus.trt4.pje.midias.reagendador.entidades";
    private static String urlDB = "URL_DB";
    private static String userDB = "USER_DB";
    private static String passDB = "PASS_DB";

    private static String urlMidias = "URL_MIDIAS";
    private static String passMidias = "PASS_MIDIAS";

    private static String paramIdCNJ = "PARAM_ID_CNJ";
    private static String paramPassMidias = "PARAM_PASS_MIDIAS";

    public static String getUrlDB(){
        return "jdbc:mysql://" + getProperty(urlDB).orElse("pje04-midias-db.trt4.gov.br/hml");
    }

    public static String getUserDB(){
        return getProperty(userDB).orElse("");
    }

    public static String getPassDB(){
        return getProperty(passDB).orElse("");
    }

    public static String getUrlMidias(){
        return getProperty(urlMidias).orElse(URL_TRN);
    }

    public static String getPassMidias(){
        return getProperty(passMidias).orElse("");
    }

    public static String getParamIdCNJ() {
        return getProperty(paramIdCNJ).orElse("idcnj");
    }

    public static String getParamPassMidias() {
        return getProperty(paramPassMidias).orElse("pass");
    }

    public static Integer ERROR_STATUS = Integer.valueOf(5);
    public static String URL_TRN = "https://pjetrn.trt4.jus.br/pje-midias-sincronizador/cron/index";
    public static String URL_PRD = "https://pje.trt4.jus.br/pje-midias-sincronizador/cron/index";

    static Optional<String> getProperty(String property){
        return Optional.ofNullable(System.getProperty(property));
    }
}
