package cop.projeto.Model.Exceptions;

public class SexoIncompativelException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SexoIncompativelException() {
        super("Sexo Incompativel.");
    }

}
