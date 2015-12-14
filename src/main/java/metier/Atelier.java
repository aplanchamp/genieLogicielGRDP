package metier;

public class Atelier {

	private String name, description, lieu, responsable, date, heure1, heure2;
	private int nbPlace;
	
	public Atelier(String name, String description, String lieu, String responsable, String date, String heure1,
			String heure2, int nbPlace) {
		super();
		this.name = name;
		this.description = description;
		this.lieu = lieu;
		this.responsable = responsable;
		this.date = date;
		this.heure1 = heure1;
		this.heure2 = heure2;
		this.nbPlace = nbPlace;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((heure1 == null) ? 0 : heure1.hashCode());
		result = prime * result + ((heure2 == null) ? 0 : heure2.hashCode());
		result = prime * result + ((lieu == null) ? 0 : lieu.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + nbPlace;
		result = prime * result + ((responsable == null) ? 0 : responsable.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atelier other = (Atelier) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (heure1 == null) {
			if (other.heure1 != null)
				return false;
		} else if (!heure1.equals(other.heure1))
			return false;
		if (heure2 == null) {
			if (other.heure2 != null)
				return false;
		} else if (!heure2.equals(other.heure2))
			return false;
		if (lieu == null) {
			if (other.lieu != null)
				return false;
		} else if (!lieu.equals(other.lieu))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nbPlace != other.nbPlace)
			return false;
		if (responsable == null) {
			if (other.responsable != null)
				return false;
		} else if (!responsable.equals(other.responsable))
			return false;
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHeure1() {
		return heure1;
	}
	public void setHeure1(String heure1) {
		this.heure1 = heure1;
	}
	public String getHeure2() {
		return heure2;
	}
	public void setHeure2(String heure2) {
		this.heure2 = heure2;
	}
	public int getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	
	

}
