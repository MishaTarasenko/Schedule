import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;

public class XML {

    //this method parses data about pairs from the selected file
    public static ArrayList<Pair> parsePairs(String filename) {
        ArrayList<Pair> pairs = new ArrayList<>();
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(filename,
                    XML.class.getResourceAsStream(filename));
            Pair pair = null;
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (reader.getLocalName().equals("pair")) {
                            pair = new Pair();
                        } else if (reader.getLocalName().equals("group")) {
                            assert pair != null;
                            pair.setGroup(reader.getElementText());
                        } else if (reader.getLocalName().equals("disciplin")) {
                            assert pair != null;
                            pair.setDisciplin(reader.getElementText());
                        } else if (reader.getLocalName().equals("teacher")) {
                            assert pair != null;
                            pair.setTeacher(reader.getElementText());
                        } else if (reader.getLocalName().equals("day")) {
                            assert pair != null;
                            pair.setDay(Integer.parseInt(reader.getElementText()));
                        } else if (reader.getLocalName().equals("time")) {
                            assert pair != null;
                            pair.setTime(reader.getElementText());
                        } else if (reader.getLocalName().equals("weeks")) {
                            assert pair != null;
                            pair.setWeek( reader.getElementText());
                        } else if (reader.getLocalName().equals("audience")) {
                            assert pair != null;
                            pair.setAudience(reader.getElementText());
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (reader.getLocalName().equals("pair")) {
                            pairs.add(pair);
                        }
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return pairs;
    }
}
