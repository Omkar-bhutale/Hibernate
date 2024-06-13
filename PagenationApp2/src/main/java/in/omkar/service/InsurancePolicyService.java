package in.omkar.service;

import java.util.List;

import in.omkar.dto.InsurancePolicyDTO;
public interface InsurancePolicyService {
	Long fetchPageCount(int pageSize);
	List<InsurancePolicyDTO> fetchPageData(int pageSize,int pageNo);
}
