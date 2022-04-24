package mock;


import model.Passenger;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class PassengerMock {

    //passenger list
    Passenger [] passengers = new Passenger[4];

    public PassengerMock(){

        passengers[0] = new Passenger();
        passengers[1] = new Passenger();
        passengers[2] = new Passenger();
        passengers[3] = new Passenger();

        //set booking number
        passengers[0].setBookingNumber(10000);
        passengers[1].setBookingNumber(10001);
        passengers[2].setBookingNumber(20000);
        passengers[3].setBookingNumber(20001);

        //set flight id (two flight 1 and 2)
        passengers[0].setFlightId(1);
        passengers[2].setFlightId(1);
        passengers[3].setFlightId(2);
        passengers[4].setFlightId(2);

        //set passenger ID (4 passengers corresponds to 1,2,3,4)
        passengers[0].setPassengerId(1);
        passengers[2].setPassengerId(2);
        passengers[3].setPassengerId(3);
        passengers[4].setPassengerId(4);

        //set surname (4 people: Zihao Ye, Yichen Liu, Ran Xu, Zhihan Zhang)
        passengers[0].setSurname("Ye");
        passengers[2].setSurname("Liu");
        passengers[3].setSurname("Xu");
        passengers[4].setSurname("Zhang");

        //set first name
        passengers[0].setFirstname("Zihao");
        passengers[2].setFirstname("Yichen");
        passengers[3].setFirstname("Ran");
        passengers[4].setFirstname("Zhihan");

        //set gender 1: male 2:female 3:other gender
        passengers[0].setGender(3);
        passengers[2].setGender(1);
        passengers[3].setGender(2);
        passengers[4].setGender(1);

        //set seat level (fir: first class, bus: business class, eco: economy class)
        passengers[0].setSeatLevel("eco");
        passengers[1].setSeatLevel("bus");
        passengers[2].setSeatLevel("fir");
        passengers[3].setSeatLevel("eco");

        //set seat number
        passengers[0].setSeatNumber(1);
        passengers[1].setSeatNumber(2);
        passengers[2].setSeatNumber(10);
        passengers[3].setSeatNumber(11);

        //set meal (1,2)
        passengers[0].setMeal(1);
        passengers[1].setMeal(2);
        passengers[2].setMeal(1);
        passengers[3].setMeal(2);

        //set IdDocument
        passengers[0].setIdDocument(1111);
        passengers[1].setIdDocument(2222);
        passengers[2].setIdDocument(3333);
        passengers[3].setIdDocument(4444);
    }

    public void toJSON(){
        ObjectMapper
    }

}
