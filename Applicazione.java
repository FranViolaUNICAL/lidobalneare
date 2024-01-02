package lidobalneare;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;


public class Applicazione {
	public static void start() throws InterruptedException {
		String s = "Avvio Applicazione Gestione Lido";
		char[] l = s.toCharArray();
		for(char c : l) {
			System.out.print(c);
			TimeUnit.MILLISECONDS.sleep(20);
		}
		System.out.println("\r");
		
	}
	
	public static void salva(AbstractLidoBalneare lido) throws IOException {
		File fo = new File("C:\\Users\\Public\\Lido.dat");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fo));
		out.writeObject(lido);
		out.close();
	}
	
	public static void main(String[] args) throws InterruptedException, IllegalArgumentException, IOException, ClassNotFoundException {
		start();
		boolean finito = false;
		AbstractLidoBalneare lido = null;
		Scanner sc = new Scanner(System.in);
		while(!finito) {
			System.out.println("Gestisci il tuo lido!");
			System.out.println("Seleziona un opzione digitando un numero:");
			System.out.println("1) Genera un lido vuoto.");
			System.out.println("2) Carica un lido salvato.");
			System.out.println("3) Salva il lido corrente.");
			System.out.println("4) Prenota un ombrellone.");
			System.out.println("5) Prenota un ombrellone a caso.");
			System.out.println("6) Mostra Status Lido.");
			System.out.println("7) Esci senza salvare.");
			System.out.println("8) Salva ed esci.");

			int scelta = sc.nextInt();
			int numeroScelte = 10;
			if(scelta > numeroScelte) {
				throw new IllegalArgumentException("Input Errato, Riavviare.");
			}
			switch(scelta) {
			
			case 1:
				int file;
				int ombrelloniPerFila;
				System.out.println("Scegli Numero File:");
				file = sc.nextInt();
				System.out.println("Scegli Numero Ombrelloni Per Fila:");
				ombrelloniPerFila = sc.nextInt();
				lido = new ImplementedLidoBalneare(file,ombrelloniPerFila);
				System.out.println("Lido Creato!");
				break;
			
			
			case 2:
				File fi = new File("C:\\Users\\Public\\Lido.dat");
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(fi));
				lido=(AbstractLidoBalneare)in.readObject();
				in.close();
				break;
			
			
			case 3:
				salva(lido);
				break;
			
			case 4:
				System.out.println("Seleziona fila:");
				int f = sc.nextInt();
				System.out.println("Seleziona Ombrellone nella fila:");
				int o = sc.nextInt();
				Posizione p = new Posizione(f,o);
				lido.prenotaOmbrellone(p);
				System.out.println("Prenotato!");
				break;
				
			case 5:
				System.out.println("Prenotato ombrellone in posizione:");
				System.out.println(lido.prenotaUnOmbrelloneRandom());
				break;
				
			case 6:
				System.out.println(lido);
				break;
			
			case 7:
				String s = "Chiusura in corso...";
				char[] l = s.toCharArray();
				for(char c : l) {
					System.out.print(c);
				}
				System.out.println("\r");
				System.out.println("Arrivederci!");
				finito = true;
				break;
				
			case 8:
				salva(lido);
				String s1 = "Chiusura in corso...";
				char[] l1 = s1.toCharArray();
				for(char c : l1) {
					System.out.print(c);
					TimeUnit.MILLISECONDS.sleep(20);
				}
				System.out.print('\r');
				System.out.println("Arrivederci!");
				finito = true;
				break;
			}
			

		}
	}
}
