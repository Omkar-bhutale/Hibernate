package in.omkar.modal;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
@Entity
public class JobSeeker implements Serializable {

	@Override
	public String toString() {
		return "JobSeeker [jsId=" + jsId + ", jsName=" + jsName + ", jsAddress=" + jsAddress + ", photo="
				+ Arrays.toString(photo) + ", resume=" + Arrays.toString(resume) + "]";
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jsId;
	private String jsName;
	private String jsAddress;
	
	@Lob
	private byte[] photo;
	@Lob
	private char[] resume;

	/**
	 * @return the jsId
	 */
	public Integer getJsId() {
		return jsId;
	}

	/**
	 * @param jsId the jsId to set
	 */
	public void setJsId(Integer jsId) {
		this.jsId = jsId;
	}

	/**
	 * @return the jsName
	 */
	public String getJsName() {
		return jsName;
	}

	/**
	 * @param jsName the jsName to set
	 */
	public void setJsName(String jsName) {
		this.jsName = jsName;
	}

	/**
	 * @return the jsAddress
	 */
	public String getJsAddress() {
		return jsAddress;
	}

	/**
	 * @param jsAddress the jsAddress to set
	 */
	public void setJsAddress(String jsAddress) {
		this.jsAddress = jsAddress;
	}

	/**
	 * @return the photo
	 */
	public byte[] getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	/**
	 * @return the resume
	 */
	public char[] getResume() {
		return resume;
	}

	/**
	 * @param resume the resume to set
	 */
	public void setResume(char[] resume) {
		this.resume = resume;
	}
}
