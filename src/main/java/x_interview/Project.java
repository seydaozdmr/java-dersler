package x_interview;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Project implements Comparable<Project>{
    Date date;

    public Project(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(Project o) {
        return o.date.compareTo(this.date);
    }

    @Override
    public String toString() {
        SimpleDateFormat ft =
                new SimpleDateFormat ("yyyy.MM.dd");
        return ft.format(date);
    }
}
