package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Materia;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class MateriaDao implements IObjDao<Materia> {

    private SessionFactory sf;

    public MateriaDao(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void insere(Materia mat) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(mat);
        transaction.commit();
    }

    @Override
    public void modifica(Materia mat) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(mat);
        transaction.commit();
    }

    @Override
    public void remove(Materia mat) {
        String sql = "DELETE FROM materia WHERE id_mat = ?";
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1, mat.getId());
        query.executeUpdate();
        transaction.commit();
    }

    @Override
    public Materia busca(Materia mat) {
        EntityManager entityManager = sf.createEntityManager();
        mat = entityManager.find(Materia.class, mat.getId());
        return mat;
    }

    @Override
    public List<Materia> lista() {
        List<Materia> materias = new ArrayList<Materia>();
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT *");
        buffer.append("FROM materia ");
        EntityManager entityManager = sf.createEntityManager();
        Query query = entityManager.createNativeQuery(buffer.toString());
        List<Object[]> lista = query.getResultList();
        for (Object[] obj : lista) {
            Materia mat = new Materia();
            mat.setId(Integer.parseInt(obj[0].toString()));
            mat.setNome(obj[1].toString());
            mat.setHoras(Integer.parseInt(obj[2].toString()));
            mat.setDescricao(obj[3].toString());

            materias.add(mat);
        }

        return materias;
    }
}
