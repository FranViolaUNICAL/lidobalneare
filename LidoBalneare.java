package lidobalneare;

import java.io.Serializable;
import java.util.LinkedList;

public interface LidoBalneare extends Serializable {
	/* Libera un ombrellone precedentemente occupato*/
	abstract void liberaOmbrellone(Posizione p) throws IllegalStateException;
	
	/*Libera tutte le posizioni*/
	default void liberaTuttigliOmbrelloni() {
		for(int i = 0; i < numeroFileOmbrelloni(); i++) {
			for(int j = 0; j < numeroOmbrelloniPerFila(); j++) {
				Posizione p = new Posizione(i,j);
				if(!eLibero(p)) {
					liberaOmbrellone(p);
				}
			}
		}
	}
	
	/*Restituisce se un dato ombrellone è occupato o no*/
	abstract boolean eLibero(Posizione p);
	
	/*Restituisce le posizioni degli ombrelloni occupati*/
	default Posizione[] ombrelloniOccupati() {
		LinkedList<Posizione> liberi = new LinkedList<>();
		for(int i = 0; i < numeroFileOmbrelloni(); i++) {
			for(int j = 0; j < numeroFileOmbrelloni(); j++) {
				Posizione p = new Posizione(i,j);
				if(!eLibero(p)) {
					liberi.add(p);
				}
			}
		}
		return liberi.toArray(new Posizione[0]);
	}
	
	
	/*Restituisce le posizioni degli ombrelloni liberi*/
	default Posizione[] ombrelloniLiberi() {
		LinkedList<Posizione> liberi = new LinkedList<>();
		for(int i = 0; i < numeroFileOmbrelloni(); i++) {
			for(int j = 0; j < numeroFileOmbrelloni(); j++) {
				Posizione p = new Posizione(i,j);
				if(eLibero(p)) {
					liberi.add(p);
				}
			}
		}
		return liberi.toArray(new Posizione[0]);
	}
	
	/*Restituisce il numero di file di ombrelloni nello stabilimento*/
	abstract int numeroFileOmbrelloni();
	
	/*Restituisce il numero di ombrelloni presenti per ogni fila*/
	abstract int numeroOmbrelloniPerFila();	
	
	/*Prenota un ombrellone nella posizione specificate, se la posizione già occupata solleva una eccezione */
	abstract void prenotaOmbrellone(Posizione p) throws IllegalStateException;
	
	/*Prenota un ombrellone in modo random, se nessuna posizione e' libera, solleva una eccezione */
	default Posizione prenotaUnOmbrelloneRandom() throws IllegalStateException{
		Posizione[] liberi = ombrelloniLiberi();
		if(ombrelloniLiberi().length < 1) {
			throw new IllegalStateException();
		}
		int i = (int)Math.random()*ombrelloniLiberi().length;
		prenotaOmbrellone(liberi[i]);
		return liberi[i];
	}
}
