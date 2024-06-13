package in.omkar.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class AddressInfo implements Serializable {


	private static final long serialVersionUID = 1L;
	@Column(length = 20)
	private String countryName;
	@Column(length = 20)
	private String stateName;
	@Column(length = 20)
	private String cityName;


	
	
	public AddressInfo() {
		super();
	}


	public AddressInfo(String countryName, String stateName, String cityName) {
		super();
		this.countryName = countryName;
		this.stateName = stateName;
		this.cityName = cityName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	
	public String getStateName() {
		return stateName;
	}

	
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	
	public String getCityName() {
		return cityName;
	}

	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "AddressInfo [countryName=" + countryName + ", stateName=" + stateName + ", cityName=" + cityName + "]";
	}
}
