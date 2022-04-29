package SDGP.GroupD.CW2.Entity;

public class LoginAnalytic {

        private int loginAnalyticID;

        private String dateLogged;

        private String action;

        private int userID;

        public LoginAnalytic() {}

        public LoginAnalytic(int loginAnalyticID, String dateLogged, String action, int userID) {
            this.loginAnalyticID = 0;
            this.dateLogged = dateLogged;
            this.action = action;
            this.userID = userID;
        }

        public int getLoginAnalyticID() { return loginAnalyticID; }
        public void setLoginAnalyticID(int loginAnalyticID) {this.loginAnalyticID = loginAnalyticID;}
        public String getDateLogged() {return dateLogged;}
        public void setDateLogged(String dateLogged) {this.dateLogged = dateLogged;}
        public String getAction() {return action;}
        public void setAction(String action) {this.action = action;}
        public int getUserID() {return userID;}
        public void setUserID(int userID) {this.userID = userID;}
    }
