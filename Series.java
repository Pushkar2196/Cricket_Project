import java.util.ArrayList;
import java.util.List;

class Series {
    private String name;
    private List<Match> series;
    private int noOfMatches;
    private int matchNo;
    private String result;

    public Series(String name, int noOfMatches) {
        this.name = name;
        this.noOfMatches = noOfMatches;
        series = new ArrayList<Match>();
        matchNo = 0;
    }

    public void addMatchNo() {
        matchNo += 1;
    }

    public String getName() {
        return name;
    }

    public void addMatch(Match match) {
        series.add(match);
    }

    public String getResult() {
        return result;
    }

    public List<Match> getSeries() {
        return series;
    }
}
