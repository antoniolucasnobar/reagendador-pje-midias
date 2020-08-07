package br.jus.trt4.pje.midias.reagendador;

import br.jus.trt4.pje.midias.reagendador.entidades.Audiencia;
import br.jus.trt4.pje.midias.reagendador.repository.AudienciaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class ReagendadorService {

    Logger logger = LoggerFactory.getLogger(ReagendadorService.class);
    public final @NonNull
    AudienciaRepository audienciaRepository;

    public final @NonNull
    RestTemplate restTemplate;
    private final String url;

    private int sucess;
    private int fail;

    public ReagendadorService(@NonNull AudienciaRepository audiencias) {
        this.restTemplate = new RestTemplate();
        this.audienciaRepository = audiencias;
        sucess = 0;
        fail = 0;
        url = Properties.getUrlMidias();
        logger.info("Ambiente: " + url);
    }

    public void reagendar(){
        List<Audiencia> midias = this.audienciaRepository.findByStatusEnvio(Properties.ERROR_STATUS);
        logger.info("Foram encontradas " + midias.size() + " mídias com erro. Tentando reagendar...");
        midias.forEach(this::reagendar);
        logger.info("Foram disparados " + sucess + " reagendamentos e " + fail + " tentativas de agendamento " +
                            "falharam!");
    }

    private void reagendar(Audiencia midia)
    {
        try {
            UriComponentsBuilder builder =
                    UriComponentsBuilder.fromHttpUrl(url)
                                       .queryParam(Properties.getParamPassMidias(), Properties.getPassMidias())
                                       .queryParam(Properties.getParamIdCNJ(), midia.getIdCNJ());

            String uri = builder.toUriString();
            logger.info(midia.toString());
            String result = restTemplate.getForObject(uri, String.class);
            logger.info(result != null ? result : "resposta do servico veio nula!");
            sucess++;
        } catch (Exception e) {
            fail++;
            logger.error("Erro ao reagendar mídia acima: "+ e.getMessage(), e);
        }
    }

}
