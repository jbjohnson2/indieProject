/**
 * one dao class per table
 * crud- create, retrieve, update, delete
 */

public class UserDAO {

    public void addUser(User user) {
        //connect to datebase
        //ex. Connection conn = Database.getInstance().getConnection(); (call a method in database connection class)

        //use prepared statements ex.
        //PreparedStatement p = conn.prepareStatement("insert into user(name, username, password, email, zipcode) values (?,?,?,?,?)");
        //p.setString(1, user.getName());
        //p.setString(2, user.getUserName());
        // ...
        //p.executeUpdate();
        //p.close();
    }

    public User getUser(int id) {
        return null;
    }

    //update this method to maybe find user as a search
    public List<User> getUsers() {
      return null;
    }

    public void updateUser(User user) {

    }

    public void deleteUser(int id) {

    }

}
