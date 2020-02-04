package BaseObject;

import java.util.List;

public class Radio {

    private String genre;
    private List<Station> stations/* = new ArrayList<Station>()*/;

    public Radio(String genre, List<Station> stations){
        this.genre = genre;
        this.stations = stations;
    }

    public void setName(String genre) {
        this.genre = genre;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public String getGenre() {
        return genre;
    }

    public List<Station> getStations() {
        return stations;
    }

    public String[] getStationNames(){
        String[] result = new String[stations.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = stations.get(i).getName();
        }

        return result;
    }
}
