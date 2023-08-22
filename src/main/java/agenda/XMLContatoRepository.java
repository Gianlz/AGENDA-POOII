package agenda;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLContatoRepository implements ContatoRepository {
    private String xmlFilePath;

    public XMLContatoRepository(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
    }

    @Override
    public void insertData(Agenda ag) {
        try (XMLEncoder encoder = new XMLEncoder(new FileOutputStream(xmlFilePath, true))) {
            encoder.writeObject(ag);
            System.out.println("Contato inserido em XML com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao inserir contato em XML: " + e.getMessage());
        }
    }
}
