package x_interview;

import java.time.LocalDate;

public class ProjectWithLocalDate {
    LocalDate localDate;

    public ProjectWithLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    @Override
    public String toString() {
        return "ProjectWithLocalDate{" +
                "localDate=" + localDate +
                '}';
    }
}
