package main.java.app.com.services;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Service {
	
	public long dayDifference(Date fechInicio, Date fechFin) {
		long differenceInMillis = fechInicio.getTime() - fechFin.getTime();
		long differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24);
		return differenceInDays;
	}
	
	public String tripCodeToTypeConverter(String code) {
		String ret = null;
		switch (code) {
		case "B1":
			ret = "Parejas";
			break;
		case "B2":
			ret = "Mayores";
			break;
		case "B3":
			ret = "Grupos";
			break;
		case "B4":
			ret = "Grandes viajes (destinos exóticos + vuelo + alojamiento)";
			break;
		case "B5":
			ret = "Escapada";
			break;
		default:
			ret = "algo esta mal";
		}
		return ret;
	}

	public String tripTypeToCodeConverter(String type) {
		String ret = null;
		switch (type) {
		case "Parejas":
			ret = "B1";
			break;
		case "Mayores":
			ret = "B2";
			break;
		case "Grupos":
			ret = "B3";
			break;
		case "Grandes viajes (destinos exóticos + vuelo + alojamiento)":
			ret = "B4";
			break;
		case "Escapada":
			ret = "B5";
			break;
		default:
			ret = "algo esta mal";
		}
		return ret;
	}

    public boolean isDate(String date) {
        String datePattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(datePattern );
    }
	
    public boolean isTime(String time) {
    	String timePattern = "^([01]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])$";
        return time.matches(timePattern);
    }
    
    public boolean isNumber(String number) {
        String numberPattern = "^[-+]?[0-9]*\\.?[0-9]+$";
        return number.matches(numberPattern);
    }

	public void changeImage(JLabel label, String imageUrl) {
		try {
			URL url = new URL(imageUrl);

			Image logo = ImageIO.read(url);

			ImageIcon logoIcon = resizeImageToLabel(label, logo);

			label.setIcon(logoIcon);

		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading image: " + e.getMessage());
		}
	}
	
	public ImageIcon resizeImageToLabel(JLabel label, Image image) {
		Image resizedImage = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(resizedImage);
		return imageIcon;
	}
	
   public Color getComplementaryColor(String hexColor) {

	   Color originalColor = Color.decode(hexColor);

        int r = originalColor.getRed();
        int g = originalColor.getGreen();
        int b = originalColor.getBlue();

        int complementR = 255 - r;
        int complementG = 255 - g;
        int complementB = 255 - b;

        return new Color(complementR, complementG, complementB);
    }
	
	public boolean colorCodeEvaluator(String inputColor) {
		String colorRegex = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
		return inputColor.matches(colorRegex);
	}
	
	public boolean urlCodeEvaluator(String inputURL) {
		String urlRegex = "^(https?|ftp)://[^\s/$.?#].[^\s]*$";
		return inputURL.matches(urlRegex);
	}
	
	public String incrementString(String input) {
		String prefix = input.replaceAll("[0-9]", "");
		String numberPart = input.replaceAll("[^0-9]", "");
		int number = Integer.parseInt(numberPart) + 1;
		String newNumberPart = String.format("%0" + numberPart.length() + "d", number);
		return prefix + newNumberPart;
	}
	
	public void spinnerReseter(JSpinner spinner) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		spinner.setValue(calendar.getTime());
	}
	
	public String getMaxId(String id1, String id2, String id3) {
		String maxId = id1;

		if (id2 != null && (maxId == null || id2.compareTo(maxId) > 0)) {
			maxId = id2;
		}
		if (id3 != null && (maxId == null || id3.compareTo(maxId) > 0)) {
			maxId = id3;
		}
		return maxId;
	}
	
	public void limitField(JTextField field, int num) {
		field.setDocument(new PlainDocument() {
			private static final long serialVersionUID = 1L;

			@Override
			public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
				if (str != null && (getLength() + str.length()) <= num) {
					super.insertString(offset, str, attr);
				}
			}
		});
	}
	
	public String getIataCode(String airportNameAndCity) {
	    airportNameAndCity = airportNameAndCity.toUpperCase();
	    switch (airportNameAndCity) {
	        case "ACA - MÉXICO (ACAPULCO)":
	            return "ACA";
	        case "ACE - LANZAROTE":
	            return "ACE";
	        case "AGP - MÁLAGA":
	            return "AGP";
	        case "ALC - ALICANTE":
	            return "ALC";
	        case "AMM - JORDANIA (AMMÁN)":
	            return "AMM";
	        case "AMS - HOLANDA (ÁMSTERDAM)":
	            return "AMS";
	        case "ATH - GRECIA (ATENAS)":
	            return "ATH";
	        case "BCN - BARCELONA":
	            return "BCN";
	        case "BER - ALEMANIA (BERLÍN)":
	            return "BER";
	        case "BIO - BILBAO":
	            return "BIO";
	        case "BJZ - BADAJOZ":
	            return "BJZ";
	        case "BKK - TAILANDIA (BANGKOK)":
	            return "BKK";
	        case "BOG - COLOMBIA (BOGOTÁ)":
	            return "BOG";
	        case "BOS - BOSTON":
	            return "BOS";
	        case "BRU - BÉLGICA (BRUSELAS)":
	            return "BRU";
	        case "BSB - BRASIL (BRASILIA)":
	            return "BSB";
	        case "BUE - ARGENTINA (BUENOS AIRES)":
	            return "BUE";
	        case "CAI - EGIPTO (EL CAIRO)":
	            return "CAI";
	        case "CAS - MARRUECOS (CASABLANCA)":
	            return "CAS";
	        case "CDG - FRANCIA (PARÍS, CHARLES DE GAULLE)":
	            return "CDG";
	        case "CPH - DINAMARCA (COPENHAGUE)":
	            return "CPH";
	        case "DUB - IRLANDA (DUBLÍN)":
	            return "DUB";
	        case "DUS - ALEMANIA (DÜSSELDORF)":
	            return "DUS";
	        case "EAS - SAN SEBASTIÁN":
	            return "EAS";
	        case "FRA - ALEMANIA (FRÁNCFORT)":
	            return "FRA";
	        case "GVA - SUIZA (GINEBRA)":
	            return "GVA";
	        case "HAM - ALEMANIA (HAMBURGO)":
	            return "HAM";
	        case "HEL - FINLANDIA (HELSINKI)":
	            return "HEL";
	        case "HOU - HOUSTON":
	            return "HOU";
	        case "IST - TURQUÍA (ESTAMBUL)":
	            return "IST";
	        case "JFK - NUEVA YORK (JFK)":
	            return "JFK";
	        case "LAX - LOS ÁNGELES":
	            return "LAX";
	        case "LHR - REINO UNIDO (HEATHROW)":
	            return "LHR";
	        case "LIM - PERÚ (LIMA)":
	            return "LIM";
	        case "MAD - MADRID":
	            return "MAD";
	        case "MEX - MÉXICO (CIUDAD DE MÉXICO)":
	            return "MEX";
	        case "MUC - ALEMANIA (MÚNICH)":
	            return "MUC";
	        case "NBO - KENIA (NAIROBI)":
	            return "NBO";
	        case "ORY - FRANCIA (PARÍS, ORLY)":
	            return "ORY";
	        case "OSL - NORUEGA (OSLO)":
	            return "OSL";
	        case "PMI - PALMA DE MALLORCA":
	            return "PMI";
	        case "PRG - REPÚBLICA CHECA (PRAGA)":
	            return "PRG";
	        case "RAK - MARRUECOS (MARRAKECH)":
	            return "RAK";
	        case "SFO - SAN FRANCISCO":
	            return "SFO";
	        case "SYD - AUSTRALIA (SÍDNEY)":
	            return "SYD";
	        case "TFN - TENERIFE NORTE":
	            return "TFN";
	        case "TFS - TENERIFE SUR":
	            return "TFS";
	        case "ZRH - SUIZA (ZÚRICH)":
	            return "ZRH";
	        default:
	            return "UNK";
	    }
	}


}
