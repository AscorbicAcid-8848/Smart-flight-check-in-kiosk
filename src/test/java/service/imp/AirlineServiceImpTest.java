package service.imp;

import model.Airline;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class AirlineServiceImpTest {

    @Test
    public void update() {
    }

    @Test
    public void toJSON() {
        AirlineServiceImp airlineServiceImp = new AirlineServiceImp();
        Airline BUPT_test = new Airline();

        BUPT_test.setAirlineName("BUPT_test");
        BUPT_test.setAirlineId(1);

        System.out.println(airlineServiceImp.update(BUPT_test).toString());
        airlineServiceImp.toJSON();
    }
}