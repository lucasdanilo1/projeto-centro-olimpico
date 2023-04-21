package cop.projeto.Model.Turma;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static List<Modalidade> listaModalidade(){
        return Arrays.asList(Modalidade.values());
    }

    public static List<Dias> listaDias(){
        return Arrays.asList(Dias.values());
    }

    public static List<Horario> listaHorario(){
        return Arrays.asList(Horario.values());
    }

    public static List<Naipe> listaNaipe(){
        return Arrays.asList(Naipe.values());
    }

    public static List<Faixa> listaFaixa(){
        return Arrays.asList(Faixa.values());
    }
}
