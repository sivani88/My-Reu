package Service;

import com.example.maru.Model.Meeting;
import com.example.maru.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DummyMeetingGenerator {

    public static List<Meeting> DUMMY_MEETINGS = Arrays.asList(new Meeting(1, "projet lala", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "Paris", "01/01/2022", "10", true, R.drawable.paris),
            new Meeting(2, "projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "Laponie", "02/01/2022", "11", true, R.drawable.laponie),
            new Meeting(3, "projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "Paris", "03/01/2022", "12", true, R.drawable.paris),
            new Meeting(4, "projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "Paris", "04/01/2022", "13", true, R.drawable.paris),
            new Meeting(5, "projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "Paris", "05/01/2022", "14", true, R.drawable.newyork),
            new Meeting(6, "projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "London", "01/01/2022", "10", true, R.drawable.london),
            new Meeting(7, "projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "Moscou", "01/01/2022", "10", true, R.drawable.moscou),
            new Meeting(8, "projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "Barcelona", "01/01/2022", "10", true, R.drawable.barcelona),
            new Meeting(9, "projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "Berlin", "01/01/2022", "10", true, R.drawable.berlin),
            new Meeting(10, "projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "Venise", "01/01/2022", "10", true, R.drawable.venise),
            new Meeting(11, "projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "Venise", "02/01/2022", "10", true, R.drawable.venise),
            new Meeting(12, "projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "Venise", "01/01/2022", "11", true, R.drawable.venise),
            new Meeting(13, "projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "Venise", "05/01/2022", "10", true, R.drawable.venise),
            new Meeting(14, "projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "Vienna", "01/01/2022", "10", true, R.drawable.vienna));

    static ArrayList<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETINGS);
    }
}
