package com.safetynet.safetynetalerts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.safetynet.safetynetalerts.config.DataBaseConfig;
import com.safetynet.safetynetalerts.model.Person;

public class PersonDaoImpl implements PersonDao {
	
	private static final Logger logger = LogManager.getLogger("TicketDAO");

    public DataBaseConfig dataBaseConfig = new DataBaseConfig();
	
	public boolean savePerson(Person person) {
		Connection con = null;
        PreparedStatement ps = null;
        try {
            con = dataBaseConfig.getConnection();
            ps = con.prepareStatement(DBConstants.SAVE_TICKET);
            //ID, PARKING_NUMBER, VEHICLE_REG_NUMBER, PRICE, IN_TIME, OUT_TIME)
            ps.setInt(1, ticket.getId());
            ps.setString(2, ticket.getVehicleRegNumber());
            ps.setDouble(3, ticket.getPrice());
            ps.setTimestamp(4, new Timestamp(ticket.getInTime().getTime()));
            ps.setTimestamp(5, (ticket.getOutTime() == null)?null: (new Timestamp(ticket.getOutTime().getTime())) );
            return ps.execute();
        }catch (Exception ex){
            logger.error("Error fetching next available slot",ex);
        }finally {
            dataBaseConfig.closeConnection(con);
            dataBaseConfig.closePreparedStatement(ps);            
        }
        return false;
	}
	
	public Person updatePerson(Person pPerson) {
		/*
		for (Person person : persons) {

			if (person.getFirstName().equals(pPerson.getFirstName())
					&& person.getLastName().equals(pPerson.getLastName())) {
				persons.remove(person);
				persons.add(pPerson);
				return pPerson;
			}
		}
		*/
		return null;

	}

	public Person deletePerson(String firstName, String lastName) {
/*
		for (Person person : persons) {

			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				persons.remove(person);
				return person;
			}
		}
		*/
		return null;
	
	}
	
}
