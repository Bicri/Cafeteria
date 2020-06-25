
package tipografia;

import java.awt.Font;
import java.io.InputStream;

/**
 *
 * @author isaac
 */
public class Fuentes {
    
    private Font font = null;
    public String monserratMedium = "MontserratMedium.ttf";
    public String monserratMediumItalic = "MontserratMediumItalic.ttf";
    public String monserratRegular = "MontserratRegular.ttf";
    public String monserratSemiBold = "MontserratSemiBold.ttf";
    public String pragatiNarrowRegular = "PragatiNarrowRegular.ttf";
    
    /*
        Font.PLAIN = 0
        Font.BOLD = 1
        Font.ITALIC = 2
    */

    public Font fuente(String fontName, int estilo, float tamanio) {
        try
        {
           InputStream is = getClass().getResourceAsStream(fontName);
           font = Font.createFont(Font.TRUETYPE_FONT, is);
        }catch(Exception ex)
        {
            System.out.println("No se pudo cargar la fuenta: " + fontName);
            font = new Font("Arial", Font.PLAIN, 14);
        }
        
        Font fFont = font.deriveFont(estilo, tamanio);
        return fFont;
    }
    
    
}
