package model;

public class MateriaBuilder {
    private Materia materia;

    public MateriaBuilder() {
        this.materia = new Materia();
    }

    public static MateriaBuilder builder() {
        return new MateriaBuilder();
    }

    public MateriaBuilder addMateria(int id, String nome, int horas, String descricao) {
        this.materia.setId(id);
        this.materia.setNome(nome);
        this.materia.setHoras(horas);
        this.materia.setDescricao(descricao);
        return this;
    }

    public Materia get() {
        return this.materia;
    }
}
