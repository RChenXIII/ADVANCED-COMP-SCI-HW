import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class StudentTicket extends StandardTicket {

    private static final double STUDENT_DISCOUNT = 0.50;

    public StudentTicket(Date eventDate, int ticketCount) {
        super(eventDate, ticketCount);
    }

    @Override
    public double getTotalPrice() {
        double discountedBase = getBasePrice() * (1 - STUDENT_DISCOUNT);
        double perTicket = discountedBase * (1 + getTax());
        return perTicket * getTicketCount();
    }

    @Override
    public void printTicketType() {
        System.out.println("Ticket Type: Student (Must Show ID)");
    }
}
