package dev.sgp.entite;

public enum TypeCollabEvt {
	CREATION_COLLAB("Création d'un Nouveau Collaborateur"),
	MODIFICATION_COLLAB ("Modification d'un Collaborateur");

	private final String name;       

    private TypeCollabEvt(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false 
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
}
