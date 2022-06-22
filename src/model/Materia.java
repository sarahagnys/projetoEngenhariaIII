package model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Table(name = "materia")
@Entity
public class Materia {

    @Id
    @Column(name = "id_mat")
    @NotNull
    private int id;

    @Column(name = "nome_mat", length = 100)
    @NotNull
    private String nome;

    @Column(name = "horas_mat")
    @NotNull
    private int horas;

    @Column(name = "descricao_mat", length = 250)
    @NotNull
    private String descricao;

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

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", horas=" + horas +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
