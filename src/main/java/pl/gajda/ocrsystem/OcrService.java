package pl.gajda.ocrsystem;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import net.sourceforge.tess4j.*;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;


@Service
public class OcrService {

    public String doOCR(String url) throws IOException {
        try {
            URL imageFile = new URL // pobranie obrazka z internetu
                    (url);
            BufferedImage bufferedImage = ImageIO.read(imageFile); // zamiana obrazka na postać bitową

            ITesseract instance = new Tesseract(); // tworzenie instancji klasy Tesseract (translacji obrazku na tekst)
            instance.setDatapath("C:\\Users\\piotr.gajda.ext.DIEBOLD_MASTER\\Downloads"); // wskazanie danych do odczytu
            instance.setLanguage("pol"); // ustawienie języka na język polski


            return instance.doOCR(bufferedImage);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "";
    }
}