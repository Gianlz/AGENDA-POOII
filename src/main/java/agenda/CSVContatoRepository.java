package agenda;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;

public class CSVContatoRepository implements ContatoRepository {
    private String jsonFilePath;

    public CSVContatoRepository(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }

    public CSVContatoRepository() {

    }

    @Override
    public void insertData(Agenda ag) {
        ObjectMapper mapper = new ObjectMapper();
        try (FileWriter writer = new FileWriter(jsonFilePath,true)) {
            mapper.writeValue(writer, ag);
            System.out.println("Contato inserido em JSON com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao inserir contato em JSON: " + e.getMessage());
        }
    }
}