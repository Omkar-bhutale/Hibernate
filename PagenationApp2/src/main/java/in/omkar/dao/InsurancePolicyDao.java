package in.omkar.dao;

import java.util.List;

import in.omkar.modal.InsurancePolicy;

public interface InsurancePolicyDao {
	public List<InsurancePolicy> getPageData(int pageSize,int startPos);

	Long getTotalRecordCount();
}
