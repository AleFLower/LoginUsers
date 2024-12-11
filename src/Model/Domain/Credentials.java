package Model.Domain;

public class Credentials {  //modello prima le entity, che avranno getter e setter.
	
	private String username; //per convenzione, attributi privati e poi hanno getter e setter
	private String password;
	private Role role;    //associazione con il model (entity) role, in java si traduce cosi
	
	public Credentials(String username, String password, Role role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return this.username;     // è bene sempre mettere this dove compare
	}
	public String getPassword() {
		return this.password;
	}
	
	public Role getRole() {
		return this.role;
	}
	
	
	
}
