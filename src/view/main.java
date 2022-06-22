package view;

import model.Materia;
import model.Professor;
import org.hibernate.SessionFactory;
import persistence.MateriaDao;
import persistence.ProfessorDao;
import util.HibernateUtil;

import java.util.List;

public class main {
    public static void main(String[] args) {
        Professor prof1 = new Professor();
        prof1.setId(1);
        prof1.setNome("Sarah");
        prof1.setContato("999230430");
        prof1.setEmail("teste@gmail.com");

        Materia mat = new Materia();
        mat.setId(1);

        prof1.setMateria(mat);

        SessionFactory sf = HibernateUtil.getSessionFactory();
        ProfessorDao conn = new ProfessorDao(sf);
        conn.insere(prof1);
        //conn.remove(prof1);
    }
}
