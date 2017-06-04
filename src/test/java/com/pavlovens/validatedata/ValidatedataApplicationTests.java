package com.pavlovens.validatedata;

import com.pavlovens.validatedata.domain.CashManContract;
import com.pavlovens.validatedata.domain.PublishedContract;
import com.pavlovens.validatedata.validateexecutable.CommissionService;
import com.pavlovens.validatedata.validateexecutable.ICommissionService;
import com.pavlovens.validatedata.validator.ContractValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

import static com.pavlovens.validatedata.domain.ContractKeys.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidatedataApplicationTests {


	@Qualifier("conversionService")
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private ContractValidationService contractValidationService;
	@Autowired
	private ICommissionService commissionService;


	@Test
	public void canConversionTest() {
	   assertTrue(conversionService.canConvert(PublishedContract.class, CashManContract.class));
	}

	@Test
	public void conversionTest() throws Exception {
       PublishedContract publishedContract = new PublishedContract();
       publishedContract.setDynamicParam(CM_AgreementId,100L);
	   publishedContract.setDynamicParam(CM_OrgType,"Public");
	   publishedContract.setDynamicParam(CM_OrgId,1234L);
	   publishedContract.setDynamicParam(CM_BankBIC,"1111111");
	   publishedContract.setDynamicParam(CM_BankCodeCom,"2222222");
	   publishedContract.setDynamicParam(CM_OrgAccountComNum,"987654321");
       CashManContract contract = conversionService.convert(publishedContract,CashManContract.class);
       assertEquals(Long.valueOf(100L),contract.getAgreementId());
       assertEquals(Long.valueOf(1234L),contract.getOrgId());
       assertEquals("Public",contract.getOrgType());
       assertEquals("1111111",contract.getBankBIC());
       assertEquals("2222222",contract.getBankCodeCom());
       assertEquals("987654321",contract.getOrgAccountComNum());

       assertEquals(0, contractValidationService.validateContract(contract).size());
       assertEquals(0, contractValidationService.validateContractProperty(contract,"agreementId").size());

	   assertEquals(0, contractValidationService.validateContractValue("orgId",100L).size());
	   assertEquals(0, contractValidationService.validateContractValue("orgType","Public").size());


	}

	@Test
	public void conversionNullPropertiesTest() throws Exception {
		PublishedContract publishedContract = new PublishedContract();
		CashManContract contract = conversionService.convert(publishedContract,CashManContract.class);
		assertNull(contract.getAgreementId());
		assertNull(contract.getOrgId());
		assertNull(contract.getOrgType());
		assertNull(contract.getBankBIC());
		assertNull(contract.getBankCodeCom());
		assertNull(contract.getOrgAccountComNum());

		assertEquals(3, contractValidationService.validateContract(contract).size());
		assertEquals(1, contractValidationService.validateContractProperty(contract,"agreementId").size());
		assertEquals(1, contractValidationService.validateContractProperty(contract,"orgId").size());
		assertEquals(1, contractValidationService.validateContractProperty(contract,"orgType").size());

		assertEquals(1, contractValidationService.validateContractValue("orgId",null).size());
		assertEquals(1, contractValidationService.validateContractValue("orgType",null).size());

		System.out.println(contractValidationService.validateContract(contract));

	}


	@Test
	public void methodParameterValidationTest(){
		CashManContract contract = new CashManContract();
		try{
			commissionService.checkForCommission(null);
		}catch (ConstraintViolationException e){
			e.getConstraintViolations().forEach(constraintViolation -> System.out.println(constraintViolation.getMessage()));
		}

		try{
			commissionService.checkForCommission(contract);
		}catch (ConstraintViolationException e){
			e.getConstraintViolations().forEach(constraintViolation -> System.out.println(constraintViolation.getMessage()));
		}


	}
}
