package dyrehage;
import java.util.Date;

/**
 * Created by Fellep on 16.03.2017.
 */
public interface ISkandinaviskeRovdyr{
    public String getNavn();
    public Date getFdato();
    public int getAlder();
    public String getAdresse();
    public void flytt(String nyAdresse);
    public String skrivUtInfo();
    public int getAntKull();
    public void leggTilKull(int antall);
    public void leggTilNyttKull();
}
