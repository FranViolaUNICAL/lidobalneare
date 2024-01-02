package lidobalneare;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

public class ImplementedLidoBalneare extends AbstractLidoBalneare implements Serializable {

	public static final int serialVersionUID = 1;
	private Map<Posizione,Boolean> PosizioneOccupati;
	
	public ImplementedLidoBalneare(int r, int c) {
		super(r,c);
		PosizioneOccupati = new HashMap<>();
		for(int i = 0; i < r ; i++) {
			for(int j = 0; j < c; j++) {
				Posizione p = new Posizione(i,j);
				PosizioneOccupati.put(p, false);
			}
		}
	}
	
	@Override
	public void liberaOmbrellone(Posizione p) throws IllegalStateException {
		if(!PosizioneOccupati.containsKey(p)) {
			throw new IllegalStateException();
		}
		PosizioneOccupati.put(p, false);
	}

	@Override
	public boolean eLibero(Posizione p) {
		return !PosizioneOccupati.get(p);
	}

	@Override
	public void prenotaOmbrellone(Posizione p) throws IllegalStateException {
		if(PosizioneOccupati.get(p) || p.getC() > numeroOmbrelloniPerFila() || p.getR() > numeroFileOmbrelloni()) {
			throw new IllegalStateException();
		}
		PosizioneOccupati.put(p, true);
	}

}
