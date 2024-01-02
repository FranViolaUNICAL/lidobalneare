package lidobalneare;

import java.io.Serializable;
import java.util.Objects;

public class Posizione implements Serializable {
	
	public static final int serialVersionUID = 1;
	
	int r,c;
	
	public Posizione(int r, int c) {
		this.r = r;
		this.c = c;
	}

	public int getR() {
		return r;
	}

	public int getC() {
		return c;
	}

	public void setR(int r) {
		this.r = r;
	}

	public void setC(int c) {
		this.c = c;
	}

	@Override
	public int hashCode() {
		return Objects.hash(c, r);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posizione other = (Posizione) obj;
		return c == other.c && r == other.r;
	}
	
	@Override
	public String toString() {
		return ""+r+";"+c;
	}
	
	
	
	
}
