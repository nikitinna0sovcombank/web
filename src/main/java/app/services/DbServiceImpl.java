package app.services;

import app.database.DbController;
import app.model.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class DbServiceImpl implements DbService{

    @Autowired private static DbController dbController;


    private static void connection() throws SQLException, ClassNotFoundException {
        if (!dbController.isConnected()){
            dbController.connectionDataBases();
            dbController.setConnected(true);
        }
    }

    @Override
    public List<String> getAllRecords() throws SQLException, ClassNotFoundException {
        if (dbController.isConnected()){
            return dbController.getAllRecords();
        }else{
            this.connection();
            return dbController.getAllRecords();
        }
    }

    public void addDevelopers (Developer developer) throws SQLException, ClassNotFoundException {
        if (dbController.isConnected()){
            dbController.insetInDataBase(developer);
        }else{
            connection();
        }
    }

}

