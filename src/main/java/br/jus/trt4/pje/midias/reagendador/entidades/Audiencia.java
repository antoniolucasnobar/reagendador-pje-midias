package br.jus.trt4.pje.midias.reagendador.entidades;

import br.jus.trt4.pje.midias.reagendador.Properties;

import javax.persistence.*;

@Entity
@Table(name = "audiencia_local")
public class Audiencia {

    @Id
    @Column(name = "seq_audiencia_local")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "seq_audiencia_cnj")
    private Integer idCNJ;

    @Column(name = "tip_status_audiencia")
    private Integer statusEnvio;

    @Column(name = "cod_cpf_usuario_sincronizador")
    private String usuarioSincronizador;

    public boolean hasError() {
        return Properties.ERROR_STATUS.equals(this.statusEnvio);
    }

//    @OneToMany(mappedBy = "audiencia", cascade = CascadeType.ALL)
//    private List<Anexo> anexos;

    @Column(name = "num_processo")
    private String processo;

    public Integer getIdCNJ() {
        return idCNJ;
    }

    public void setIdCNJ(Integer idCNJ) {
        this.idCNJ = idCNJ;
    }

    public Integer getStatusEnvio() {
        return statusEnvio;
    }

    public void setStatusEnvio(Integer statusEnvio) {
        this.statusEnvio = statusEnvio;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Audiencia{" + "id=" + id + ", idCNJ=" + idCNJ + ", statusEnvio=" + statusEnvio + ", " +
                "usuarioSincronizador='" + usuarioSincronizador + '\'' + ", processo='" + processo + '\'' + '}';
    }
}
