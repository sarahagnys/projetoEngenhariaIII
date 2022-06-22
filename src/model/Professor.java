package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Table(name = "professor")
@Entity

public class Professor {
    @Id
    @Column(name = "id_prof")
    @NotNull
    private int id;

    @Column(name = "nome_prof", length = 100)
    @NotNull
    private String nome;

    @Column(name = "email_prof", length = 100)
    @NotNull
    private String email;

    @Column(name = "contato_prof", length = 100)
    @NotNull
    private String contato;

    @ManyToOne(targetEntity = Materia.class)
    @JoinColumn(name = "id_mat")
    @NotNull
    private Materia materia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", contato='" + contato + '\'' +
                ", materia=" + materia +
                '}';
    }
}
