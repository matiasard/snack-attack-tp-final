package ar.edu.unju.fi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.entity.Office;
import ar.edu.unju.fi.service.IOfficeService;

@SpringBootTest
class OfficeTest {

	@Autowired
	IOfficeService officeService;
	
	
	@Test
	void test() {
		
		Office office = new Office();
		office.setCode((long) 8);
		office.setAddressLine1("127 Wall St");
		office.setAddressLine2("Suite 11");
		office.setCity("Los Angeles");
        office.setCountry("USA");
		office.setPhone("+1 200 112 1234");
		office.setPostalCode("90001");
		office.setState("CA");
		office.setTerritory("NA");
		officeService.guardar(office);
		
		assertEquals("Los Angeles",office.getCity());
	}

}
