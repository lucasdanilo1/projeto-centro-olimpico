package cop.projeto.Model.Aluno;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static String formataTelefone(String telefone) {
        return "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 6) + "-" + telefone.substring(6);
    }

    public static String formataCPF(String cpf) {
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
    }

    public static List<Sexo> listaSexo(){
        return Arrays.asList(Sexo.values());
    }

    public static List<Regiao> listaRegiao(){
        return Arrays.asList(Regiao.values());
    }

    public static List<Status> listaStatus(){
        return Arrays.asList(Status.values());
    }

    public static List<Naturalidade> listaNaturalidade(){
        return Arrays.asList(Naturalidade.values());
    }

    public static List<Etnia> listaEtnia(){
        return Arrays.asList(Etnia.values());
    }
}

