package io.git.yhugorocha.learning.entities.enums;

public enum SolicitationSituation {
    INITIATED("Iniciada"),
    PENDING("Pendente"),
    CONCLUDED("Concluída");

    private String situation;
    SolicitationSituation(String situation) {
        this.situation = situation;
    }

    public String getSituation(){
        return situation;
    }

    public static SolicitationSituation fromSituation(String s) throws RuntimeException {
        for (SolicitationSituation situation : SolicitationSituation.values()) {
            if (situation.name().equalsIgnoreCase(s)) {
                return situation;
            }
        }
        throw new RuntimeException("Não existe situação com esse código: " + s);
    }
}
