package agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLContatoRepository implements ContatoRepository {
    final static String BD = "agenda";

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/" + BD;
            return DriverManager.getConnection(url, "root", ""); // Lembre-se de definir a senha correta
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void insertData(Agenda ag) {
        Connection conn = conectar();
        if (conn == null) {
            System.out.println("Não foi possível conectar ao banco de dados.");
            return;
        }

        String sql = "INSERT INTO contato (nome, data_nascimento, telefone, email) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ag.getNome());
            pstmt.setString(2, ag.getData_nasc());
            pstmt.setString(3, ag.getTelefone());
            pstmt.setString(4, ag.getEmail());

            pstmt.executeUpdate();
            System.out.println("Contato inserido em MySQL com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir registro: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

}
