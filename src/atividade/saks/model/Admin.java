package atividade.saks.model;

public class Admin {
     private int id;
    private String nome;
    private int idade;
    private String cpf;
    private String email;
    private String senha;
    private String pergunta1;
    private String pergunta2;
    private String pergunta3;
    private int ativo;
    
    public Admin() {}

    public Admin(int id, String nome, int idade, String cpf, String email, String senha, String pergunta1, String pergunta2, String pergunta3) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.pergunta1 = pergunta1;
        this.pergunta2 = pergunta2;
        this.pergunta3 = pergunta3;
        this.ativo = 1;
    }
    
    public Admin(String nome, int idade, String cpf, String email, String senha, String pergunta1, String pergunta2, String pergunta3) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.pergunta1 = pergunta1;
        this.pergunta2 = pergunta2;
        this.pergunta3 = pergunta3;
        this.ativo = 1;
    }

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPergunta1() {
        return pergunta1;
    }

    public void setPergunta1(String pergunta1) {
        this.pergunta1 = pergunta1;
    }

    public String getPergunta2() {
        return pergunta2;
    }

    public void setPergunta2(String pergunta2) {
        this.pergunta2 = pergunta2;
    }

    public String getPergunta3() {
        return pergunta3;
    }

    public void setPergunta3(String pergunta3) {
        this.pergunta3 = pergunta3;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
}
