package SDGP.GroupD.CW2.Database;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class readConversationDataFromCSV {

    public static void main(String[] args) {
        readConversationDataFromCSV r = new readConversationDataFromCSV();
    }

    public readConversationDataFromCSV() {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;

        try {
            FileInputStream fStream = new FileInputStream("conversations.csv");
            DataInputStream in      = new DataInputStream(fStream);
            BufferedReader br       = new BufferedReader(new InputStreamReader(in));
            String strLine;

            ArrayList list      = new ArrayList();
            ArrayList IdChecker = new ArrayList();
            int count = 0;

            while ((strLine = br.readLine()) != null) {
                list.add(strLine);
                count++;
            }

            list.remove(0);
            Iterator itr;
            for (itr = list.iterator(); itr.hasNext();) {
                String str = itr.next().toString();
                String[] splitSt = str.split(",");

                String level    = "";
                String context  = "";
                String person   = "";
                String text     = "";
                String prompt   = "";

                try {
                    level   = splitSt[0];
                    context = splitSt[1];
                    person  = splitSt[3];
                    text    = splitSt[4];
                    prompt  = splitSt[5];
                } catch (Exception e) {
//                    System.out.println("EXCEPTION CAUGHT!");
                }






//                if (!IdChecker.contains(splitSt[0])) {
//                    IdChecker.add(splitSt[0]);
//                    int empID = Integer.parseInt(splitSt[0]);
//                    String empName = splitSt[1];
//                    String empJob = splitSt[2];
//                    int empSal = Integer.parseInt(splitSt[3]);
//                    String sqlString = "INSERT INTO employee (empName, empID, empSal, empJob) VALUES \n" + "('" + empName + "'," + empID + "," + empSal + ",'" + empJob + "')";
//                    con.setAutoCommit(false);
//                    stmt = con.createStatement();
//                    stmt.executeUpdate(sqlString);
//                    stmt.close();
//                    con.commit();
//                } else {
//                    System.out.println("duplicate record, with pk :" + splitSt[0]);
//                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        jdbcCrud.showAll();
    }
}
