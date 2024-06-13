package in.omkar.service;

import java.util.ArrayList;
import java.util.List;

import in.omkar.dao.InsurancePolicyDao;
import in.omkar.dao.InsurancePolicyDaoImpl;
import in.omkar.dto.InsurancePolicyDTO;
import in.omkar.modal.InsurancePolicy;

public class InsurancePolicyServiceImpl implements InsurancePolicyService{

    private	InsurancePolicyDao iPolicyDao =null;
    public InsurancePolicyServiceImpl() {
    	iPolicyDao = new InsurancePolicyDaoImpl();
    }
	@Override
	public Long fetchPageCount(int pageSize) {
			Long RecordCount = iPolicyDao.getTotalRecordCount();
			Long pagesCount = RecordCount/pageSize;
			if (RecordCount%pageSize!=0) {
				pagesCount++;
			}
			return pagesCount;
	}

	@Override
	public List<InsurancePolicyDTO> fetchPageData(int pageSize, int pageNo) {
		int startPos = 0;
		startPos = (pageNo * pageSize)-pageSize;
		
		List<InsurancePolicy> entities = iPolicyDao.getPageData(pageSize,startPos);
		List<InsurancePolicyDTO> list = new ArrayList<InsurancePolicyDTO>();
		entities.forEach(entity->{
			InsurancePolicyDTO dto = new InsurancePolicyDTO();
			dto.setPolicyId(entity.getPolicyId());
			dto.setCompany(entity.getCompany());
			dto.setPolicyName(entity.getPolicyName());
			dto.setPolicyType(entity.getPolicyType());
			dto.setTenuare(entity.getTenuare());
			list.add(dto);
		});
		return list;
	}

}
