import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlWritter {
    private static final Logger logger = Logger.getLogger(XmlWritter.class.getName());

    private XmlWritter() {
    }

    public static void generateXmlReq(FullInfo fullInfo) {

        try {
            logger.log(Level.INFO, "Начало работы с XML");

            JAXBContext jaxbContext = JAXBContext.newInstance(FullInfo.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            try {
                Files.createDirectory(Paths.get("xmlReqs"));
                logger.log(Level.INFO, "Создана папка");
            } catch (IOException ioEx) {
                logger.log(Level.FINE, "Папка уже существует", ioEx);
            }
            File requestFile = new File("xmlReqs/infoReq" + new Date().getTime() + ".xml");

            marshaller.marshal(fullInfo, requestFile);
        } catch (JAXBException jaxbEx) {
            logger.log(Level.SEVERE, "Неудача при создании XML", jaxbEx);
            return;
        }

        logger.log(Level.INFO, "XML файл успешно создан");
    }
}
