package cop.projeto.Model.Exceptions;

public class TurmaFechadaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TurmaFechadaException() {
        super("Turma Fechada.");
    }

}