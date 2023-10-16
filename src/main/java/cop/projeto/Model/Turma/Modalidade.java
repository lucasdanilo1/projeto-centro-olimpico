package cop.projeto.Model.Turma;

public enum Modalidade {

    GINASTICA_LOCALIZADA("Ginástica Localizada"),
    SALTOS_ORNAMENTAIS("Saltos Ornamentais"),
    POLO_AQUATICO("Polo Aquático"),
    ATLETISMO("Atletismo"),
    NATACAO("Natação"),
    FUTEBOL("Futebol"),
    VOLEI("Vôlei"),
    FUTSAL("Futsal"),
    KARATE("Karatê"),
    DANCA("DANÇA");


    private String descricao;

    Modalidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
