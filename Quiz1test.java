import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Quiz1test {

    @Test
    public void testCalculateWaterBill() {
       First.currentWaterMeter = 100;
        First.lastWaterMeter = 80;

 
        int waterBill = First.calculateWaterBill();


        assertEquals(100, waterBill, "Water bill calculation is incorrect");
    }

    @Test
    public void testCalculateElectBill() {

        First.currentElectMeter = 50;
        First.lastElectMeter = 20;


        int electBill = First.calculateElectBill();


        assertEquals(180, electBill, "Electric bill calculation is incorrect");
    }

    @Test
    public void testCalculateResultBillForRoomS() {

        First.currentElectMeter = 50;
        First.lastElectMeter = 20;
        First.currentWaterMeter = 100;
        First.lastWaterMeter = 80;

  
        int resultBill = First.calculateResultBill("S");


        assertEquals(1780, resultBill, "Total bill calculation is incorrect for room type S");
    }

    @Test
    public void testCalculateResultBillForRoomD() {

        First.currentElectMeter = 50;
        First.lastElectMeter = 20;
        First.currentWaterMeter = 100;
        First.lastWaterMeter = 80;


        int resultBill = First.calculateResultBill("D");


        assertEquals(2280, resultBill, "Total bill calculation is incorrect for room type D");
    }

    @Test
    public void testInvalidWaterMeter() {

        First.currentWaterMeter = 50;
        First.lastWaterMeter = 100;


        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            First.calculateWaterBill();
        });

        assertEquals("Current Water Meter must be greater than Last Water Meter", exception.getMessage());
    }

    @Test
    public void testInvalidElectMeter() {

        First.currentElectMeter = 10;
        First.lastElectMeter = 20;


        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            First.calculateElectBill();
        });

        assertEquals("Current Electric Meter must be greater than Last Electric Meter", exception.getMessage());
    }
}
