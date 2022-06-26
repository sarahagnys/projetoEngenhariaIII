package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Materia;
import model.Professor;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDao implements IObjDao<Professor>{
    private SessionFactory sf;

    public ProfessorDao(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void insere(Professor prof) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(prof);
        transaction.commit();
    }

    @Override
    public void modifica(Professor prof) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(prof);
        transaction.commit();
    }

    @Override
    public void remove(Professor prof) {
        String sql = "DELETE FROM professor WHERE id_prof = ?";
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1, prof.getId());
        query.executeUpdate();
        transaction.commit();
    }

    @Override
    public Professor busca(Professor prof) {
        EntityManager entityManager = sf.createEntityManager();
        prof = entityManager.find(Professor.class, prof.getId());
        return prof;
    }

    @Override
    public List<Professor> lista() {
        List<Professor> professores = new ArrayList<Professor>();
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT prof.id_prof, prof.nome_prof, prof.email_prof, prof.contato_prof, prof.id_mat,");
        buffer.append("mat.nome_mat, mat.horas_mat, mat.descricao_mat ");
        buffer.append("FROM professor prof, materia mat ");
        buffer.append("WHERE prof.id_mat = mat.id_mat");
        EntityManager entityManager = sf.createEntityManager();
        Query query = entityManager.createNativeQuery(buffer.toString());
        List<Object[]> lista = query.getResultList();
        for (Object[] obj : lista) {
            Professor prof = new Professor();
            prof.setId(Integer.parseInt(obj[0].toString()));
            prof.setNome(obj[1].toString());
            prof.setEmail(obj[2].toString());
            prof.setContato(obj[3].toString());

            Materia mat = new Materia();
            mat.setId(Integer.parseInt(obj[4].toString()));
            mat.setNome(obj[5].toString());
            mat.setHoras(Integer.parseInt(obj[6].toString()));
            mat.setDescricao(obj[7].toString());

            prof.setMateria(mat);

            professores.add(prof);
        }

        return professores;
    }
}
