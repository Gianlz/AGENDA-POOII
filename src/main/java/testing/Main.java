package testing;
import agenda.*;

public class Main {

    public static void main(String[] args) {
        // Crie instâncias dos repositórios para cada formato
        ContatoRepository xmlRepository = new XMLContatoRepository("contatos.xml");
        ContatoRepository jsonRepository = new JSONContatoRepository("contatos.json");
        ContatoRepository csvRepository = new CSVContatoRepository("contatos.csv");
        ContatoRepository mysqlRepository = new MySQLContatoRepository();


        Agenda contato = new Agenda("Gianluca", "2003-09-01", "991006398", "gianlucazugnoifc@gmail.com");
        Agenda contato1 = new Agenda("João", "1990-01-15", "123456789", "joao@example.com");

        // Inserção de Dados
        xmlRepository.insertData(contato1);
        jsonRepository.insertData(contato1);
        csvRepository.insertData(contato1);
        mysqlRepository.insertData(contato1);


    }
}
