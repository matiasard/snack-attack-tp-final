/**
 * 
 */
package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		LOGGER.info("METHOD: Lista tamaño: " + oficinas.size());
		return oficinas;
	}

	@Override
	public Office buscarOficina(Long id) throws Exception {
		LOGGER.info("SERVICE: OfficeService");
		LOGGER.info("METHOD: buscarOficina()");
		Optional<Office> optional = officeRepository.findById(id);
		Office office = null;
		if (optional.isPresent()) {
			office = optional.get();

		} else {
			throw new Exception("Oficina no encontrada");
		}
		return office;
	}

	@Override
	public void guardar(Office office) {
		LOGGER.info("SERVICE: OfficeService");
		LOGGER.info("METHOD: guardar()");
		officeRepository.save(office);
		LOGGER.info("RESULT: Se guardó la oficina");
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Office> findAll(Pageable pagable) {
		LOGGER.info("SERVICE: OfficeService");
		LOGGER.info("METHOD: findAll()");
		LOGGER.info("RESULT: Página de oficinas");
		return officeRepository.findAll(pagable);
	}

	@Override
	public void borrar(Long id) {
		LOGGER.info("SERVICE: OfficeService");
		LOGGER.info("METHOD: borrar()");
		LOGGER.info("RESULT: ");
		officeRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Office> buscarOficinasPorPais(String pais) {
		LOGGER.info("SERVICE: OfficeService");
		LOGGER.info("METHOD: buscarOficinas()");
		List<Office> oficinas = new ArrayList<Office>();
		if (!pais.isEmpty()) {
			oficinas = officeRepository.findByCountry(pais);
		} 
		LOGGER.info("RESULT: Lista oficinas tamaño: " + oficinas.size());
		return oficinas;
	}

}
