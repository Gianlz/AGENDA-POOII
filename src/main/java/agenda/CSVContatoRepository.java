package agenda;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVContatoRepository implements ContatoRepository {
    private String csvFilePath;

    public CSVContatoRepository(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    public CSVContatoRepository() {

    }

    @Override
    public void insertData(Agenda ag) {
        try (FileWriter writer = new FileWriter(csvFilePath, true)) {
            StringBuilder sb = new StringBuilder();
            sb.append(ag.getNome()).append(",");
            sb.append(ag.getEmail()).append(",");
            sb.append(ag.getTelefone()).append("\n");

            writer.write(sb.toString());
            System.out.println("Contato inserido em CSV com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao inserir contato em CSV: " + e.getMessage());
        }
    }

}
