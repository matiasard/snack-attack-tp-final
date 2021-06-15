/**
 * 
 */
package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Office;
import ar.edu.unju.fi.repository.OfficeRepository;
import ar.edu.unju.fi.service.IOfficeService;

/**
 * @author Enzo Sandoval
 *
 */
@Service
public class OfficeServiceImp implements IOfficeService {

	private static final Log LOGGER = LogFactory.getLog(OfficeServiceImp.class);

	@Autowired
	private OfficeRepository officeRepository;

	
	@Override
	public List<Office> obtenterOficinas() {
		LOGGER.info("SERVICE: OfficeService");
		LOGGER.info("METHOD: obtenerOficinas()");
		List<Office> oficinas = new ArrayList<>();
		officeRepository.findAll().forEach(oficinas::add);
		LOGGER.info("METHOD: Lista tamaño: " +  oficinas.size());
		return oficinas;
	}

}
