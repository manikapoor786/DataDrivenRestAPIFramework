package files;

public enum EnumAPIResource {

	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	private String resource;
	
	private EnumAPIResource(String resource) {
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	
}
