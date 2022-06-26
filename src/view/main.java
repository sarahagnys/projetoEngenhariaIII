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
        Materia mat1 = new Materia();
      mat1.setId(1);
      mat1.setNome("Matematica");
      mat1.setHoras(10);
      mat1.setDescricao("Teste1");
      Materia mat2 = new Materia();
      mat2.setId(2);
      mat2.setNome("Matematica");
      mat2.setHoras(10);
      mat2.setDescricao("Teste1");
      SessionFactory sf = HibernateUtil.getSessionFactory();
      MateriaDao conn = new MateriaDao(sf);
        conn.insere(mat1);
    }
}
