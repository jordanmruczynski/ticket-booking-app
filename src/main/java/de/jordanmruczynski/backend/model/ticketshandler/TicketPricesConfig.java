package de.jordanmruczynski.backend.model.ticketshandler;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ticket-prices")
public class TicketPricesConfig {

    private double adult;
    private double student;
    private double child;

    public double getAdult() {
        return adult;
    }

    public void setAdult(double adult) {
        this.adult = adult;
    }

    public double getStudent() {
        return student;
    }

    public void setStudent(double student) {
        this.student = student;
    }

    public double getChild() {
        return child;
    }

    public void setChild(double child) {
        this.child = child;
    }
}
