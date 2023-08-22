package agenda;

public class Agenda {
    // nome, data_nasc, telefone, email
    private  String nome;
    private  String data_nasc; // Usar Calendar
    private  String telefone;
    private  String email;

    public Agenda(String nome, String data_nasc, String telefone, String email) {
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.telefone = telefone;
        this.email = email;
    }

    public Agenda() {

    }
    public String getNome() {
        return nome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}
