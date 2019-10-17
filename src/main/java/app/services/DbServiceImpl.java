package app.services;

import app.database.DbController;
import app.model.Developer;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class DbServiceImpl implements DbService{


    private void connection() throws SQLException, ClassNotFoundException {
        if (!DbController.isConnected()){
            DbController.connectionDataBases();
            DbController.setConnected(true);
        }
    }

    @Override
    public List<String> getAllRecords() throws SQLException, ClassNotFoundException {
        if (DbController.isConnected()){
            return DbController.getAllRecords();
        }else{
            this.connection();
            return DbController.getAllRecords();
        }
    }

    public void addDevelopers (Developer developer) throws SQLException, ClassNotFoundException {
        if (DbController.isConnected()){
            DbController.insetInDataBase(developer);
        }else{
            this.connection();
            DbController.insetInDataBase(developer);
        }
    }

}

