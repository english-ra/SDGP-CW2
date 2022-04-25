package SDGP.GroupD.CW2.Database;

import SDGP.GroupD.CW2.Entity.Conversation;
import SDGP.GroupD.CW2.Entity.ConversationText;
import SDGP.GroupD.CW2.Entity.User;
import SDGP.GroupD.CW2.Entity.UserFeedback;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;


public class DatabaseAPI {

    //USE THIS TO TEST
    public static void main(String[] args) {
        DatabaseAPI db = new DatabaseAPI();
//        User u = db.getUser("reece");
//        System.out.println(u.getFirstName());

    }

    public String createUser(User user) {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;

        String sqlString = "INSERT INTO users (firstName,lastName,username,password,passwordSalt,userType,teacherID)\n" +
                "VALUES (" +
                "'" + user.getFirstName() + "'," +
                "'" + user.getLastName() + "'," +
                "'" + user.getUserName() + "'," +
                "'" + user.getPassword() + "'," +
                "'" + user.getPasswordSalt() + "'," +
                "'" + user.getUserType() + "'," +
                "" + user.getTeacherID() +
                ")";
        try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.executeUpdate(sqlString);
            stmt.close();
            con.commit();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            return ex.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                    return e.getMessage();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                    return e.getMessage();
                }
            }
        }
        return "";
    }


    public boolean createConversation(Conversation conversation) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = ConnectDB.getConnection();
            con.setAutoCommit(false);

            stmt = con.prepareStatement("INSERT INTO Conversation VALUES(?,?,?,?)");
            stmt.setString(2, conversation.getLanguage());
            stmt.setString(3, conversation.getLevel());
            stmt.setString(4, conversation.getContext());

            stmt.executeUpdate();

            int primaryKey = stmt.getGeneratedKeys().getInt(1);
            conversation.setConversationID(primaryKey);

            stmt.close();
            con.commit();
        } catch (SQLException e) {
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                    return false;
                }
            }
        }
        return true;
    }


    public boolean createConversationText(ConversationText conversationText) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = ConnectDB.getConnection();
            con.setAutoCommit(false);

            stmt = con.prepareStatement("INSERT INTO ConversationText VALUES(?,?,?,?,?,?)");
            stmt.setString(2, conversationText.getText());
            stmt.setString(3, conversationText.getPrompt());
            stmt.setString(4, conversationText.getPerson());
            stmt.setInt(5, conversationText.getPositionInConvo());
            stmt.setInt(6, conversationText.getConversationID());

            stmt.executeUpdate();

            int primaryKey = stmt.getGeneratedKeys().getInt(1);
            conversationText.setConversationTextID(primaryKey);

            stmt.close();
            con.commit();
        } catch (SQLException e) {
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                    return false;
                }
            }
        }
        return true;
    }


    public User getUser(String username) {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        User user = null;

        String sqlString = "SELECT * FROM users WHERE username = '" + username + "'";
        try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            rs = stmt.executeQuery(sqlString);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPasswordSalt(rs.getString("passwordSalt"));
                user.setUserType(rs.getString("userType"));
                user.setTeacherID(rs.getInt("teacherID"));
            }
            rs.close();
            stmt.close();
            con.commit();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }

        return user;
    }

    public User getUser(int userID) {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        User user = null;

        String sqlString = "SELECT * FROM users WHERE userID = '" + userID + "'";
        try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            rs = stmt.executeQuery(sqlString);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPasswordSalt(rs.getString("passwordSalt"));
                user.setUserType(rs.getString("userType"));
                user.setTeacherID(rs.getInt("teacherID"));
            }
            rs.close();
            stmt.close();
            con.commit();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }

        return user;
    }


    public String[] getConversationLanguages() {
        Connection con = null;
        PreparedStatement stmt = null;
        ArrayList<String> languages = new ArrayList<String>();

        try {
            con = ConnectDB.getConnection();
            con.setAutoCommit(false);

            stmt = con.prepareStatement("SELECT DISTINCT language FROM Conversation ORDER BY language");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) { languages.add(rs.getString("language")); }

            stmt.close();
            con.commit();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                try { stmt.close(); }
                catch (SQLException e) { System.err.println("SQLException: " + e.getMessage()); }
            }
            if (con != null) {
                try { con.close(); }
                catch (SQLException e) { System.err.println("SQLException: " + e.getMessage()); }
            }
        }
        return languages.toArray(new String[0]);
    }


    public String[] getConversationContexts(String language, String level) {
        Connection con = null;
        PreparedStatement stmt = null;
        ArrayList<String> contexts = new ArrayList<String>();

        try {
            con = ConnectDB.getConnection();
            con.setAutoCommit(false);

            stmt = con.prepareStatement("SELECT DISTINCT context FROM Conversation WHERE language = ? AND level = ? ORDER BY context");
            stmt.setString(1, language);
            stmt.setString(2, level);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) { contexts.add(rs.getString("context")); }

            stmt.close();
            con.commit();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                try { stmt.close(); }
                catch (SQLException e) { System.err.println("SQLException: " + e.getMessage()); }
            }
            if (con != null) {
                try { con.close(); }
                catch (SQLException e) { System.err.println("SQLException: " + e.getMessage()); }
            }
        }
        return contexts.toArray(new String[0]);
    }

    public Boolean createUserFeedback(UserFeedback userFeedback) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = ConnectDB.getConnection();
            con.setAutoCommit(false);

            stmt = con.prepareStatement("INSERT INTO PracticeFeedback VALUES(?,?,?,?,?,?,?)");
            stmt.setString(2, userFeedback.getDateLogged());
            stmt.setString(3, userFeedback.getNotes());
            stmt.setInt(4, userFeedback.getScore());
            stmt.setInt(5, userFeedback.getConversationID());
            stmt.setInt(6, userFeedback.getUserID());
            stmt.setInt(7, userFeedback.getLoggedByID());

            stmt.executeUpdate();

            stmt.close();
            con.commit();
        } catch (SQLException e) {
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                    return false;
                }
            }
        }
        return true;
    }

    public ArrayList getConversations(String context) {
        Connection con = null;
        PreparedStatement stmt = null;
        ArrayList<Conversation> conversations = new ArrayList<Conversation>();

        try {
            con = ConnectDB.getConnection();
            con.setAutoCommit(false);

            stmt = con.prepareStatement("SELECT * FROM Conversation WHERE context = ?");
            stmt.setString(1, context);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Conversation conversation = new Conversation();
                conversation.setConversationID(rs.getInt("conversationID"));
                conversation.setLanguage(rs.getString("language"));
                conversation.setLevel("level");
                conversation.setContext("context");
                conversations.add(conversation);
            }

            stmt.close();
            con.commit();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                try { stmt.close(); }
                catch (SQLException e) { System.err.println("SQLException: " + e.getMessage()); }
            }
            if (con != null) {
                try { con.close(); }
                catch (SQLException e) { System.err.println("SQLException: " + e.getMessage()); }
            }
        }
        return conversations;
    }

    public Boolean getConversationTexts(Conversation conversation) {
        Connection con = null;
        PreparedStatement stmt = null;
        ArrayList<ConversationText> texts = new ArrayList<ConversationText>();

        try {
            con = ConnectDB.getConnection();
            con.setAutoCommit(false);

            stmt = con.prepareStatement("SELECT * FROM ConversationText WHERE conversationID = ? ORDER BY positionInConvo");
            stmt.setInt(1, conversation.getConversationID());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ConversationText conversationText = new ConversationText();
                conversationText.setConversationTextID(rs.getInt("conversationTextID"));
                conversationText.setText(rs.getString("text"));
                conversationText.setPrompt(rs.getString("prompt"));
                conversationText.setPositionInConvo(rs.getInt("positionInConvo"));
                conversationText.setPerson(rs.getString("person"));
                conversationText.setConversationID(rs.getInt("conversationID"));
                texts.add(conversationText);
            }

            conversation.setTexts(texts);

            stmt.close();
            con.commit();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                try { stmt.close(); }
                catch (SQLException e) { System.err.println("SQLException: " + e.getMessage()); }
            }
            if (con != null) {
                try { con.close(); }
                catch (SQLException e) { System.err.println("SQLException: " + e.getMessage()); }
            }
        }
        return true;
    }


    public Boolean createUserIDInLocalAppDB(User user) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = ConnectDB.getConnection();
            con.setAutoCommit(false);

            stmt = con.prepareStatement("INSERT INTO LocalAppData VALUES(?)");
            stmt.setInt(1, user.getUserID());

            stmt.executeUpdate();

            stmt.close();
            con.commit();
        } catch (SQLException e) {
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                    return false;
                }
            }
        }
        return true;
    }

    public Integer getUserIDFromLocalAppDB() {
        Connection con = null;
        PreparedStatement stmt = null;
        int userID = -1;

        try {
            con = ConnectDB.getConnection();
            con.setAutoCommit(false);

            stmt = con.prepareStatement("SELECT userID FROM LocalAppData");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                userID = rs.getInt("userID");
                System.out.println(userID);
            }

            stmt.close();
            con.commit();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                try { stmt.close(); }
                catch (SQLException e) { System.err.println("SQLException: " + e.getMessage()); }
            }
            if (con != null) {
                try { con.close(); }
                catch (SQLException e) { System.err.println("SQLException: " + e.getMessage()); }
            }
        }
        return userID;
    }
}

