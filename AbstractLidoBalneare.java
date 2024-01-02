package lidobalneare;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public abstract class AbstractLidoBalneare implements Serializable, LidoBalneare {
	
	private int r,c;
	
	public AbstractLidoBalneare(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	@Override
	public abstract void liberaOmbrellone(Posizione p) throws IllegalStateException;

	@Override
	public abstract boolean eLibero(Posizione p);

	@Override
	public int numeroFileOmbrelloni() {
		return r;
	}

	@Override
	public int numeroOmbrelloniPerFila() {
		return c;
	}

	@Override
	abstract public void prenotaOmbrellone(Posizione p) throws IllegalStateException;
	
	@Override
	public int hashCode() {
		return Objects.hash(c, r);
	}

	@Override
	public boolean equals(Object o) {
		if(o.getClass() != getClass()) {
			return false;
		}
		if(o == this) {
			return true;
		}
		AbstractLidoBalneare other = (AbstractLidoBalneare) o;
		Set<Posizione> check = new HashSet<>();
		for(Posizione p : ombrelloniOccupati()) {
			check.add(p);
		}
		for(Posizione p : other.ombrelloniOccupati()) {
			if(check.contains(p)) {
				check.remove(p);
			}
		}
		if(!check.isEmpty()) return false;
		for(Posizione p : ombrelloniLiberi()) {
			check.add(p);
		}
		for(Posizione p : other.ombrelloniLiberi()) {
			if(check.contains(p)) {
				check.remove(p);
			}
		}
		return check.isEmpty() && other.numeroFileOmbrelloni() == r && other.numeroOmbrelloniPerFila() == c;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(r).append('\n');
		sb.append(c).append('\n');
		for(Posizione p : ombrelloniOccupati()) {
			sb.append(p.toString()).append('\n');
		}
		return sb.toString();
	}
	
	

}
