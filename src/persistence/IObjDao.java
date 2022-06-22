package persistence;

import java.util.List;

public interface IObjDao<Objeto> {

    public void insere  (Objeto obj);
    public void modifica(Objeto obj);
    public void remove  (Objeto obj);
    public Objeto busca(Objeto obj);
    public List<Objeto> lista();

}
