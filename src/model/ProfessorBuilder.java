package model;

public class ProfessorBuilder {
    private Professor professor;
    private Materia materia;

    public ProfessorBuilder() {
        this.professor = new Professor();
        this.materia = new Materia();
    }

    public static ProfessorBuilder builder() {
        return new ProfessorBuilder();
    }

    public ProfessorBuilder addProfessor(int id, String nome, String email, String contato) {
        this.professor.setId(id);
        this.professor.setNome(nome);
        this.professor.setEmail(email);
        this.professor.setContato(contato);
        return this;
    }

    public ProfessorBuilder addMateria(int id){
        this.materia.setId(id);
        return this;
    }
    public Professor get() {
        this.professor.setMateria(this.materia);
        return this.professor;
    }
}
