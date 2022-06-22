package view;

import model.Materia;
import model.MateriaBuilder;
import model.Professor;
import model.ProfessorBuilder;
import org.hibernate.SessionFactory;
import persistence.MateriaDao;
import persistence.ProfessorDao;
import util.HibernateUtil;

public class mainBuilder {
    public static void main(String[] args) {
        Materia materia3 = MateriaBuilder.builder()
                .addMateria(3, "Fisica", 10, "materia fisica")
                .get();

        SessionFactory sf = HibernateUtil.getSessionFactory();
        //MateriaDao conn = new MateriaDao(sf);
        ProfessorDao conn = new ProfessorDao(sf);
        //conn.insere(materia3);
        //conn.remove(prof1);

        Professor professor2 = ProfessorBuilder.builder()
                .addProfessor(2, "Sarah", "teste@gmail.com", "11999230431")
                .addMateria(2)
                .get();
        conn.insere(professor2);
    }
}
