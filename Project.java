public class Project {
	String path;
	
	public Project(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return this.path;
	}
	
	public String str() {
		return "Project object with path: " + this.path;
	}

	public void print() {
		System.out.println(this.str());
	}	
}