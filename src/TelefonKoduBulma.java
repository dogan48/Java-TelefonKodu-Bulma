import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TelefonKoduBulma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Telefon Numarasý giriniz: ");
		Scanner scanner = new Scanner(System. in);
		String telefonNo = scanner. nextLine();
		telefonNo = telefonNoHazirla(telefonNo);
		if(!telefonNo.equals("-1")) {
			String telefonKodu = telefonNo.substring(0, 3);// ülke kodunu attýktan sonra ilk 3 hane tel. kodu
			System.out.print(telefonNo);
			System.out.println(" | " + telefonKodu + " : " + telefonKoduBul(telefonKodu));
		
		}else {
			System.err.println("Eksik Numara girdiniz.");
		}
		

	}
	
	public static String telefonNoHazirla(String tel) {
		
		tel = tel.replaceAll(" ", "");
		tel = tel.replace("+90", "");
		if(tel.startsWith("0"))
			tel = tel.substring(1, tel.length());
		   
		if(tel.length() < 10)
			return "-1";
		return tel;
	}
	
	public static String telefonKoduBul(String telKodu) {
		File file = new File("TelefonKodlari.txt");
		
		try {
			FileReader fileReader = new FileReader(file);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fileReader);
			String line,temp[];
			while ((line = br.readLine()) != null) {
				temp = line.split(" ");
				if(telKodu.equals(temp[0])) 
					return temp[1];
			}
		br.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return "Telefon Kodu Bulunamadi";
	}

}
