package view;

import model.Materia;
import model.MateriaBuilder;
import model.Professor;
import model.ProfessorBuilder;
import org.hibernate.SessionFactory;
import persistence.ProfessorDao;
import util.HibernateUtil;

import java.util.List;

public class mainBuilder {
    public static void main(String[] args) {
        Materia materia3 = MateriaBuilder.builder()
                .addMateria(3, "Fisica", 10, "alterando")
                .get();

        SessionFactory sf = HibernateUtil.getSessionFactory();
        //MateriaDao conn = new MateriaDao(sf);
        ProfessorDao conn = new ProfessorDao(sf);
        //conn.insere(materia3);
        //conn.remove(prof1);

        Professor prof = ProfessorBuilder.builder()
                .addProfessor(1, "Raquel", "teste@gmail.com", "11999230431")
                .addMateria(2)
                .get();
        //conn.modifica(materia3);
        //conn.insere(prof);
        //conn.modifica(prof);
        //busca funcionou
        List<Professor> lista = conn.lista();
        lista.forEach(professor -> System.out.println(professor));
    }
}
