import java.sql.*;

public class CvOwnerDaoImpl implements CvOwnerDao{

    private Connection conn = DatabaseConnection.getInstance();

    public CvOwnerDaoImpl(){}

    @Override
    public void add(CvOwner person) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.prepareStatement("INSERT INTO cvOwner values (?,?,?,?,?);");
            preparedStatement.setString(2, person.getName());
            preparedStatement.setString(3, person.getSurname());
            preparedStatement.setString(4, person.getDepartment());
            preparedStatement.setString(5, person.getCvFilePath());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(CvOwner person) {
        PreparedStatement p = null;
        try {
            p = conn.prepareStatement("delete from cvOwner where id=?");
            p.setInt(1,person.getId());
            p.execute();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public int getMaxId() throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM cvOwner");
        System.out.println(resultSet.getInt(1));
        return resultSet.getInt(1);
    }

    public void deleteAll() throws SQLException {
        String sql="delete from cvOwner";
        PreparedStatement p =conn.prepareStatement(sql);
        p.execute();
    }
}
