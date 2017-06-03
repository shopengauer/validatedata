package com.pavlovens.validatedata;

import com.pavlovens.validatedata.domain.CashManContract;
import com.pavlovens.validatedata.domain.PublishedContract;
import com.pavlovens.validatedata.validator.ContractValidatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.junit4.SpringRunner;

import static com.pavlovens.validatedata.domain.ContractKeys.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidatedataApplicationTests {


	@Qualifier("conversionService")
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private ContractValidatorService contractValidatorService;


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

       assertEquals(0,contractValidatorService.validate(contract).size());

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

		assertEquals(3,contractValidatorService.validate(contract).size());
		System.out.println(contractValidatorService.validate(contract));

	}
}
