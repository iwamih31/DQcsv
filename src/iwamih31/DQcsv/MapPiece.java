package iwamih31.DQcsv;

public class MapPiece {
	private String image;
	private int role;

	public MapPiece(String image, int role) {
		this.image = image;
		this.role = role;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}
