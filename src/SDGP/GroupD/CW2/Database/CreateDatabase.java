package SDGP.GroupD.CW2.Database;

public class CreateDatabase {

     public CreateDatabase() {

          // Create the database tables
          new CreateActiveSessionTable();
          new CreateAdministratorTable();
          new CreateContextTable();
          new CreateConversationTable();
          new CreateConversationTextTable();
          new CreateLanguageTable();
          new CreateLevelTable();
          new CreateLoginAnalyticsTable();
          new CreatePracticeFeedbackTable();
          new CreateUserTable();
     }
}
