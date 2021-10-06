package model;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.WritableRaster;

/**
 *
 * @author Elieser
 * 
 * Esta classe é apenas um guia de implementação de alguns filtros para o trabalho.
 * Ela não deve ser utiliza na sua forma atual.
 * 
 */
public class GODClass {
    //++++++++++++++++++++
    public static BufferedImage getImagemEmTonsDeCinza(BufferedImage imagem) throws Exception {
        BufferedImage imagemFiltrada = 
                new BufferedImage(imagem.getWidth(null), 
                        imagem.getHeight(null), BufferedImage.TYPE_BYTE_GRAY);
        imagemFiltrada.getGraphics().drawImage(imagem, 0, 0, null);
        return imagemFiltrada;
    }
    
    //+++++++++++++++++++++++++++++++++
    public static BufferedImage getVersaoSepiaDaImagem(BufferedImage img) throws Exception {
        //código retirado de : http://www.rhinocerus.net/forum/lang-java-programmer/574119-sepia-tone-image-filter-java.html
        
        int sepiaIntensity = 30;

        // Play around with this. 20 works well and was recommended
        // by another developer. 0 produces black/white image
        int sepiaDepth = 20;

        int w = img.getWidth();
        int h = img.getHeight();

        WritableRaster raster = img.getRaster();

        // We need 3 integers (for R,G,B color values) per pixel.
        int[] pixels = new int[w * h * 3];
        raster.getPixels(0, 0, w, h, pixels);

        // Process 3 ints at a time for each pixel. Each pixel has 3 RGB colors in array
        for (int i = 0; i < pixels.length; i += 3) {
            int r = pixels[i];
            int g = pixels[i + 1];
            int b = pixels[i + 2];

            int gry = (r + g + b) / 3;
            r = g = b = gry;
            r += (sepiaDepth * 2);
            g += sepiaDepth;

            if (r > 255) {
                r = 255;
            }
            if (g > 255) {
                g = 255;
            }
            if (b > 255) {
                b = 255;
            }

            // Darken blue color to increase sepia effect
            b -= sepiaIntensity;

            // normalize if out of bounds
            if (b < 0) {
                b = 0;
            }
            if (b > 255) {
                b = 255;
            }

            pixels[i] = r;
            pixels[i + 1] = g;
            pixels[i + 2] = b;
        }
        raster.setPixels(0, 0, w, h, pixels);
        
        return img;
    }
    //+++++++++++++++++++++++
    public static BufferedImage getImagemRiscada(BufferedImage imagem) throws Exception {
        for (int i = 0; i < 500; i++) {
            Graphics g = imagem.getGraphics();
            int x = (int)(Math.random() * imagem.getWidth());
            int y = (int)(Math.random() * imagem.getHeight());
            int x2 = (int)(Math.random() * imagem.getWidth());
            int y2 = (int)(Math.random() * imagem.getHeight());
            g.drawLine(x, y, x2, y2);
        }
        return imagem;
    }
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++
    public static BufferedImage getImagemRedimensionada(BufferedImage imagem, double fatorDeEscala) throws Exception {
        int largura = (int)(imagem.getWidth() * fatorDeEscala);
        int altura = (int)(imagem.getHeight() * fatorDeEscala);
        BufferedImage imagemRedimensionada = new BufferedImage(largura, altura, imagem.getType());
        imagemRedimensionada.getGraphics().drawImage(imagem, 0, 0, largura, altura, null);
        return imagemRedimensionada;
    }
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static BufferedImage aplicaBlur(BufferedImage imagemOriginal) throws Exception {
        BufferedImage imagemResultante = new BufferedImage(imagemOriginal.getWidth(), imagemOriginal.getHeight(), imagemOriginal.getType());
        
        //código retirado da internet: http://www.jhlabs.com/ip/blurring.html
        final int TAM = 400;
        float[] data = new float[TAM];
        for (int i = 0; i < TAM; i++) {
            data[i] = 1.0f/TAM;
        }

        Kernel kernel = new Kernel(3, 3, data);
        ConvolveOp convolve = new ConvolveOp( new Kernel(TAM/10/2, TAM/10/2, data), ConvolveOp.EDGE_NO_OP, null );
        convolve.filter(imagemOriginal, imagemResultante);
        return imagemResultante;
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++
}
