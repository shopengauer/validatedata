package com.pavlovens.validatedata;

import com.pavlovens.validatedata.domain.CashManContract;
import com.pavlovens.validatedata.domain.PublishedContract;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidatedataApplicationTests {


	@Qualifier("conversionService")
	@Autowired
	private ConversionService conversionService;

	@Test
	public void canConversionTest() {
	   Assert.assertTrue(conversionService.canConvert(PublishedContract.class, CashManContract.class));
	}

	@Test
	public void conversionTest() throws Exception {

	}
}
